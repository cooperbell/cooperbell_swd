import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Class for merge sort implementation
 */
public class MergeSort {

    /**
     * Recursive portion of merge sort that splits an array in half, then recurses both of those halves, then sorts the two halves.
     *
     * @param array sorted integer array
     * @return sorted integer array
     */
    public int[] mergeSort(int[] array) {

        //base case
        if (array.length == 1) {
            return array;
        }

        int half = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, half);
        int[] right = Arrays.copyOfRange(array, half, array.length);

        left = mergeSort(left);
        right = mergeSort(right);


        array = sort(left, right);

        return array;
    }

    /**
     * This iteratively sorts two integer arrays into one
     *
     * @param left  left half of array
     * @param right right half of array
     * @return sorted array of the left and right halves
     */
    public int[] sort(int[] left, int[] right) {
        int[] temp = new int[left.length + right.length];

        int leftIt = 0, rightIt = 0;

        //sort the two arrays
        for (int i = 0; i < temp.length; i++) {
            if (leftIt < left.length && rightIt < right.length) { //while the iterators are still within the arrays' bounds
                if (left[leftIt] < right[rightIt]) {
                    temp[i] = left[leftIt];
                    leftIt++;
                } else {
                    temp[i] = right[rightIt];
                    rightIt++;
                }
            } else if (rightIt < right.length) {
                temp[i] = right[rightIt];
                rightIt++;
            } else {
                temp[i] = left[leftIt];
                leftIt++;
            }
        }

        return temp;
    }
}
