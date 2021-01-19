package leetcode.editor.cn;

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 111 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        
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
    public List<List<Integer>> levelOrder(Node root) {
        //BFS
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                level.add(node.val);
//                queue.addAll(node.children);  或者用下面的for循环，addAll的时间复杂度好像低一些
                for (Node child : node.children) queue.add(child);
            }
            res.add(level);
        }
        return res;
    }

    /*private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return res;
        dfs(0, root);
        return res;
    }

    private void dfs(int level, Node node) {
        //terminator

        //current logic???判断是否是新的一层，res的最终size=level，如果size < level,说明到下一层了
        if (res.size() <= level) {
            res.add(new ArrayList<>());
            //return;
        }
        res.get(level).add(node.val);
        //drill down
        for (Node child : node.children){
            dfs(level + 1, child);
        }
        //revert states
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}