public class BubbleSort {
    private static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j + 1] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 6, 2, 5, 1, 0, 4};
        bubbleSort(a);
        for (int num : a){
            System.out.println(num + " ");
        }
    }
}
