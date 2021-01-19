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
    //二分法，
    // 这种只要进行了旋转，就不可能有旋转后右区间大于左区间的情况
    // 三种情况：
    // left < mid < right,未旋转，直接可以找第一个值作为最小值了，或左区间
    // left > mid, mid < right 最小值在左区间
    // mid > left, mid > right 最小值在右区间
    //综上，mid < right, 在左区间搜索最小值，mid > right在右区间搜索最小值，想一下也是这个逻辑
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) right = mid; //此时mid可能刚好是最小的值
            else left = mid + 1;
        }
        return nums[left];
    }

/*    //暴力搜索，用第一个数作为min（可能存在数组以第一个数为截断点进行旋转的，即未旋转）
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1]) return Math.min(min, nums[i + 1]);
        }
        return min; //在上面返回之后，这里必须要返回一个值，应该返回什么合适
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}