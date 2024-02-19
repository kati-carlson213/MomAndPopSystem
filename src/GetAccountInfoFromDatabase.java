import javax.crypto.Cipher;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Properties;

public class GetAccountInfoFromDatabase {

    public static String decrypt(byte[] ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }




    private static void GetFromTable(MainFrame mainFrame, Connection connection, Login login, Variables variableObj) {

        String id = login.getID();


        try {
            // Execute a SELECT query
            String selectQuery = "SELECT * FROM accountInfoTable";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();



            // Process the retrieved data
            while (resultSet.next()) {
                String db_ID = resultSet.getString("id");


                if (db_ID.equals(id)) {
                    String dbFirstName = resultSet.getString("FirstName");
                    String dbLastName = resultSet.getString("LastName");
                    String dbEmail = resultSet.getString("Email");
                    String dbPhoneNumber = resultSet.getString("PhoneNumber");
                    String dbStreetAddress = resultSet.getString("StreetAddress");



                    variableObj.setFirstName(dbFirstName);
                    variableObj.setLastName(dbLastName);
                    variableObj.setEmailAddress(dbEmail);
                    variableObj.setPhoneNum(dbPhoneNumber);
                    variableObj.setStreetAddress(dbStreetAddress);

                    break;
                }
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was an error when trying to fetch account information.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }



    public GetAccountInfoFromDatabase(MainFrame mainFrame, Login login, Variables variableObj) {

        Connection connection = null;

        try {
            // Load configuration from file
            Properties config = new Properties();

            FileInputStream input = new FileInputStream("config/config.properties");
            config.load(input);
            input.close();

            String certificatePath = config.getProperty("server-cert.pem");


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


            GetFromTable(mainFrame, connection, login, variableObj);


            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was an error trying to connect to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }
}