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
    //两种递归+记忆化搜索的写法
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        return uniquePathHelper(0, 0, m - 1, n - 1, obstacleGrid);
    }
    private int uniquePathHelper(int i, int j, int m, int n, int[][] obstacleGrid){
        if (i > m || j > n) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == m && j == n) return 1;
        if (memo[i][j] != 0) return memo[i][j];
        return memo[i][j] = uniquePathHelper(i + 1, j, m, n, obstacleGrid) + uniquePathHelper(i, j + 1, m, n, obstacleGrid);
    }
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePathsHelper(0, 0, m - 1, n - 1, new HashMap<>(), obstacleGrid);
    }

    public int uniquePathsHelper(int i, int j, int m, int n, Map<String, Integer> map, int[][] obstacleGrid) {
        //采用递归+记忆化搜索的方式，时间复杂度降为O（n），这个有点类似斐波那契数列
        if (i > m || j > n)
            return 0;
        if (obstacleGrid[i][j] == 1)
            return 0;
        if ((i == m && j == n))
            return 1;
        String key = i + "*" + j;
        if (map.containsKey(key))
            return map.get(key);
        int right = uniquePathsHelper(i + 1, j, m, n, map, obstacleGrid);
        int down = uniquePathsHelper(i, j + 1, m, n, map, obstacleGrid);
        int totla = right + down;
        map.put(key, totla);
        return totla;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}