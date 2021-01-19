package leetcode.editor.cn;

//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 257 👎 0

public class PowerOfTwo{
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //如果这个数是2的n次幂，那么有且仅有一个1；
    // x & -x的操作仅保留x的1，其余为都是0，所以如果x & -x = x， 则说明该数。。。
    // 在计算机中，-x是以补码的形式存储，即x全部取反再+1；此操作将 x 所有位取反，但是最右边的 1 除外。
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        if ((x & -x) == x) return true;
        return false;
    }
/*    //如果这个数是2的n次幂，那么其有且仅有一个1
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        long x = (long)n;
        while (x != 0){
            count++;
            x &= (x-1);
        }
        return count == 1 ? true : false;
    }*/
/*    public boolean isPowerOfTwo(int n) {
       if (n == 0) return false;
       while (n % 2 == 0) n /= 2;
       return n == 1;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}