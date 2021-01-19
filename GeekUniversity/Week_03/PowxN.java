package leetcode.editor.cn;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 500 👎 0

public class PowxN{
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //分治法
    public double myPow(double x, int n) {
        //要进行类型转换，否则某些测试用例无法通过
        long N = n;
        return N > 0 ? mul(x, N) : 1.0 / mul(x, N);
    }

    private double mul(double x, long N) {
        // terminator
        if (N == 0) return 1.0;
        // current logic
        // drill down(sub-problem)
        double result = mul(x, N/2);
        // merge result
        return N % 2 == 0 ? result * result: result * result * x;
    }

    //数学上的幂运算的定义-超时啦
    /*public double myPow(double x, int n) {
        //边界条件之类的处理
        if (x == 0.0) return 0.0;
        double mul = 1.0;
        for (int i = 0; i < Math.abs(n); i ++){
            mul = mul * x;
        }
        return n > 0 ? mul : 1.0/mul;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}