public class SelectSort {
    private static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = arr[i];
            for (int j = i; j < arr.length; j++){
                if (min > arr[j]){
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 6, 2, 5, 1, 0, 4};
        selectSort(a);
        for (int num : a){
            System.out.println(num + " ");
        }
    }
}
