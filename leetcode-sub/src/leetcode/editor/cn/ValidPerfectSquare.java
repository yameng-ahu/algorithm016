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
        int a = num;
        //使用a > num / a   而不是  a * a > num， 可以避免整数溢出；如果使用a * a > num的话，要转换为long类型的
        while (a > num / a){
            a = (a + num / a) / 2;
        }
        return a * a == num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}