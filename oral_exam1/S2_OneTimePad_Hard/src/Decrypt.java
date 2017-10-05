import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Decrypts a message that has been previously encrypted
 */
public class Decrypt {

    /**
     * Shifts the given char back n indexes to the unencrypted char
     *
     * @param c current char in input message
     * @param n number of times to shift back in alphabet array
     * @return character that is n indices before c
     */
    private char convertChar(char c, int n) {

        int index = Encrypt.findIndex(c);
        int k = index;
        if (index == -1)
            return c;

        int newChar = index - n;
        if (newChar < 0) {
            newChar = Math.abs(newChar);
            if(newChar > Encrypt.alphabet.length) {
                newChar = newChar % Encrypt.alphabet.length;
                newChar = Encrypt.alphabet.length - newChar;
            }
//            for(int i = 0; i < n; i++){
//                if( k - i < 0){
//                    k = Encrypt.alphabet.length-1;
//                }
//                newChar = Encrypt.alphabet[k-i];
//            }
        }
        c = Encrypt.alphabet[newChar];
        return c;
    }

    /**
     * Opens the key file and takes in the starting point. Opens the message file and stores the message into a char array.
     * Iterates simultaneously through the char array and key file to convert each char using ConvertChar() method.
     *
     * @param keyFileLocation path of the key file
     * @param messageFileLocation path of the message file
     * @throws FileNotFoundException exception thrown if file isn't found
     */
    public void decryptMessage(String keyFileLocation, String messageFileLocation) throws FileNotFoundException {
        Scanner keyReader, decryptor;
        int StartingPoint;

        keyReader = new Scanner(new File(keyFileLocation));
        decryptor = new Scanner(new File(messageFileLocation));

        StartingPoint = keyReader.nextInt();
        for (int i = 0; i < StartingPoint; i++) //iterate to correct starting index
            keyReader.nextInt();

        String encryptedMessage = decryptor.nextLine(); //take in message as string
        char[] c = new char[encryptedMessage.length()];
        for (int i = 0; i < encryptedMessage.length(); i++) { //put string elements in char array
            c[i] = encryptedMessage.charAt(i);
        }

        for (int i = 0; i < c.length; i++) {
            char d = c[i];

            if (!keyReader.hasNextInt()) { //if scanner reaches the last key, restart at the beginning
                keyReader.close();
                keyReader = new Scanner(new File(keyFileLocation));
                keyReader.nextInt(); //iterate once to skip the startPoint key
            }
            int n = keyReader.nextInt();
            d = convertChar(d, n);
            System.out.print(d);
        }
    }
}
