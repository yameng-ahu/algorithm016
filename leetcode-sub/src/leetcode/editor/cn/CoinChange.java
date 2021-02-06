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

public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 使用递归+记忆化搜索，使用一个数组memo来存储金额为n的所需最小硬币个数
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount];
        int min = minCoin(coins, amount);
        return min;
    }
    private int minCoin(int[] coins, int amount){
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount - 1] != 0) return memo[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++){
            int res = minCoin(coins, amount - coins[i]);
            //计算出来金额为amount-coins[i]所需的最少硬币数之后，根据判断条件更新最小值
            if (res >= 0 && res < min){
                min = res + 1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }
    //    使用递归，不加记忆化搜索的（会超时），可以画出来递归树，然后根据递归树写代码（这个从递归树转化为代码的套路一定要会）
/*    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        minCoin(coins, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void minCoin(int[] coins, int amount, int count){
        if (amount == 0){
            min = Math.min(min, count);
            return;
        }
        if (amount < 0) return;
        for (int i = 0; i < coins.length; i++){
            minCoin(coins, amount - coins[i], count + 1);
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}