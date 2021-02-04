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
   //优化之后的递归；
    // 记忆化搜索
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] == 0) memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
        return memo[n];
    }

/*    //傻递归，超时，O(N^2)的时间复杂度；
      //状态树类似一棵二叉树，要求解的问题指数增加
    public int climbStairs(int n) {
        return n <= 1 ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}