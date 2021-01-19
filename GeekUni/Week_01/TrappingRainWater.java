package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1815 👎 0

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    //双指针
    public int trap(int[] height) {
        int left_max = 0, right_max = 0;
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left <= right){
            if (left_max < right_max){
                ans += Math.max(0, left_max - height[left]);
                left_max = Math.max(left_max, height[left]);
                left++;
            }else {
                ans += Math.max(0, right_max - height[right]);
                right_max = Math.max(right_max, height[right]);
                right--;
            }
        }
        return ans;
    }
    /*//类似84题-柱状图中的最大矩形，找当前柱子的左右边界，也可以通过单调递减栈来解决
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int cur = stack.pop();
                if (stack.isEmpty()) break;
                int r = i;
                int l = stack.peek();
                int h = Math.min(height[r], height[l]) - height[cur];
                ans += (r - l -1) * h;
            }
            stack.push(i);
        }
        return ans;
    }*/
/*    //优化暴力解法的时间复杂度
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        right_max[n - 1] = height[n - 1];
        int ans = 0;
        for (int i = 1; i < n; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++){
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }*/
    //1.暴力解法，
//   a.对于当前柱子，向左找最大高度，向右找最大高度，雨水能够达到的最高的位置即为两个高度中的较小者
//   b.能够承接的雨水的量，是每根柱子累加的结果
/*    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++){
            int max_left = height[i];
            int max_right = height[i];
            for (int j = i; j >= 0; j--){
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < n; j++){
                max_right = Math.max(max_right, height[j]);
            }
            ans += (Math.min(max_left, max_right) - height[i]);
        }
        return ans;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}