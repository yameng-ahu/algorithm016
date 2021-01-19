package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 136 👎 0

import java.util.PriorityQueue;
import java.util.Queue;

public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //快速排序的先不写

    // 大根堆,只需要存入k个数，插入堆的时间复杂度logk，总的时间复杂度是nlogk
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k == 0) return new int[0];
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr){
            if (pq.size() < k){
                pq.add(num);
            }else{
                if (num < pq.peek()){
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int num : pq){
            res[i++] = num;
        }
        return res;
    }
    /*//小顶堆
    public int[] getLeastNumbers(int[] arr, int k) {
        //1.把arr中的数加入到heap里面-默认是小顶堆
        //2.heap.poll取出最小值且删除最小值
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] ans = new int[k];
        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
        }
        for(int i = 0; i < k; i++){
            ans[i] = heap.poll();
        }
        return ans;
    }*/

    //sort方法
    /*public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            ans[i] = arr[i];
        }
        return ans;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}