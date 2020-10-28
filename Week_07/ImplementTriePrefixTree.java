package leetcode.editor.cn;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 445 👎 0

public class ImplementTriePrefixTree{
    public static void main(String[] args) {
        Solution solution = new ImplementTriePrefixTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class TrieNode{
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(){};
    }

    public class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) ws.children[c - 'a'] = new TrieNode();
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean search(String word){
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public boolean startsWith(String word){
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}