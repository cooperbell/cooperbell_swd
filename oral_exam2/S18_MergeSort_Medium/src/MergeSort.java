import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 */
public class MergeSort {

    /**
     *
     * @param array
     * @return
     */
    public int[] mergeSort(int[] array) {

        //base case
        if (array.length == 1) {
            return array;
        }

        int half = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, half);
        int[] right = Arrays.copyOfRange(array, half, array.length);


        array = sort(mergeSort(left), mergeSort(right));

        return array;
    }

    /**
     *
     * @param left
     * @param right
     * @return
     */
    public int[] sort(int[] left, int[] right) {
        int[] temp = new int[left.length + right.length];

        int leftIt = 0, rightIt = 0;

        //sort the two arrays
        for(int i = 0; i < temp.length; i++){
            if (leftIt < left.length && rightIt < right.length){ //while the iterators are still within the arrays' bounds
                if (left[leftIt] < right[rightIt]){
                    temp[i] = left[leftIt];
                    leftIt++;
                } else {
                    temp[i] = right[rightIt];
                    rightIt++;
                }
            }
            else if (rightIt < right.length){
                temp[i] = right[rightIt];
                rightIt++;
            }
            else {
                temp[i] = left[leftIt];
                leftIt++;
            }
        }

        return temp;
    }
}
