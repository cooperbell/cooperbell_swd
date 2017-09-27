import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decrypt {

    /**
     * This convertChar shifts the given char back n indexes to the unencrypted char
     *
     * @param c current char in input message
     * @param n number of times to shift back in alphabet array
     * @return character that is n indices before c
     */
    private char convertChar(char c, int n) {

        int index = Encrypt.findIndex(c);
        if (index == -1)
            return c;

        int newChar = index - n;
        if (newChar < 0) {
            int buffer = Math.abs(index - n);
            newChar = buffer % Encrypt.alphabet.length;
        }
            c = Encrypt.alphabet[newChar];
            return c;
    }

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
        for(int i = 0; i < encryptedMessage.length(); i++){ //put string elements in char array
            c[i] = encryptedMessage.charAt(i);
        }



        for (int i = 0; i < c.length; i++) {
            char d = c[i];

            if(!keyReader.hasNextInt()){ //if scanner reaches the last key, restart at the beginning
                keyReader.close();
                keyReader = new Scanner(new File(keyFileLocation));
                keyReader.nextInt(); //iterate once to skip the startPoint key
            }
            int n = keyReader.nextInt();
            d = convertChar(d, n);
            System.out.print(d);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        Decrypt decrypt = new Decrypt();
//        Scanner scan = new Scanner(System.in), keyReader, decryptor;
//        int StartingPoint;
//
////        System.out.println("Specify location for key file: ");
////        String keyFileLocation = scan.nextLine();
////
////        System.out.println("Specify location for message file");
////        String messageFileLocation = scan.nextLine();
//
////        keyReader = new Scanner(new File(keyFileLocation));
////        decryptor = new Scanner(new File(messageFileLocation));
//
//        //TODO: Could this be put into functions?
//        StartingPoint = keyReader.nextInt();
//        for (int i = 0; i < StartingPoint; i++) //iterate to correct starting index
//            keyReader.nextInt();
//
//        String encryptedMessage = decryptor.next(); //take in message as string
//        char[] c = new char[encryptedMessage.length()];
//        for(int i = 0; i < encryptedMessage.length(); i++){ //put string elements in char array
//            c[i] = encryptedMessage.charAt(i);
//        }
//
//
//
//        for (int i = 0; i < c.length; i++) {
//            char d = c[i];
//            if(!keyReader.hasNextInt()){
//                keyReader.close();
//                keyReader = new Scanner(new File(keyFileLocation));
//                keyReader.nextInt(); //iterate once to skip the startPoint key
//            }
//            int n = keyReader.nextInt();
//            d = decrypt.convertChar(d, n);
////            newMessage[i] = c;
//            System.out.print(d);
//        }
//    }
}
