package my;

import java.util.Arrays;

//1.遍历统计每个字符出现的次数，相等即可
//2.对字符串进行排序，比较排序后的字符串，相等即可
//3.使用map来统计
public class LeetCode242 {
    public boolean isAnagram(String s, String t){
        //1.字母是a-z，总共26个，开一个长度26的数组，将字符-a之后的值作为index，值是该字符的频次
        //2.s字符串中+1，t字符串-1
        //3.如果当前字符index的计数器等于0，则返回false
        if(s.length() != t.length()) return false;
        int[] cnt = new int[256];
        for(Character c : s.toCharArray()) cnt[c -'a'] ++;
        for(Character c : t.toCharArray()){
            if(cnt[c - 'a'] == 0) return false;
            cnt[c - 'a'] --;
        }
        return true;
    }

    /*public boolean isAnagram(String s, String t){
        //1.开一个256的数组，将字符的ASCII码作为index，值是该字符的频次
        //2.统计s字符串中每个字符的频次
        //3.遍历t字符串时，每个字符对应频次-1
        //4.如果计数器小于0，则返回false
        if(s.length() != t.length()) return false;
        int[] cnt = new int[256];
        for(int i = 0; i< s.length(); i++) cnt[s.charAt(i)]++;
        for(int i = 0; i < t.length(); i++) {
            if(--cnt[t.charAt(i)] < 0) return false;
        }
        return true;
    }*/

    //字符串排序之后比较
    /*public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }*/

    public static void main(String[] args) {
        String s = "ss";
    }
}
