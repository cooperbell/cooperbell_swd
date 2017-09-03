import java.util.Scanner;

public class S2_OneTimePad_Encrypt {

    private final static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     *
     * @param c char in input message
     * @return index of char c in alphabet array
     */
    private static int findIndex(char c) {
        int index;

        for (int i = 0; i < alphabet.length; i++) {
            if (c == alphabet[i]) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    /**
     *
     * @param c current char in input message
     * @param n number of times to shift ahead in alphabet array
     * @return character that is n indices ahead of c
     */
    private static char convertChar(char c, int n) {

        int index = findIndex(c);
        if (index == -1)
            return c;

        int newChar = index + n;
        if (newChar > alphabet.length) {
            int buffer = newChar - alphabet.length;
            c = alphabet[buffer];
            return c;
        }
        c = alphabet[newChar];
        return c;
    }


    public static void main(String[] args) {
        System.out.println("Enter a message: ");

        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        String message = temp.toUpperCase();
        char[] newMessage = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (c != ' ')
                c = convertChar(c, n);

            newMessage[i] = c;
        }

        for (int i = 0; i < newMessage.length; i++){
            System.out.print(newMessage[i]);
        }
    }
}
