package leetcode.editor.cn;

//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1310 👎 0

public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
/*    //递归的写法2
    private ListNode prev = null;
    private ListNode tmp = null;
    public ListNode reverseList(ListNode head) {
        //terminator
        if (head == null) return prev;

        //current logic
        tmp = head.next;
        head.next = prev;
        prev = head;
        head = tmp;

        //drill down
        return reverseList(head);
    }*/
    //递归的解法
    public ListNode reverseList(ListNode head){
        return dfs(null, head);
    }

    private ListNode dfs(ListNode prev, ListNode cur) {
        //terminator
        if (cur == null) return prev;

        //current logic
        ListNode tmp = cur.next;
        cur.next = prev;

        //drill down
        return dfs(cur, tmp);
    }
    public ListNode reverseList(ListNode head) {
        //1.第一个条件是判断递归开始，传入的参数的合法性。第二个是递归的终止条件
        if(head == null || head.next ==null) return head;
        //2.开始进行递归
        ListNode newHead = reverseList(head.next);
        //3.尾部4-5-null中，head=4,head.next=4-5 head.next.next=4-5-null,也就是5的后继指向4
        head.next.next = head;
        //4.断开之前4-5之间的连接，将4的后继指向null
        head.next = null;
        //5.返回已经反转的链表
        return newHead;
    }
/*    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}