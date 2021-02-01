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

import java.util.HashMap;
import java.util.Map;

public class UniquePaths{
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(1, 1, m, n, new HashMap<>());
    }

    public int uniquePathsHelper(int i, int j, int m, int n, Map<String, Integer> map) {
        //采用递归+记忆化搜索的方式，时间复杂度降为O（n），这个有点类似斐波那契数列
        if (i > m || j > n)
            return 0;
        if ((i == m && j == n))
            return 1;
        String key = i + "*" + j;
        if (map.containsKey(key))
            return map.get(key);
        int right = uniquePathsHelper(i + 1, j, m, n, map);
        int down = uniquePathsHelper(i, j + 1, m, n, map);
        int totla = right + down;
        map.put(key, totla);
        return totla;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}