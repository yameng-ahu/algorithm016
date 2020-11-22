package leetcode.editor.cn;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 477 👎 0

public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        
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
    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode visited = null;
        while (root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (root.right == null || root.right == visited){
                res.add(root.val);
                visited = root;
                root = null;
            }else{
                stk.push(root);
                root = root.right;
            }
        }
        return res;
    }
    /*//递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}