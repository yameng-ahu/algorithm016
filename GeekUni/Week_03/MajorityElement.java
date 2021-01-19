package leetcode.editor.cn;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 751 👎 0

public class MajorityElement{
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        /*候选人(vote)初始化为nums[0]，票数count初始化为1。
        当遇到与vote相同的数，则票数count = count + 1，否则票数count = count - 1。
        当票数count为0时，更换候选人，并将票数count重置为1。
        遍历完数组后，vote即为最终答案。

        为何这行得通呢？
        投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
        且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
        因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
        这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。

        无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。*/

        int vote = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == vote) cnt ++;
            else if (-- cnt == 0){
                vote = nums[i];
                cnt = 1;
            }
        }
        return vote;
    }
/*    public int majorityElement(int[] nums) {
        //排序法
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }*/

    /*public int majorityElement(int[] nums) {
        //暴力算法
        //遍历每一个数字，从当前数字再往后遍历，如果存在和当前数字相等的数字，则计数器++
        //如果此时计数器大于n/2，则找到该数字，return
        for (int i = 0; i < nums.length; i++){
            int cnt = 0;
            for (int j = i; j < nums.length; j++){
                if (nums[i] == nums[j]) cnt ++;
            }
            if (cnt > nums.length / 2) return nums[i];
        }
        throw new IllegalArgumentException("No tow sum solution");
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}