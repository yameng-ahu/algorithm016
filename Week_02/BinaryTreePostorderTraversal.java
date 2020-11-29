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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    //这种迭代是修改了二叉树的前序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
//        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (!stk.isEmpty() || root != null){
            while (root != null){
                res.addFirst(root.val);
//                res.add(0, root.val);
//                stk.push(root);
                stk.add(root);
                root = root.right;
            }
//            root = stk.pop();
            root = stk.pollLast();
            root = root.left;
        }
        return res;
    }

/*    //层序遍历的改写
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> stk = new LinkedList<>();
        stk.push(root);
        while (!stk.isEmpty()){
            root = stk.pop();
            res.add(0, root.val);
            if (root.left != null) stk.push(root.left);
            if (root.right != null) stk.push(root.right);
        }
        return res;
    }*/
    /*//迭代，正确的后序遍历顺序
    // 先一直往左子树递归，直到左子树为空，将根节点出栈，访问该根节点的右子树，但是此时根节点没有打印，
    // 所以需要判断，如果右子树为空或者右子树已经访问过的话（一个节点左右子树都有的时候，会出现右子树已经访问过的情况），表明a结点遍历结束（左右子树都为空），则打印该根节点（比如a结点），
    // 如果右子树不为空，则a结点没有遍历结束，需要把a结点重新入栈，将其右子树继续和左子树同样的过程，满足条件最后才打印该a节点
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
    }*/
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