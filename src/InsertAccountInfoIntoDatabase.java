import javax.crypto.Cipher;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Properties;



public class InsertAccountInfoIntoDatabase {

    public static String decrypt(byte[] ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }


    private static void  insertIntoTable (MainFrame mainFrame, String firstName, String lastName,  String email, String phone, String address, Connection connection) {

        try {
            // Prepare the insert statement
            String insertQuery = "INSERT INTO accountInfoTable (FirstName, LastName, Email, PhoneNumber, StreetAddress) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);


            // Set parameters for the prepared statement
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, address);

            // Execute the insert statement
            preparedStatement.executeUpdate();


            // Close the connection and resources
            preparedStatement.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was en error in trying to write your account information to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }





    public InsertAccountInfoIntoDatabase(MainFrame mainFrame, String firstName, String lastName, String email, String phoneNum, String streetAddress) {

        Connection connection = null;

        try {
            // Load configuration from file
            Properties config = new Properties();

            FileInputStream input = new FileInputStream("config/config.properties");
            config.load(input);
            input.close();

            String certificatePath = config.getProperty("server-cert.pem"); // Use the correct key name


            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            FileInputStream fis = new FileInputStream(certificatePath);


            X509Certificate cert = (X509Certificate) certFactory.generateCertificate(fis);


            Properties properties = new Properties();

            try (InputStream configInput = new FileInputStream("config/config.properties")) {
                properties.load(configInput);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(mainFrame, "There was an error trying to connect to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
            }


            // Get values from properties file
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");



            PrivateKey privateKey;


            String decryptedMessage="";
            String decryptedMessage2="";


            try {
                // Read the private key from server-key.pem file
                byte[] keyBytes = Files.readAllBytes(Paths.get("C:\\Users\\katie\\mySQLCertificateFiles\\server-key.pem"));

                // Remove the header and footer from the key file content
                String privateKeyPEM = new String(keyBytes);
                privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "");
                privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
                privateKeyPEM = privateKeyPEM.replaceAll("\\s+", "");

                // Decode Base64 encoded key bytes
                byte[] decodedKey = Base64.getDecoder().decode(privateKeyPEM);

                // Create a PrivateKey object from the decoded key bytes
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
                privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);


                // Decrypt with the private key

                try {
                    // Decode Base64-encoded strings back to byte arrays
                    byte[] encryptedUsernameBytes = Base64.getDecoder().decode(username);
                    byte[] encryptedPasswordBytes = Base64.getDecoder().decode(password);

                    // Decrypt with the private key
                    String decryptedUsername = decrypt(encryptedUsernameBytes, privateKey);

                    username = decryptedUsername;

                    String decryptedPassword = decrypt(encryptedPasswordBytes, privateKey);

                    password = decryptedPassword;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainFrame, "There was an error trying to connect to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "There was an error trying to connect to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
            }


            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("serverSslCert", cert.toString());

            // Establish connection
            String url = "jdbc:mysql://localhost:3306/mom_pop_database";
            connection = DriverManager.getConnection(url, properties);


            insertIntoTable(mainFrame, firstName, lastName, email, phoneNum, streetAddress, connection);



            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was an error trying to connect to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }
}
