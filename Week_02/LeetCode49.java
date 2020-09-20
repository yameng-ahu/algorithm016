package my;

import java.util.*;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //开一个长度26的数组，统计每个字符出现的次数，字符的ascii码-a的值作为每个字符出现次数对应的index
        //字符出现的次数和#作为key，对应符合条件的字符串作为value，
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for(String s : strs){
            char[] cnt = new char[26];
            for(char c : s.toCharArray()) cnt[c - 'a'] ++;
            String key = String.valueOf(cnt);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
    /*public List<List<String>> groupAnagrams(String[] strs) {
        //开一个长度26的数组，统计每个字符出现的次数，字符的ascii码-a的值作为每个字符出现次数对应的index
        //字符出现的次数和#作为key，对应符合条件的字符串作为value，
        if(strs.length == 0) return new ArrayList<>();
        int[] cnt = new int[26];
        Map<String, List> map = new HashMap<>();
        for(String s : strs){
            Arrays.fill(cnt, 0);
            for(char c : s.toCharArray()) cnt[c - 'a'] ++;

            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++){
                sb.append('#');
                sb.append(cnt[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }*/

    /*public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }*/
}
