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
         * 这种写法是比较符合逻辑的，首先对于mid取右中位数，这个可能需要经验来判断，
         * 对于平方>x, 则取比当前值小于1的数，否则取当前数；这个逻辑是比较符合人脑的思考的
         */
        if (x == 0 || x == 1) return x;
        long left = 1, right = x;
        // 这里的判断，如果是要在循环里面返回结果，要写上=；如果是在循环体外面返回结果，最好不加=；
        while (left < right){
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square == x) return (int)mid;
            else if(square > x) right = mid - 1;
            else left = mid;
        }
        return (int)left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

