import java.util.Hashtable;

/**
 *  Class for converting Roman numerals to Arabic numbers
 */
public class RomanToArabic {
    /**
     * Hash table for storing the Roman numeral to Arabic number equivalents
     */
    private Hashtable<String, Integer> dictionary = new Hashtable<>();

    /**
     * Constructor initializes hash table
     */
    RomanToArabic() {
        dictionary.put("I", 1);
        dictionary.put("IV", 4);
        dictionary.put("V", 5);
        dictionary.put("IX", 9);
        dictionary.put("X", 10);
        dictionary.put("XL", 40);
        dictionary.put("L", 50);
        dictionary.put("XC", 90);
        dictionary.put("C", 100);
        dictionary.put("CD", 400);
        dictionary.put("D", 500);
        dictionary.put("CM", 900);
        dictionary.put("M", 1000);
    }

    /**
     * Converts a string of Roman Numerals to its corresponding Arabic value
     *
     * @param str String containing Roman numeral
     * @return a String containing the corresponding Arabic number
     */
    public String convertRomanToArabic(String str) {
        int arabicNum = 0;
        str = str.toUpperCase();
        if(str.length() >= 2) {

            for (int i = 0; i < str.length()-1; i++) {
                if (dictionary.get(str.substring(i, i + 1)) < dictionary.get(str.substring(i + 1, i + 2))) { // e.g. iv or cd
                    arabicNum += dictionary.get(str.substring(i, i + 2));
                } else {
                    arabicNum += dictionary.get(str.substring(i, i + 1));
                }
            }
        }
        else if(str.length() == 1){
            arabicNum += dictionary.get(str.substring(0,1));
        }
        return arabicNum + "";
    }

    /**
     * Takes in a char that has been just typed by the user, checks if it's a "valid" Roman numeral by checking if it's
     * in the hash table
     *
     * @param c character to check
     * @return boolean whether that char is in the hash table or not
     */
    public boolean checkRomanChar(char c) {
        String str = Character.toString(c);
        str = str.toUpperCase();
        return dictionary.containsKey(str);
    }
}
