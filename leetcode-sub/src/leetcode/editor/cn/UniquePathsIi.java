package leetcode.editor.cn;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划 
// 👍 425 👎 0

public class UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //多用一个空间，最后一列都是0即可，下面cur[j] = pre[j] + cur[j + 1]的时候不会超过数组索引
        int[] cur = new int[n + 1];
        int[] pre = new int[n + 1];
        for (int j = n - 1; j >= 0 && obstacleGrid[m - 1][j] != 1; j--){
            cur[j] = 1;
            pre[j] = 1;
        }
        for (int i = m - 2; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1) cur[j] = 0;
                else cur[j] = pre[j] + cur[j + 1];
            }
            pre = cur;
        }
        return cur[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}