package leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 662 👎 0

import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS
        //如果不需要像题目那样每一层分开保存结点，则可以
        // 最近重复子问题：queue出栈当前层的第一个结点，并保存该结点到res中，queue添加第一个结点的子节点，
        // queue出栈当前层的第二个结点（此时栈顶的元素即为第二个结点），并保存该结点到res中，queue添加第二个结点的子节点，以此类推

        //如果需要按每一层来保存结点，只需要按照当前层的结点元素个数，遍历poll队列中的元素即可
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
    /*private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //DFS
        int level = 0;
        if (root == null) return res;
        dfs(root, level);
        return res;
    }
    private void dfs(TreeNode root, int level){
        // terminator
        if (root == null) return;

        //process current logic
        if (res.size() <= level){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(level).add(root.val);
        //drill down
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        //revert states
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)

}