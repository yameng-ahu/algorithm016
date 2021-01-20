package leetcode.editor.cn;

//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 524 👎 0

public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        /**
         * 为什么这里可以用二分法：1.从1到x是一个单调递增的区间；2.存在上下界
         */
        if (x == 0 || x == 1) return x;
        long left = 1, right = x;
        while (left <= right){
            long mid = left + (right - left) / 2;
            if (mid * mid == x) return (int)mid;
            else if (mid * mid > x) right = mid - 1;
            else left = mid + 1;
        }
        // 当left == right的时候，mid = left，
        // 1.如果，mid * mid小于x，会再执行一次left = mid + 1，此时left*left肯定是会大于x了，所以应该返回right
        // 2.如果，mid * mid大于x，会执行一次right = mid - 1，此时right*right肯定是小于x的，所以也应该返回right
        // 综上应该返回right
        return (int)right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}