package leetcode.editor.cn;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1255 👎 0

public class BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int dp = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            dp = Math.max(dp, prices[i] - minPrice);
        }
        return dp;
    }
    /*//dp
    //分治，重复性，第3天卖出或者不卖出所有方式下，获得的最大利润是：第2天卖出获得的最大利润，或者第2天不卖出在第三天卖出的最大利润，取最大值
    //dp[i]代表在第i天获得的最大利润
    //状态方程 dp[i] = max(dp[i-1], price[i]- minPrice),minPrice为前i-1天的历史最低价格
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[prices.length - 1];
    }*/

    //暴力法，对于每个i，求出每个j相对于i的利润，取最大
    /*public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] > prices[i]){
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(profit, maxProfit);
                }
            }

        }
        return maxProfit;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}