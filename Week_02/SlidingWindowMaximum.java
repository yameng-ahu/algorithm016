package leetcode.editor.cn;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
// 滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 563 👎 0

public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*//用一个双端队列，让元素入队，每次入队之前判断当前要入队的元素是否大于队尾元素，如果大于的话，把队列里面的队尾元素出队
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] maxNum = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peek() <= i - k)
                queue.poll();
            if (i + 1 >= k)
                maxNum[i - k + 1] = nums[queue.peek()];
        }
        return maxNum;
    }*/
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (nums == null || n < 2) return nums;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++){
            //构造left矩阵
            if (i % k == 0) left[i] = nums[i];
            else left[i] = Math.max(left[i - 1], nums[i]);

            //构造right矩阵
            int j = n - 1 - i;
            if (j % k == 0) right[j] = nums[j];
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++){
            res[i] = Math.max(right[i], left[k + i - 1]);
        }
        return res;
    }*/
/*    //暴力解法，超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxNum = new int[nums.length - k + 1];
        int cnt = 0;
        for (int i = 0; i < nums.length - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++){
                max = (nums[j] > max) ? nums[j] : max;
            }
            maxNum[i] = max;
        }
        return maxNum;
    }*/
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        //使用大顶堆，用大顶堆维护这个滑动窗口,因为java的priority实现的不好，所以超时了
        //细节：1.滑动窗口向前滑动的时候，滑出来的数字要从窗口中删掉，并且添加新进入的数字；
        // 2.滑动窗口的size=k的时候，可以取窗口里的最大值放到result数组里，最后返回result；
        if(nums.length == 0 || k == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));

        for(int i = 0; i < n; i++){
            int start = i - k;
            if(start >= 0){
                heap.remove(nums[start]);
            }
            heap.offer(nums[i]);
            if(heap.size() == k){
                result[i - k + 1] = heap.peek();
            }
        }
        return result;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}