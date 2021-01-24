package leetcode.editor.cn;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 189 👎 0

public class FindMinimumInRotatedSortedArrayIi{
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //本题直接使用二分法，和153题比较，数组中包含重复元素
    //153：nums[mid] > nums[right], 说明最小值在右区间，left = mid + 1
    //nums[mid] < nums[right], 说明最小值在左区间或者就是mid，right = mid；
    //本题多了一种情况，即：nums[mid] == nums[right]，则right-1，因为最小值一定在[left, right-1]，不会丢失
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right--;
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}