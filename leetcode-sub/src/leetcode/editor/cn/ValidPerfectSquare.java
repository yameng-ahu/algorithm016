package leetcode.editor.cn;

//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 172 👎 0

public class ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        long left = 1, right = num;
        while (left < right){
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square == num) return true;
            else if (square > num) right = mid - 1;
            else left = mid;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}