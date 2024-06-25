import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class BlowFish {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
            kgen.init(128);
            SecretKey skey = kgen.generateKey();
            Cipher cipher = Cipher.getInstance("Blowfish");
            String inputText;
            if (!java.awt.GraphicsEnvironment.isHeadless()) {
                inputText = javax.swing.JOptionPane.showInputDialog("Input your message:");
            } else {
                System.out.print("Input your message: ");
                inputText = scanner.nextLine();
            }
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] encrypted = cipher.doFinal(inputText.getBytes());
            String encryptedBase64 = Base64.getEncoder().encodeToString(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
            String decryptedText = new String(decrypted);
            System.out.println("\nOriginal message: " + inputText);
            System.out.println("\nEncrypted text (Base64): " + encryptedBase64);
            System.out.println("\nDecrypted text: " + decryptedText);

        } catch (java.awt.HeadlessException e) {
            System.out.println("Running in headless mode. Provide input through command line.");
            System.out.print("Input your message: ");
            if (scanner.hasNextLine()) {
                String inputText = scanner.nextLine();

                try {
                    KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
                    kgen.init(128);
                    SecretKey skey = kgen.generateKey();
                    Cipher cipher = Cipher.getInstance("Blowfish");
                    cipher.init(Cipher.ENCRYPT_MODE, skey);
                    byte[] encrypted = cipher.doFinal(inputText.getBytes());
                    String encryptedBase64 = Base64.getEncoder().encodeToString(encrypted);

                    cipher.init(Cipher.DECRYPT_MODE, skey);
                    byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
                    String decryptedText = new String(decrypted);
                    System.out.println("\nOriginal message: " + inputText);
                    System.out.println("\nEncrypted text (Base64): " + encryptedBase64);
                    System.out.println("\nDecrypted text: " + decryptedText);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
Blow Fish
