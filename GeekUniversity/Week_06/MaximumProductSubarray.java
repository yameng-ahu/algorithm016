package leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 806 👎 0

public class MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //巧妙一点的思路：如果这个数组里全都是正数或者负数的个数为偶数，那么一定是相乘到最后一个值乘积最大；
    // 如果负数的个数为奇数，那么分别从前往后相乘，和从后往前相乘，最后取最大值就行了。如果中间是0的话，那么前面或者后面乘积置1
    public int maxProduct(int[] nums) {
        int res = nums[0], left = 0, right = 0;
        for (int i = 0; i < nums.length; i++){
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[nums.length - 1 - i];
            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }
   /* //降维
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int maxDP = nums[0], preMax = maxDP, minDP = nums[0], preMin = minDP, dp = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxDP = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            minDP = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            preMax = maxDP;
            preMin = minDP;
            dp = Math.max(dp, maxDP);
        }
        return dp;
    }*/
/*    //重复性：到第i个元素的最大乘积，应该由到前一个元素的最大乘积*当前元素、最小乘积*当前元素（最负的那个）、当前元素的最大值
    // 到第i个元素的最小乘积，应该由到前一个元素的最小乘积*当前元素...
    //
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int dp = nums[0];
        int[] maxDP = new int[nums.length], minDP = new int[nums.length];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxDP[i] = Math.max(nums[i], Math.max(maxDP[i-1] * nums[i], minDP[i-1]* nums[i]));
            minDP[i] = Math.min(nums[i], Math.min(maxDP[i-1] * nums[i], minDP[i-1]* nums[i]));
            dp = Math.max(dp, maxDP[i]);
        }
        return dp;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}