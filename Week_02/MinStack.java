package leetcode.editor.cn;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 715 👎 0

import javax.print.DocFlavor;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        Solution solution = new MinStack().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    /** initialize your data structure here. */
    //在栈里面保存当前数和最小数的差值
    Deque<Long> stack;
    long min;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min = x;
        }else {
            stack.push(x - min);
            min = Math.min(x, min);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long pop = stack.pop();
        if (pop < 0) min = min - pop;

    }

    public int top() {
        if (stack.peek() > 0){
            return (int)(stack.peek() + min);
        }else
            return (int)min;
    }

    public int getMin() {
        return (int)min;
    }

    /*Deque<Integer> stack;
    int min;
    public MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int peek = stack.pop();
        if (peek == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }*/

    /*//在栈里面同时存最小值和当前值（可作为一个对象存进去）
    static class Element{
        final int value;
        final int min;
        Element(final int value, final int min){
            this.value = value;
            this.min = min;
        }
    }
    final Deque<Element> stk = new LinkedList<>();
    *//*public MinStack() {
       final Deque<Element> stk = new LinkedList<>();
    }*//*

    public void push(int x) {
        final int min = (stk.isEmpty()) ? x : Math.min(stk.peek().min, x);
        stk.push(new Element(x, min));
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek().value;
    }

    public int getMin() {
        return stk.peek().min;
    }*/


    /*//借助辅助栈来存最小值
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }*/
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}