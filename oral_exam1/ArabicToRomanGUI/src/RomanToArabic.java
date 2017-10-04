import java.util.Hashtable;

public class RomanToArabic {
    private Hashtable<String, Integer> dictionary = new Hashtable<>();

    /**
     *
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
     * @param str
     * @return
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

    public boolean checkRomanChar(char c) {
        String str = Character.toString(c);
        str = str.toUpperCase();
        return dictionary.containsKey(str);
    }
}
