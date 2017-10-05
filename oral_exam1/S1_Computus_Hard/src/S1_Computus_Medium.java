/**
 * The driver class for the medium portion of the assignment
 */
public class S1_Computus_Medium {
    /**
     * Generates the month and day of Easter for 5.7 million years, starting at year 0
     * @param args arguments
     */
    public static void main(String[] args) {

        int[] march = new int[10];
        int[] april = new int[26];

        for (int i = 0; i < 5700000; i++){
            Easter e = new Easter(i);
            if(e.getMonth() == 3){
                march[e.getDay() - 22]++;
            }
            else{
                april[e.getDay()]++;
            }
        }
        for (int i = 0; i < march.length; i++) {
            System.out.print("March " + (i + 22) + " - ");
            System.out.println(march[i]);
        }
        for (int i = 1; i < april.length; i++) {
            System.out.print("April " + i + " - ");
            System.out.println(april[i]);
        }
    }
}
