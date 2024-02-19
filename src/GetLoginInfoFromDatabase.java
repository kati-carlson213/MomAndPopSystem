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

public class GetLoginInfoFromDatabase {

    public static String decrypt(byte[] ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }



    private static void GetFromTable(MainFrame mainFrame, String username, String password, Connection connection, Login login) {
        Hashing hashing = new Hashing();


        try {
            // Execute a SELECT query
            String selectQuery = "SELECT * FROM loginTable";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the retrieved data
            while (resultSet.next()) {
                // Retrieve data by column name or index
                String dbID = resultSet.getString("id");
                login.setID(dbID);

                String dbUsername = resultSet.getString("Username");
                String dbPassword = resultSet.getString("Password");
                String dbSalt = resultSet.getString("Salt");

                byte[] decodedSalt = Base64.getDecoder().decode(dbSalt);

                password = hashing.hashPassword(password, decodedSalt);


                if (dbUsername.equals(username)) {
                    if (dbPassword.equals(password))  {
                        login.setID(resultSet.getString("id"));
                        login.wasLoginSuccessful(true);
                    }
                    else {
                        login.wasLoginSuccessful(false);
                    }
                    break;
                }

            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was an error when trying to fetch login information.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }



    public GetLoginInfoFromDatabase(MainFrame mainFrame, String tableUsername, String tablePassword,  Login login) {

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


            GetFromTable(mainFrame, tableUsername, tablePassword,  connection, login);


            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "There was an error trying to connect to the database.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }
}

class Hashing {

    public static String hashPassword(String password, byte[] salt) {
        try {
            // Create an instance of MessageDigest for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Append salt to the password before hashing
            byte[] combined = new byte[password.getBytes().length + salt.length];
            System.arraycopy(password.getBytes(), 0, combined, 0, password.getBytes().length);
            System.arraycopy(salt, 0, combined, password.getBytes().length, salt.length);

            // Get the hash bytes by applying hashing on the combined bytes (password + salt)
            byte[] hashBytes = digest.digest(combined);

            String hexString= "";

            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString+='0';
                }
                hexString+=hex;
            }
            return hexString;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

}