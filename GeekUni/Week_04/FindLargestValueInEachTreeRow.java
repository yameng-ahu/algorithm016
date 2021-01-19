package leetcode.editor.cn;

//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 95 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow{
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(max);
        }
        return res;
    }

    /*//DFS
    //与二叉树的层次遍历思路类似
    private List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return  res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        //terminator
        if (root == null) return;

        //process current logic
        //如果走到下一层了直接加入到集合中
        if (res.size() <= level){
            res.add(root.val);
        }
        res.set(level, Math.max(res.get(level), root.val));

        //drill down
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}