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
    //这种只要进行了旋转，就不可能有旋转后右区间大于左区间的情况
    //要找最小值的话，要判断最小值在哪个区间里，那么就需要mid和left或者right相比较，可以用mid和left比，但是逻辑处理稍微复杂一些
    //用mid和right相比较，处理比较简单，以下直接用坐标代替num[xx]了：
    //1.如果mid > right，最小值肯定是在右区间，此时这个[mid, right]区间是有旋转点的
    //2.如果mid <= right，说明[left, mid]区间是有旋转点的，最小值一定在左区间


    //用mid和left比较，处理比较麻烦：
    //1.如果mid > left，因为数组是部分升序的，所以这种情况下，所比较的区间[left, right]可能是没有拐点的；也可能是有拐点的
    //1.1.如果left > right，说明这个区间是有拐点的，那么最小值在右区间，left = mid + 1；
    //1.2.否则，说明这个区间就是正常的升序序列，那么最小值在左区间，
    //2.如果mid < left，拐点在左区间，最小值一定在左区间
    public int findMin(int[] nums) {
        /**
         * 使用nums[mid]和nums[right]比较
         */
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

/*    public int findMin(int[] nums) {
        *//**
         * 使用nums[mid]和nums[left]比较
         *//*
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]){
                if (nums[left] > nums[right]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }else right = mid;
        }
        return nums[left];
    }*/

    }
//leetcode submit region end(Prohibit modification and deletion)

}