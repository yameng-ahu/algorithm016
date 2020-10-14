package leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 258 👎 0

public class SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //由于数组的行和列都是升序的，所以可从左下角到右上角进行搜索，最初的左下角相当于二分法中的mid元素，每次排除一行或一列
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        //left 列的索引，right，行的索引
        int left = 0, right = matrix.length - 1;
        while (left < matrix[0].length && right >= 0){
            if (target == matrix[right][left]) return true;
            else if (target > matrix[right][left]) left++;
            else right--;
        }
        return false;
    }

/*    //把二维数组当成一维数组来搜索，不需要新建一个数组，只更改索引坐标即可
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length, left = 0, right = n * m - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (target == matrix[mid / n][mid % n]) return true;
            else if (matrix[mid / n][mid % n] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }*/

/*    //把二维数组转化为一维的，可以使用二分法来求解，复杂度应该是o（n*m），主要是转化一维数组的时候复杂度较高
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int[] nums = new int[matrix.length * matrix[0].length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                nums[k++] = matrix[i][j];
            }
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return true;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}