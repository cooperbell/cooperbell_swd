import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Encrypt {

    public final static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * Takes a letter of the alphabet as a char, and finds its corresponding index in the alphabet array.
     *
     * @param c char in input message
     * @return index of char c in alphabet array
     */
    public static int findIndex(char c) {
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
     * Takes the given character c and moves it n indexes through the alphabet char array. If the number of shifts is
     * greater than the remainder of the array, then we imitate cycling through the rest of the array and then going
     * back to the beginning.
     *
     * @param c current char in input message
     * @param n number of times to shift ahead in alphabet array
     * @return character that is n indices ahead of c
     */
    private char convertChar(char c, int n) {

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


    public static void main(String[] args) throws IOException {
        KeyGenerator key = new KeyGenerator();
        Encrypt encrypt = new Encrypt();
        Scanner scan = new Scanner(System.in);
        String keyFileLocation, messageFileLocation, message;
        int n;
        int[] keyArray;
        char[] newMessage;

        System.out.println("Enter a message: ");
        message = scan.nextLine();
        message = message.toUpperCase();
        keyArray = new int[message.length()];
        newMessage = new char[message.length()];

        System.out.println("Give a location for the key file: ");
        keyFileLocation = scan.nextLine();

        System.out.println("Specify number of keys: ");
        n = scan.nextInt();

        key.generateKeyFile(n, keyFileLocation);

        //open key file, find the value specified value of the starting point
        Scanner reader = new Scanner(new File(keyFileLocation));
        Random rand = new Random();
        int startPoint = reader.nextInt();

        for (int i = 0; i < startPoint; i++) //iterate to correct starting index
            reader.nextInt();

        for (int i = 0; i < keyArray.length; i++) { //fill array of n values
            if (!reader.hasNextInt()) { //if we hit the end of the file but still have indexes to fill we go back to the beginning
                reader.close();
                reader = new Scanner(new File(keyFileLocation));
                reader.nextInt(); //iterate once to skip the startPoint key
            }
            keyArray[i] = reader.nextInt();
            System.out.println("Key array index " + i + ": " + keyArray[i]);
        }

        for (int i = 0; i < keyArray.length; i++) {
            char c = message.charAt(i);

            if (c != ' ')
                c = encrypt.convertChar(c, keyArray[i]);

            newMessage[i] = c;
        }

        for (int i = 0; i < newMessage.length; i++) {
            System.out.print(newMessage[i]);
        }
        messageFileLocation = "C:\\Users\\Cooper\\IdeaProjects\\coopbell_swd\\oral_exam1\\S2_OneTimePad_Easy\\src\\encrypted_message.txt";
        try {
            PrintWriter writer = new PrintWriter(messageFileLocation);
            System.out.println("Message being put into file location:" + messageFileLocation);
            for (int i = 0; i < newMessage.length; i++) {
                writer.print(newMessage[i]);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to create file in specified location");
        }
    }
}
