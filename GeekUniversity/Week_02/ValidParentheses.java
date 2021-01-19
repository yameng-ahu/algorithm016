package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1961 👎 0

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s){
        if (s.length() % 2 == 1) return false;
        Deque<Character> stk = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

/*        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                stk.push(c);
            }else{
                if (!stk.isEmpty() && stk.peek() == map.get(c)){
                    stk.pop();
                }else return false;
            }
        }
        return stk.isEmpty();*/

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stk.isEmpty() || stk.peek() != map.get(ch)) {
                    return false;
                }
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        return stk.isEmpty();
    }
    //遇到左括号存的时候，存对应的右括号，这样遇到右括号的时候可以直接判断pop出来的括号是否和该括号相等即可
    /*public boolean isValid(String s){
        Deque<Character> stk = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stk.push(')');
            else if (c == '[') stk.push(']');
            else if (c == '{') stk.push('}');
            else if (stk.isEmpty() || c != stk.pop()) return false;
        }
        return stk.isEmpty();
    }*/
    //较为不好看的一种写法
    //弄清楚什么时候push，什么时候pop（如果左括号和右括号匹配，则弹出对应的右括号），
    // 其他情况都false就可以了（如果左括号和右括号不匹配，可以直接false）
/*    public boolean isValid(String s) {
        Deque<Character> stk = new LinkedList<>();
        stk.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '('){
                stk.push(c);
            }else if (c == ']' && !stk.isEmpty() && stk.peek() == '['){
                stk.pop();
            }else if (c == ')' && !stk.isEmpty() && stk.peek() == '('){
                stk.pop();
            }else if (c == '}' && !stk.isEmpty() && stk.peek() == '{'){
                stk.pop();
            }else return false;
        }
        return stk.isEmpty();
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}