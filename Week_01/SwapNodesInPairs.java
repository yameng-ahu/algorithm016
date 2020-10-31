package leetcode.editor.cn;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 727 👎 0

public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //递归，链表的题目经常可以用递归来解决
    private ListNode prev = new ListNode(-1);
    public ListNode swapPairs(ListNode head){
        prev.next = head;
        ListNode tmp = prev;
        return dfs(tmp);
    }

    private ListNode dfs(ListNode tmp) {
        //terminator
        if (tmp.next == null || tmp.next.next == null) return prev.next;

        //current logic
        ListNode start = tmp.next;
        ListNode end = tmp.next.next;
        tmp.next = end;
        start.next = end.next;
        end.next = start;

        //drill down
        return dfs(start);
    }
    //用一个tmp来标志
    /*public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode tmp = prev;
        while (tmp.next != null && tmp.next.next != null){
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;

            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start; //此时start.next已经是第三个元素了，所以这里tmp跳到start的位置
        }
        return prev.next;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}