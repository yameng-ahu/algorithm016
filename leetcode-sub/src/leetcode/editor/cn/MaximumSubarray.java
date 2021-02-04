package leetcode.editor.cn;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2550 👎 0

public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //dp，用O(1)的空间复杂度
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp = Math.max(nums[i], dp + nums[i]);
            result = Math.max(dp, result);
        }
        return result;
    }
/*  a.分治，找重复性。因为数组是连续的，所以到第i个元素的最大子序和，要么是当前元素之前+当前元素，要么就是当前元素最大
    b.状态数组。dp[i]为到第i个元素的最大子序和
    c.状态方程。dp[i] = max(dp[i - 1], 0) + a[i];
    *//*
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            result = Math.max(dp[i], result);
        }
        return result;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}