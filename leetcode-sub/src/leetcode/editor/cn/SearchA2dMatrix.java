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
        //i 行的索引，j列的索引
        int j = 0, i = matrix.length - 1;
        while (j < matrix[0].length && i >= 0){
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) j++;
            else i--;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}