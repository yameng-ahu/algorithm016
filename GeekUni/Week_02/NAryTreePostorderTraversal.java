package leetcode.editor.cn;

//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 113 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /*//迭代
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<Node> stk = new LinkedList<>();
        stk.add(root);
        while (!stk.isEmpty()){
            Node node = stk.pollLast();
            res.addFirst(node.val);
            for (Node child : node.children){
                if (child != null) stk.add(child);
            }
        }
        return res;
    }*/
    //同上相同的思路，只不过用栈，不用双端队列
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> stk = new LinkedList<>();
        stk.push(root);
        while (!stk.isEmpty()){
            root = stk.pop();
            res.add(0, root.val);
            for (Node child : root.children){
                stk.push(child);
            }
        }
        return res;
    }
    /*//dfs
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null) return;

        for (Node child : root.children){
            dfs(child);
        }
        res.add(root.val);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}