package leetcode.editor.cn;

//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 860 👎 0

public class JumpGame{
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.对每一个能够作为起跳的的格子都尝试跳一次，更新能跳到的最远距离，
    // 如果能一直跳到最后（k可以一直更新，即k比i大），则成功
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > k) return false;
            k = Math.max(k, nums[i] + i);
        }
        return true;
    }
/*    //贪心可以从前往后，从后往前，或者局部切入进行贪心求解。
    // 本题使用从后往前进行贪心求解。
    // 最近重复子问题：维护一个从后往前移动能够到达的坐标endreachable；
    // 如果前一个数字能够跳跃的最大距离大于和当前endreachable和该数字index之间的距离，则移动endreachable到前一个数字
    //最后判断如果endreachable=0，即到达第一个位置，则结果为true
    public boolean canJump(int[] nums) {
        if (nums == null) return  false;
        int endreachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] >= endreachable - i) endreachable = i;
        }
        return endreachable == 0;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}