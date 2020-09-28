package leetcode.editor.cn;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 815 👎 0

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = {1,2,3};
        solution.subsets(nums);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //迭代的办法
        //数字1的时候，产生[], [1],
        //最近重复子问题：到数字2的时候，将上一轮产生的子集遍历出来，把2分别放到以上子集里面
        //终止条件：到最后一个数字
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null) return result;
        for (int n : nums){
            int size = result.size();
            for (int i = 0; i < size; i++){
                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(n);
                result.add(list);
            }
        }
        return result;
    }
    /*public List<List<Integer>> subsets(int[] nums) {
        //回溯，类似左括号和右括号的问题，每一个数/每一个格子都可选可不选，
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null) return res;
        dfs(res, nums, list, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int index) {
        // terminator
        if (index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        // current logic
        // drill down
        dfs(res, nums, list, index + 1);

        list.add(nums[index]);
        dfs(res, nums, list, index + 1);

        //revert states
        list.remove(list.size() - 1);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}