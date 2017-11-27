import java.util.HashMap;
import java.util.Map;

/**
 * Class for the check writing algorithm
 */
public class CheckWriter {

    /**
     * Hash map holds all the English equivalents of decimal numbers
     */
    private static final Map<Integer, String> numbers;

    static {
        numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
        numbers.put(60, "sixty");
        numbers.put(70, "seventy");
        numbers.put(80, "eighty");
        numbers.put(90, "ninety");
        numbers.put(100, "hundred");
    }

    /**
     * parses int and writes the corresponding number in English format
     *
     * @param checkAmount amount of check as double
     * @return the string version of check amount
     */
    public String writeNumber(double checkAmount) {
        String[] arr = String.valueOf(checkAmount).split("\\.");
        StringBuilder beforeDecimal = new StringBuilder();
        int[] intArr = new int[2];
        int num = Integer.parseInt(arr[0]);
        int decimal = Integer.parseInt(arr[1]);

        if((num / 100) >= 1){
            int Buffer = Math.floorDiv(num, 100);
            num = num - Buffer*100;
            beforeDecimal.append(numbers.get(Buffer));
            beforeDecimal.append(" ");
            beforeDecimal.append(numbers.get(100));
        }

        if(((num / 10) >= 1) && num >= 20){
            int Buffer = Math.floorDiv(num, 10);
            num = num - Buffer*10;
            beforeDecimal.append(" ");
            beforeDecimal.append(numbers.get(Buffer * 10));
        }

        if(num > 10 && num < 20){
            num = num - 10;
            beforeDecimal.append(" ");
            beforeDecimal.append(numbers.get(10 + num));
            num = 0;
        }

        if (num > 0 && num <= 10) {
            beforeDecimal.append(" ");
            beforeDecimal.append(numbers.get(num));
        }

        return beforeDecimal + " and " + decimal + "/100";
    }
}
