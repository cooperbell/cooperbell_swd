import java.util.Hashtable;

/**
 * Class for converting Roman numerals to Arabic numbers
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
        dictionary.put("V", 5);
        dictionary.put("X", 10);
        dictionary.put("L", 50);
        dictionary.put("C", 100);
        dictionary.put("D", 500);
        dictionary.put("M", 1000);
    }

    /**
     * Converts a string of Roman Numerals to its corresponding Arabic value
     *
     * @param str String containing Roman numeral
     * @return a String containing the corresponding Arabic number
     */
    public String convertRomanToArabic(String str) {
        int arabicNum = 0, subStr1, subStr2;
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            subStr1 = dictionary.get(str.substring(i, i + 1));

            if (i + 1 < str.length()) {
                subStr2 = dictionary.get(str.substring(i + 1, i + 2));
                if (subStr1 >= subStr2) {
                    arabicNum += subStr1;
                } else {
                    arabicNum += subStr2 - subStr1;
                    i++;
                }
            } else {
                arabicNum += subStr1;
                i++;
            }
        }
        return arabicNum + "";
    }

    /**
     * Checks four rules of Roman Numeral representations
     * 1. The same letter cannot repeat more than 3 times
     * 2. When subtracting, the smaller roman numeral must be a power of ten, i.e. not V or L
     * 3. When subtracting, the same smaller roman numeral cannot repeat twice before the larger numeral, i.e. IIV
     * 4. When subtracting, the smaller roman numeral cannot be more than 10 times smaller than the larger numeral, i.e. IC
     *
     * @param str Roman numeral string
     * @return boolean that, if false, means the given Roman string failed a rule
     */
    public boolean checkRomanValidity(String str) {
        boolean valid = true;
        int repeat = 0, subStr1, subStr2;

        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            subStr1 = dictionary.get(str.substring(i, i + 1));
            if (str.length() > 3) { //Checking if letters repeat more than twice
                if (i + 1 < str.length()) {
                    if (str.charAt(i) == str.charAt(i + 1)) repeat++;
                    if (repeat > 2) valid = false;
                }
            }

            if (i + 1 < str.length()) {
                subStr2 = dictionary.get(str.substring(i + 1, i + 2));
                if (subStr1 < subStr2) { //Checking if subtracting numeral is power of ten (i.e. not V or L)
                    if (str.substring(i, i + 1).equals("V") || str.substring(i, i + 1).equals("L")) valid = false;
                    if(subStr2/10 > subStr1) valid = false; //Checking if subtracted numeral is within 10 times of greater numeral
                }
                if (i > 0){ //Checking if subtracted roman numerals repeat (i.e. IIV or XXC)
                    if (subStr1 < subStr2){
                        if(subStr1 == dictionary.get(str.substring(i-1,i))) valid = false;
                    }
                }

            }


        }
        return valid;
    }
}
