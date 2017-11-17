import java.util.Random;

/**
 * Driver class for MergeSort class
 */
public class MergeSortDriver {

    /**
     * Generates 100-element unsorted array between 0 and 1000, then passes that to the mergeSort method to sort
     * @param args command line arguments
     */
    public static void main(String[] args) {

        MergeSort ms = new MergeSort();
        Random random = new Random();

        //generate 100 element array
        int[] randomArray = new int[100];


        System.out.print("Unsorted array -- ");

        //fill array with random values between 0 and 1000
        for (int i = 0; i < 100; i++) {
            randomArray[i] = random.nextInt(1000);
            System.out.print(randomArray[i] + " ");
        }

        int[] sortedArray = ms.mergeSort(randomArray);
        System.out.println(" ");
        System.out.print("Sorted array -- ");

        for (int i = 0; i < 100; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }
}
