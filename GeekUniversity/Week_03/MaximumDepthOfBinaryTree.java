package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 706 👎 0

public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
  //Definition for a binary tree node.
public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    public int maxDepth(TreeNode root) {
        //递归终止条件
        if(root == null) return 0;

        //当前层的逻辑
        //下一层的逻辑
        int lenL = maxDepth(root.left);
        int lenR = maxDepth(root.right);
        return Math.max(lenL, lenR) + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}