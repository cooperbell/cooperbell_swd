import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decrypt {
    //private final static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     *
     * @param c
     * @return index of c in alphabet array
     */
//    private int findIndex(char c) {
//        int index;
//
//        for (int i = 0; i < Encrypt.alphabet.length; i++) {
//            if (c == Encrypt.alphabet[i]) {
//                index = i;
//                return index;
//            }
//        }
//        return -1;
//    }

    /**
     * @param c current char in input message
     * @param n number of times to shift ahead in alphabet array
     * @return character that is n indices before c
     */
    private char convertChar(char c, int n) {

        int index = Encrypt.findIndex(c);
        if (index == -1)
            return c;

        int newChar = index - n;
        if (newChar < 0) {
            int buffer = n - index;
            c = Encrypt.alphabet[Encrypt.alphabet.length - buffer];
            return c;
        }
        c = Encrypt.alphabet[newChar];
        return c;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Decrypt decrypt = new Decrypt();
        Scanner scan = new Scanner(System.in);
        int StartingPoint;


        System.out.println("Specify location for key file: ");
        String keyFileLocation = scan.nextLine();

        System.out.println("Specify location for message file");
        String messageFileLocation = scan.nextLine();

        Scanner keyReader = new Scanner(new File(keyFileLocation));
        Scanner decryptor = new Scanner(new File(messageFileLocation));

        StartingPoint = keyReader.nextInt();
        for (int i = 0; i < StartingPoint; i++) //iterate to correct starting index
            keyReader.nextInt();

        String encryptedMessage = decryptor.next(); //take in message as string
        char[] c = new char[encryptedMessage.length()];
        for(int i = 0; i < encryptedMessage.length(); i++){ //put string elements in char array
            c[i] = encryptedMessage.charAt(i);
        }



        for (int i = 0; i < c.length; i++) {
            char d = c[i];
            if(!keyReader.hasNextInt()){
                keyReader.close();
                keyReader = new Scanner(new File(keyFileLocation));
                keyReader.nextInt(); //iterate once to skip the startPoint key
            }
            int n = keyReader.nextInt();
            d = decrypt.convertChar(d, n);
//            newMessage[i] = c;
            System.out.print(d);
        }

//        for (int i = 0; i < newMessage.length; i++) {
//            System.out.print(newMessage[i]);
//        }
    }
}
