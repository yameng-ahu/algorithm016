package leetcode.editor.cn;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 512 👎 0

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //map中key存放的是字符串，value存放的是该字符串的所有字母异位词
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        if (strs.length == 0) return new ArrayList<>();
        for (String s : strs){
            char[] cnt = new char[26];
            for (char c : s.toCharArray()) cnt[c - 'a']++;
            String key = String.valueOf(cnt);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}