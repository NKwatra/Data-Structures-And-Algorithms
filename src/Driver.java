import sorting.HeapSort;
import sorting.SortingAlgorithm;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        final int[] arr = {1,4,8,-2,5,9,10,-15};
        /**
         * Testing for heap sort
         */
        int[] arr1 = new int[8];
        System.arraycopy(arr, 0, arr1, 0, 8);
        SortingAlgorithm algo = new HeapSort();
        algo.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
