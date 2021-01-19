public class QuickSort {
    public static void quickSort(int[] array, int begin, int end){
        if (begin >= end) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    static int partition(int[] array, int begin, int end){
//        counter-begin是比pivot小的数有多少个，counter是这些数的索引
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++){
            if (array[i] < array[pivot]){
                int tmp = array[i]; array[i] = array[counter]; array[counter] = tmp;
                counter++;
            }
        }
        int tmp = array[pivot]; array[pivot] = array[counter]; array[counter] = tmp;
        return counter;
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 2, 5, 1, 0, 4};
        quickSort(a, 0, 6);
        for (int num : a){
            System.out.println(num + " ");
        }
    }
}
