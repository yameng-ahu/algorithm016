package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1324 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //考虑合法的括号
    private List<String> result;
    public List<String> generateParenthesis(int n) {
        //合法的括号，左括号有n个，右括号有n个，
        // 左括号可以随意添加，只要不超过左括号的个数
        //添加右括号的时候，要有左括号的存在，即左括号的个数>右括号的个数

        //生成括号的函数，输入参数，当前左括号的个数，当前右括号的个数，最大个数，当前括号形成的字符串；
        result = new ArrayList<>();
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int max, String s) {
        if (left == max && right == max){
            result.add(s);
            return;
        }
        if (left < max)
            generate(left + 1, right, max, s + "(");
        if (left > right)
            generate(left, right + 1, max, s + ")");
    }
/*    //先不考虑括号的合法性，输出所有的结果
    public List<String> generateParenthesis(int n) {
        //生成括号的函数，初始的level是0，max是2n个括号，且是一个空的串；
        _generate(0, 2 * n, "");
        return null;
    }

    private void _generate(int level, int max, String s) {
        //terminator
        if(level >= max) {
            System.out.println(s);
            return;
        }
        //process current logic
        String s1 = s + "(";
        String s2 = s + ")";
        //drill down
        _generate(level + 1, max, s1);
        _generate(level + 1, max, s2);
        //revert states
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)

}
