package my;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(){};
    TreeNode(int val){ this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LeetCode94 {
    //迭代
    public List<Integer> inorderTraversal(TreeNode root){
        //显式的维护一个栈，和递归思想一样
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty()){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    //递归
    /*public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;

    }

    private void inorder(TreeNode root, List<Integer> res) {
        //1.中序遍历，左儿子-父节点-右儿子
        //递归实现，从一棵树的根节点不断的往下访问左儿子，直到左儿子为空，则停止往下搜索，并将该节点加入链表中
        //再访问最后这层的右儿子，如果为空，则返回，这层结点遍历完毕。如果右儿子同样有左右子儿子，继续同样的递归
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }*/

    public static void main(String[] args) {
        //没写循环赋值
        TreeNode tr1 = new TreeNode();
        TreeNode tr2 = new TreeNode();
        TreeNode tr3 = new TreeNode();
        TreeNode tr4 = new TreeNode();
        tr1.val = 2;
        tr2.val = 4;
        tr3.val = 1;
        tr4.val = 3;
        tr1.left = tr2;
        tr1.right = tr3;
        tr2.left = tr4;
        LeetCode94 lt = new LeetCode94();
        List<Integer> res = new ArrayList<>();
        res = lt.inorderTraversal(tr1);
    }

}
