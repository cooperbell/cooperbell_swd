import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class for main. Prompts user for message to encrypt, number of keys, and path of key file to be put.
 * Encrypts message into a new file that is given to user.
 */
public class Main {
    /**
     * This class acts as the driver program for encrypting and decrypting the message
     *
     * @param args arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String keyFileLocation, message;
        Scanner scan = new Scanner(System.in);
        int n;

        KeyGenerator key = new KeyGenerator();
        Encrypt encrypt = new Encrypt();
        Decrypt decrypt = new Decrypt();

        System.out.println("Enter a message: ");
        message = scan.nextLine();
        message = message.toUpperCase();


        System.out.println("Give a location for the key file: ");
        keyFileLocation = scan.nextLine();

        System.out.println("Specify number of keys: ");
        n = scan.nextInt();

        key.generateKeyFile(n, keyFileLocation);

        encrypt.encryptMessage(message, keyFileLocation);

        //file decrypting starts here
        System.out.print("To decrypt the message, ");
        System.out.println("Specify location for key file: ");
        scan.nextLine();
        keyFileLocation = scan.nextLine();

        System.out.println("Specify location for message file");
        String messageFileLocation = scan.nextLine();

        decrypt.decryptMessage(keyFileLocation, messageFileLocation);

    }

}
