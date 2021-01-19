package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1128 👎 0

public class HouseRobber{
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //简化为O（1）的内存空间,pre2代表dp[n-2], pre1代表dp[n-1]
    public int rob(int[] nums) {
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
        int pre2 = nums[0], pre1 = Math.max(pre2, nums[1]), sum = pre1;
        for (int i = 2; i < nums.length; i++){
            sum = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = sum;
        }
        return sum;
    }
/*    //简化为一维数组。
    // dp[i]表示，从0-i，所有情况下能偷到的最大值，第i个房子可以偷或者不偷；
    // dp[i] = max(dp[i-1], dp[i-2] + nums[i])，第i个房子偷或者不偷获得的最大金额，
    // 是比较：第i-1个房子偷了，和第i-1个房子不偷时候的最大值
    public int rob(int[] nums) {
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }*/
/*    //DP
    //分治，重复性：偷第4个房子的时候，要判断第3个房子是否偷了，如果已经偷了，那么就不要加第4个房子的金额（第4个房子不能偷）
    // 如果3号没偷，则加上第4个房子的金额。所以偷每个房子的时候有两个状态
    //状态数组：dp[i][0,1]定义为第i个房子偷或者不偷时候的金额最大值。
    //状态方程：
    // 第i个房子如果不偷的话，那么dp[i][0] = max(dp[i-1][0], dp[i-1][1])，取第i-1个房子偷和不偷时候的最大值
    //第i个房子如果偷的话，那么dp[i][1] = dp[i-1][0] + nums[i]
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}