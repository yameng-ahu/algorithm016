package leetcode.editor.cn;

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 465 👎 0

public class WordLadder{
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //BFS
        // 用一个set来存储每次开始变换时候的单词
        //最近重复子问题：分别用a-z的字母替换start单词中的每个字符，如果替换之后的单词在字典里面，
        // 则将替换后的单词放到另一个set中，且在wordList中移除该单词
        Set<String> wordDict = new HashSet<String>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;

        while (!reached.contains(endWord)){
            Set<String> toAdd = new HashSet<>();
            for (String each : reached){
                for (int i = 0; i < each.length(); i++){
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch ++){
                        chars[i] = ch;
                        String newWord = new String(chars);
                        if (wordDict.contains(newWord)){
                            toAdd.add(newWord);
                            wordDict.remove(newWord);
                        }
                    }
                }
            }
            distance ++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}