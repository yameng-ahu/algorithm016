package leetcode.editor.cn;

//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 727 👎 0

public class JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        /**
         * 1.如果一个作为起跳点的格子可以跳跃的距离是3，那么表示后面3个格子都可以作为起跳点
         * 2.如果从这个起跳点起跳作为第一次跳跃，那么后面3个格子作为起跳点都是第二次跳跃，
         * 3.每次跳跃更新能够跳到的最远距离
         * 4.当这3个格子都尝试完之后，第二次跳跃完成，更新下一次的起跳区间并计算跳跃次数
         */
        int start = 0, end = 1, count = 0;
        while (end < nums.length){
            int maxPos = 0;
            for (int i = start; i < end; i++){
                maxPos = Math.max(maxPos, nums[i] + i);
            }
            start = end;
            end = maxPos + 1;
            count++;
        }
        return count;
    }
    public int jump(int[] nums) {
        /**
         * 上面方法的优化
         */
        int count = 0, maxPos = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (end == i) {
                end = maxPos;
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}