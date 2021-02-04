package leetcode.editor.cn;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1284 👎 0

public class ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //动态规划，自底向上
/*    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/
    public int climbStairs(int n) {
        //动态规划，降低空间复杂度，这里计算当前层的路径数，只需要前两个数，所以只要保存前两个数就可以了
        if (n <= 2) return n;
        int sum = 0;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++){
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}