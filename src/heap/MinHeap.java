package heap;

/**
 * Some of the most common heap operations:
 * 1. heapify(int index):
 *     • Can be written iteratively or recursively. Recursive version has space complexity of O(log N), iterative O(1).
 *     • Assumes that the left and right subtrees of the node at "index" satisfy the heap property
 *     • Helps to make sure that complete tree satisfies the heap property.
 * 2. left(int index): To get the index of left child of a node.
 * 3. right(int index): To get index of right child of a node.
 * 4. parent(int index): To get index of parent of a node.
 * 5. buildHeap(int[] arr): To build heap from an array (in place). Takes O(N) time.
 * 6. poll: To get the minimum/maximum value from heap. O(log N)
 * 7. add(int val): To add a new value to heap. O(log N).
 * 8. decreaseKey(int index): to update a key. O(log N).
 * 9. delete(int index): To delete element at given index. O(log N).
 */





/**
 * A basic implementation of a fixed capacity min heap containing all common heap operations
 */
public class MinHeap {
    private int size, capacity;
    private int[] arr;

    public  MinHeap(int capacity, int[] arr){
        this.capacity = capacity;
        this.size = arr.length;
        this.arr = arr;
        buildHeap();
    }

    private int left(int root){
        return 2 * root + 1;
    }

    private int right(int root){
        return 2 * root + 2;
    }

    private int parent(int root){
        return (root - 1) / 2;
    }

    private void buildHeap(){
         for(int i = (size - 2) / 2; i >= 0; i--){
             heapify(i);
         }
    }

    private void heapify(int root){
        int smallest = root, leftChild = left(root), rightChild = right(root);
        if(leftChild < size && arr[leftChild] < arr[root]){
            smallest = leftChild;
        }
        if(rightChild < size && arr[rightChild] < arr[smallest]){
            smallest = rightChild;
        }
        if(smallest != root){
            swap(root, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean add(int num){
        if(size == capacity){
            return false;
        }
        size++;
        arr[size - 1] = num;
        int i = size - 1;
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(parent(i), i);
            i = parent(i);
        }
        return true;
    }

    public int peek(){
        if(size == 0){
            return Integer.MIN_VALUE;
        }
        return arr[0];
    }

    public int poll(){
        if(size == 0){
            return Integer.MIN_VALUE;
        }
        swap(0, size - 1);
        size--;
        heapify(0);
        return arr[size];
    }

    /**
     * These 2 functions are not part of public API, but can be useful in implementing heap from scratch
     */

    /**
     * This assumes that new key would be less than the previous value
     */
    public void decreaseKey(int index, int newKey){
        arr[index] = newKey;
        int i = index;
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void delete(int index){
        decreaseKey(index, Integer.MIN_VALUE);
        poll();
    }

    /**
     * Iterative version of heapify
     * private void heapify(int root){
     *     int i = root, prevI;
     *     int smallest, leftChild, rightChild;
     *     do {
     *         prevI = i;
     *         smallest = i;
     *         leftChild = left(i);
     *         rightChild = right(i);
     *         if(leftChild < size && arr[leftChild] < arr[i]){
     *             smallest = leftChild;
     *         }
     *         if(rightChild < size && arr[rightChild] < arr[smallest]){
     *             smallest = rightChild;
     *         }
     *         if(smallest != i){
     *             swap(smallest, i);
     *             i = smallest;
     *         }
     *     }while(i != prevI);
     * }
     */
}
