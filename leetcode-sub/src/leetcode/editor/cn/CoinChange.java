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
    //贪心+DFS  当前层逻辑：获取当前面值的硬币需要多少个可以接近达到总数，获取当前还剩多少总额需要分配，
    int res = Integer.MAX_VALUE; //这个参数是最后返回的最小次数
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins); //升序排序
        mincoin(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void mincoin(int[] coins, int amount, int index, int count) {
        //terminator
        if (amount == 0){
            res = Math.min(res, count);
            return;
        }
        if (index < 0) return;
        //i初始值是总数除以最大面值硬币的倍数，即最大面值硬币需要多少个可以接近达到总数；
        for (int i = amount/coins[index]; i >= 0 && i + count < res; i--){
            //current logic
            int amountCur = amount - (i * coins[index]);
            //drill down
            mincoin(coins, amountCur, index - 1, count + i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}