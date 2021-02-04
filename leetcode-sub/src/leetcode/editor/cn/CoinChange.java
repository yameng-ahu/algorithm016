package leetcode.editor.cn;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 856 👎 0

import java.util.Arrays;

public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*    DP
    a.分治，重复性，求面值为11的硬币组合，相当于求面值为11-1 = 10, 11-2 = 9, 11-5 = 6，这三个面值的总的组合，要去重，要找到最小的硬币数
    b.状态数组：f(n)定义为面值为n的需要的最少的硬币数
    c.状态方程：f(n) = min(f(n), f(n-k){k in coins} + 1)
    定义状态方程的时候类比爬楼梯问题，每次只能爬一层或者爬两层，f(n) = f(n - 1) + f(n - 2)，
    所以这里的k就相当于硬币的面值
    */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}