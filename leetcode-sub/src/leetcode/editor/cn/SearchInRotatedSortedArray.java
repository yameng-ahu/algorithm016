package leetcode.editor.cn;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 1007 👎 0

public class SearchInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //分析：
    //1.因为数组是旋转过的，所以mid可能会落在一个有序区间，或者落在一个有反转的区间
    //2.数组的数字不重复，且按照升序排列后旋转，所以left的数一定大于right的数
    //3.要找mid在哪个区间，可以判断mid和left的关系，也可以判断mid和right的关系，这里用mid和left的关系进行判断
    //4.如果mid对应的数大于left对应的数，说明[left, mid]左区间是升区间，[mid, right]有旋转点，下面通过判断target和mid的关系，来定位target在哪个区间
    //4.1.如果mid对应的数小于target，则需要找更大的数，而[left, mid]区间的数一定小于target，则需要向右搜索
    //4.2.如果mid对应的数大于target，则需要找更小的数，此时可能在左区间，也可能在右区间，需要用left来辅助判断
    //4.2.1.如果left对应的数大于target，则一定在右区间
    //4.2.2.如果left对应的数小于target，则一定要在左区间搜索
    //综合4的步骤：得出：
    //if (nums[mid] >= nums[left]) {
    //   if (nums[mid] < target || nums[left] > target) {
    //      left = mid + 1;
    //   }else right = mid;
    //}
    //否则4，即：nums[mid] < nums[left]，记为5
    //5.说明[left, mid]有旋转点，[mid+1, right]是升序
    //5.1.如果mid对应的数大于target，则需要找更小的数，则应该在左区间搜索
    //5.2.如果mid对应的数小于target，则需要找更大的数，可能在左区间，也可能在右区间
    //5.2.1.如果left对应的数小于target，则应该在右区间
    //5.2.2.如果left对应的数大于target，则应该在左区间搜索

    //写法2，
    //public int search(int[] nums, int target) {
    //    int left = 0, right = nums.length - 1;
    //    while (left < right){
    //        int mid = (left + right) >> 1;
    //        if (nums[mid] < nums[left]){
    //            if (nums[mid] < target && nums[left] > target){
    //                left = mid + 1;
    //            }else {
    //                right = mid;
    //            }
    //        }else {
    //            if (nums[mid] < target || nums[left] > target){
    //                left = mid + 1;
    //            }else {
    //                right = mid;
    //            }
    //        }
    //    }
    //    return nums[left] == target ? left : -1;
    //}
    // 对写法2进行精简
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[left] && nums[mid] < target && nums[left] > target)left = mid + 1;
            else if (nums[mid] >= nums[left] && (nums[mid] < target || nums[left] > target)) left = mid + 1;
            else right = mid;
        }
        return nums[left] == target ? left : -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}