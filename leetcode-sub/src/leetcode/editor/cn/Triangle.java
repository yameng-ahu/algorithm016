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
    //递归+记忆化搜索
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n + 1][n + 1];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int level, int j) {
        if (level == triangle.size()) return 0;

        if (memo[level][j] != 0) return memo[level][j];

        return memo[level][j] = Math.min(dfs(triangle, level + 1, j), dfs(triangle, level + 1, j + 1)) + triangle.get(level).get(j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}