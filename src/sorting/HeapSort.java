package sorting;
import heap.MinHeap;

public class HeapSort implements SortingAlgorithm{

    public void sort(int[] arr){
        MinHeap heap = new MinHeap(arr.length, arr);
        for(int i = 0; i < arr.length; i++){
            heap.poll();
        }
        for(int i =0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
