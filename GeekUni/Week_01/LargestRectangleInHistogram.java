package leetcode.editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 998 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //对暴力解法2的优化，
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        int maxArea = 0;
        System.arraycopy(heights, 0, newHeights, 1, n);
        for (int i = 0; i < n + 2; i++){
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]){
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                maxArea = Math.max(maxArea, (r - l - 1) * newHeights[cur]);
            }
            stack.push(i);
        }
        return maxArea;
    }
/*    //暴力2：遍历每一个柱子的高度，分别向两边扩散，求每个高度形成的矩形的最大面积（即固定高度，求最大宽度）
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            int left = i;
            int right = i;
            while ((left - 1) >= 0 &&  heights[i] <= heights[left - 1]) left--;
            while ((right + 1) < n && heights[i] <= heights[right + 1]) right++;
            maxArea = Math.max(maxArea, heights[i] * (right - left + 1));
        }
        return maxArea;
    }*/
 /*   //利用双指针，left和right分别指向两头，为什么双指针不对，有什么情况没考虑进去
    //两个指针往里移动，哪边小哪边往里移动找更大的值
    //在这个过程中计算所有的面积，获得最大的面积
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0, j = heights.length - 1; i <= j;){
            int minHeight = heights[i];
            for (int k = i; k <= j; k++){
                minHeight = Math.min(minHeight, heights[k]);
            }
            maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            if (heights[i] < heights[j]) i++;
            else j--;
        }
        return maxArea;
    }*/

    /*//暴力
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++){
            int min = heights[i];
            for (int j = i; j < heights.length; j++){
                min = Math.min(min, heights[j]);
                area = Math.max(area, min * (j - i + 1));
            }
        }
        return area;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}