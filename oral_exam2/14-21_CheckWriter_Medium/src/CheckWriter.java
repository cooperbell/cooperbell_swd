import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CheckWriter {

    /**
     *
     */
    private static final Map<Integer, String> numbers;

    static {
        numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three"); //TODO: i might not need all of these
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
     * @param checkAmount
     * @return
     */
    public String writeNumber(int checkAmount){
        Integer num = checkAmount;
        return "NOT DONE YET";
    }
}
