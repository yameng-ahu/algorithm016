public class SelectSort {
    private static void selectSort(int[] arr){
        //遍历n个数
        //选取当前遍历到的数作为最小值
        //分别和剩下的数进行比较：找到比当前数还小的，则更新最小值，并且交换两个数；继续拿最小值和后面的数比较，找到更小的。这样一轮下来，最小值在第一个了
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
