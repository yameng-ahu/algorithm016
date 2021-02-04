package leetcode.editor.cn;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 624 👎 0

import java.util.List;

public class Triangle{
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //  dp的解法
    //a.重复性，2的最小路径和是3的最小路径和和4的最小路径和的较小者+2，同理
    //b.定义状态数组，dp[i][j]表示三角形第i,j这个点到底边的最小路径和
    //c.dp方程，dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}