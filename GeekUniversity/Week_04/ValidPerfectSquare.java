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
        //使用牛顿迭代法，用x = (x + a / x) / 2计算下一个近似值，这里是对a求其平方根x
        if (num < 2) return true;
        long x0 = num / 2; //取右边界的值作为初始值
        while (x0 * x0 > num){
            x0 = (x0 + num / x0) / 2;
        }
        return x0 * x0 == num;
    }
    /*public boolean isPerfectSquare(int num) {
        //使用二分法, mid和num作比较
        if (num == 1) return true;
        long left = 2, right = num / 2;
        while (left <= right){
            long mid = left + (right - left) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}