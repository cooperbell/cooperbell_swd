import java.io.*;
import java.util.Scanner;
import java.util.Random;

/**
 * Encrypts a String message specified by user.
 */
public class Encrypt {

    /**
     *  Static final char array of the letters of the English alphabet. It's treated as a constant so it's final, and
     *  Decrypt.java accesses it as well so it's static.
     */
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

        int newIndex = index + n;
        if (newIndex >= alphabet.length)
            newIndex = newIndex % alphabet.length;
        c = alphabet[newIndex];
        return c;
    }

    /**
     * Opens the file with the keys, and puts the corresponding keys into the key array
     *
     * @param keyArray array of integers representing the "key"
     * @param keyFileLocation path to key file
     * @return filled key array
     * @throws FileNotFoundException throws this if key file isn't found
     */
    private int[] fillKeyArray(int[] keyArray, String keyFileLocation) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(keyFileLocation));
        int startPoint = reader.nextInt();

        for (int i = 0; i < startPoint; i++) //iterate to correct starting index
            reader.nextInt();

        for (int i = 0; i < keyArray.length; i++) {
            if (!reader.hasNextInt()) { //if we hit the end of the file but still have indexes to fill we go back to the beginning
                reader.close();
                reader = new Scanner(new File(keyFileLocation));
                reader.nextInt(); //iterate once to skip the startPoint key
            }
            keyArray[i] = reader.nextInt();
            //System.out.println("Key array index " + i + ": " + keyArray[i]);
        }

        return keyArray;
    }

    /**
     * Takes in message and path to key file and encrypts that message into a new file location
     *
     * @param message String message specified by user
     * @param keyFileLocation path of key file
     * @throws FileNotFoundException this throws if key file isn't found
     */
    public void encryptMessage(String message, String keyFileLocation) throws FileNotFoundException {
        String messageFileLocation = "C:\\Users\\Cooper\\IdeaProjects\\coopbell_swd\\oral_exam1\\S2_OneTimePad_Hard\\src\\encrypted_message.txt";
        int[] keyArray = new int[message.length()];
        char[] newMessage = new char[message.length()];


        keyArray = fillKeyArray(keyArray, keyFileLocation);

        for (int i = 0; i < keyArray.length; i++) {
            char c = message.charAt(i);
            if (c != ' ')
                c = convertChar(c, keyArray[i]);
            newMessage[i] = c;
        }

        try {
            PrintWriter writer = new PrintWriter(messageFileLocation);
            System.out.println("\nMessage being put into file location: " + messageFileLocation);
            for (int i = 0; i < newMessage.length; i++) {
                writer.print(newMessage[i]);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to create file in specified location");
        }
    }
}
