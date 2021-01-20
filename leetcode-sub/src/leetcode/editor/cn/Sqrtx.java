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
         * mid > x / mid作为判断条件，和mid * mid > x作为判断条件的区别
         */
        if (x == 0) return 0;
        int left = 1, right = x;
        while (true){
            int mid = left + (right - left) / 2;
            // 这里如果输入的x是2147395599，则此时计算的mid为1073697800，如果使用mid * mid > x作为判断条件，则会出现整数溢出，导致不满足mid * mid > x，
            // 但实际上是满足这个条件的，所以代码执行步骤就不对了
            if (mid > x / mid){
                right = mid - 1;
            }else {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

