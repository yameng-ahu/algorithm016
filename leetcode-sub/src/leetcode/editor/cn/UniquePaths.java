package leetcode.editor.cn;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 718 👎 0

import java.util.Arrays;

public class UniquePaths{
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    降维：O（2n）的空间复杂度
    //计算当前格子路径数的时候，只需要当前格子的右边格子和下边一个格子，这里先用两个数组存储
/*    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                cur[j] = cur[j + 1] + pre[j];
            }
            pre = cur;
        }
        return cur[0];
    }*/

    //空间复杂度O（n）
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                cur[j] = cur[j] + cur[j + 1];
            }
        }
        return cur[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}