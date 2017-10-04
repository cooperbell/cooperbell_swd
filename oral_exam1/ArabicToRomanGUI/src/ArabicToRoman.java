import java.util.Hashtable;

public class ArabicToRoman {
    private Hashtable<Integer, String> dictionary = new Hashtable<>();

    ArabicToRoman() {
        dictionary.put(1, "I");
        dictionary.put(4, "IV");
        dictionary.put(5, "V");
        dictionary.put(9, "IX");
        dictionary.put(10, "X");
        dictionary.put(40, "XL");
        dictionary.put(50, "L");
        dictionary.put(90, "XC");
        dictionary.put(100, "C");
        dictionary.put(400, "CD");
        dictionary.put(500, "D");
        dictionary.put(900, "CM");
        dictionary.put(1000, "M");
    }

    /**
     * Converts an Arabic number to its corresponding Roman Numeral
     * Parses int and gets number of each letter needed
     * Builds Roman numeral string from that
     *
     * @param num
     * @return
     */
    public String convertArabicToRoman(int num) {
        String romanNumeral = "";

        if(num == 0) return "";

        if (num / 1000 >= 1) {
            int mBuffer = Math.floorDiv(num, 1000);
            num = num - mBuffer*1000;
            for (int i = 0; i < mBuffer; i++) {
                romanNumeral = romanNumeral + dictionary.get(1000);
            }
        }
        if(num / 900 >= 1){
            num = num - 900;
            romanNumeral = romanNumeral + dictionary.get(900);
        }
        if (num / 500 >= 1) {
            int dBuffer = Math.floorDiv(num, 500);
            num = num - dBuffer*500;
            for (int i = 0; i < dBuffer; i++) {
                romanNumeral = romanNumeral + dictionary.get(500);
            }
        }
        if(num / 400 >= 1){
            num = num - 400;
            romanNumeral = romanNumeral + dictionary.get(400);
        }
        if (num / 100 >= 1) {
            int cBuffer = Math.floorDiv(num, 100);
            num = num - cBuffer*100;
            for (int i = 0; i < cBuffer; i++) {
                romanNumeral = romanNumeral + dictionary.get(100);
            }
        }
        if(num / 90 >= 1){
            num = num - 90;
            romanNumeral = romanNumeral + dictionary.get(90);
        }
        if (num / 50 >= 1) {
            int lBuffer = Math.floorDiv(num, 50);
            num = num - lBuffer*50;
            for (int i = 0; i < lBuffer; i++) {
                romanNumeral = romanNumeral + dictionary.get(50);
            }
        }
        if(num / 40 >= 1){
            num = num - 40;
            romanNumeral = romanNumeral + dictionary.get(40);
        }
        if (num / 10 >= 1) {
            int xBuffer = Math.floorDiv(num, 10);
            num = num - xBuffer*10;
            for (int i = 0; i < xBuffer; i++) {
                romanNumeral = romanNumeral + dictionary.get(10);
            }
        }
        if(num / 9 >= 1){
            num = num - 9;
            romanNumeral = romanNumeral + dictionary.get(9);
        }
        if (num / 5 >= 1) {
            int xBuffer = Math.floorDiv(num, 5);
            num = num - xBuffer*5;
            for (int i = 0; i < xBuffer; i++) {
                romanNumeral = romanNumeral + dictionary.get(5);
            }
        }
        if(num / 4 >= 1){
            num = num - 4;
            romanNumeral = romanNumeral + dictionary.get(4);
        }
        if (num > 0 && num < 10) {
            int iBuffer = num;
            for(int i = 0; i < iBuffer; i++) {
                romanNumeral = romanNumeral + dictionary.get(1);
            }
        }

        return romanNumeral;
    }
}
