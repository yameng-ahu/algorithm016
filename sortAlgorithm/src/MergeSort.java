public class MergeSort {
    public static void mergeSort(int[] array, int left, int right){
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    private static void merge(int[] a, int left, int mid, int right){
        int[] num = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right){
            num[k++] = a[i] > a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) num[k++] = a[i++];
        while (j <= right) num[k++] = a[j++];
        System.arraycopy(num, 0, a, left, num.length);
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 2, 5, 1, 0, 4};
        mergeSort(a, 0, 6);
        for (int num : a){
            System.out.println(num + " ");
        }
    }
}
