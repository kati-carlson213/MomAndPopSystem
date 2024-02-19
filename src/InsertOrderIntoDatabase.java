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
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Properties;

public class InsertOrderIntoDatabase {


    //in real life application, dont use same key for order table + the login to the database itself, use different keys.
    //i just did it here for simplicitys sake, but.. for security reasons, dont do that when making actual apps
    public static String encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }



    public static String decrypt(String ciphertext, PrivateKey privateKey) throws Exception {
        byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(ciphertextBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }


    private static void  insertIntoTable (MainFrame mainFrame, String order, String creditCard, Connection connection) {

        try {
            // Load the certificate (public key) from server-cert.pem file
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            FileInputStream fis = new FileInputStream("C:\\Users\\katie\\IdeaProjects\\SQL_DatabaseConnection\\server-cert.pem");

            X509Certificate cert = (X509Certificate) certFactory.generateCertificate(fis);
            fis.close();

            // Get the public key from the certificate
            PublicKey publicKey = cert.getPublicKey();


            // Encrypt with the public key
            creditCard = encrypt(creditCard, publicKey);


            try {
                // Prepare the insert statement
                String insertQuery = "INSERT INTO orderTable (OrderDetails, CreditCard) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);


                // Set parameters for the prepared statement
                preparedStatement.setString(1, order);
                preparedStatement.setString(2, creditCard);


                // Execute the insert statement
                preparedStatement.executeUpdate();


                // Close the connection and resources
                preparedStatement.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "There was an error in trying to write your order information to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was an error in trying to write your order information to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
        }




    }





    public InsertOrderIntoDatabase(MainFrame mainFrame, String order, String creditCard) {

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

                    // Decrypt with the private key
                    String decryptedUsername = decrypt(username, privateKey);

                    username = decryptedUsername;

                    String decryptedPassword = decrypt(password, privateKey);

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


            insertIntoTable(mainFrame, order, creditCard, connection);



            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was an error trying to connect to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }
}
