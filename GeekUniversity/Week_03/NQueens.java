package leetcode.editor.cn;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 620 👎 0

import java.util.*;

public class NQueens{
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //成员变量，减少参数传递
    private Set<Integer> cols;
    private Set<Integer> pie;
    private Set<Integer> na;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n < 1) return res;
        //之前的皇后所攻击的位置（列、pie、na）
        cols = new HashSet<>();
        pie = new HashSet<>();
        na = new HashSet<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        //遍历列columns，将皇后挨个尝试放置
        for (int i = 0; i < n; i++) {
            //如果当前位置不会受到攻击，则可以放置
            if (!cols.contains(i) && !pie.contains(row + i) && !na.contains(row - i)) {
                path.addLast(i);
                cols.add(i);
                pie.add(row + i);
                na.add(row - i);

                //drill down
                dfs(row + 1, path);

                //revert states
                cols.remove(i);
                na.remove(row - i);
                pie.remove(row + i);
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n)));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
}