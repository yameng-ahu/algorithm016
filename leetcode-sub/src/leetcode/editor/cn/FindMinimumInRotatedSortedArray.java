package leetcode.editor.cn;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找 
// 👍 271 👎 0

public class FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        /**
         * 暴力法，因为数字不重复，数组翻转之前是升序，那么从前向后遍历，如果当前数比前一个数小了，那么这个数一定是拐点。也就是最小值
         * 还有一种情况是数组未翻转，那么第一个值就是最小值
         */
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                return nums[i];
            }
        }
        return min;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}