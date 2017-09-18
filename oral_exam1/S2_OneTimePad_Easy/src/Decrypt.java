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
     *
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


    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();
        System.out.println("Specify location for key file: ");

        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        System.out.println("Enter a message: ");
        int n = scan.nextInt();
        String message = temp.toUpperCase();
        char[] newMessage = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c = decrypt.convertChar(c, n);
            newMessage[i] = c;
        }

        for (int i = 0; i < newMessage.length; i++) {
            System.out.print(newMessage[i]);
        }
    }
}
