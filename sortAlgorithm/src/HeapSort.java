import java.util.PriorityQueue;

public class HeapSort {
    public static void heapSort(int[] array){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++){
            heap.add(array[i]);
        }
        for (int i = 0; i < array.length; i++){
            array[i] = heap.poll();
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 6, 2, 5, 1, 0, 4};
        heapSort(a);
        for (int num : a){
            System.out.println(num + " ");
        }
    }
}
