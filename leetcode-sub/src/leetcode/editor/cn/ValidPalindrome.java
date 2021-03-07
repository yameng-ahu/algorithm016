package leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 342 👎 0

public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        String s_to = s.toLowerCase();
        for (char ch : s_to.toCharArray()){
            if ((ch - '0' >= 0 && ch - '0' <= 9) || (ch >= 'a' && ch <= 'z')){
                s1.append(ch);
            }
        }

        for (int i = s_to.length() - 1; i >= 0; i--){
            char ch = s_to.charAt(i);
            if ((ch - '0' >= 0 && ch - '0' <= 9) || (ch >= 'a' && ch <= 'z')){
                s2.append(ch);
            }
        }
        return (s1.toString()).equals(s2.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}