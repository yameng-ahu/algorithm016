public class InsertSort {
    private static void insertSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int tmp = arr[i];
            int j = i - 1;
//            for (; j >= 0 && arr[j] > tmp; j--){
//                arr[j + 1] = arr[j];
//            }
            while(j >= 0 && tmp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 6, 2, 5, 1, 0, 4};
        insertSort(a);
        for (int num : a){
            System.out.println(num + " ");
        }
    }
}
