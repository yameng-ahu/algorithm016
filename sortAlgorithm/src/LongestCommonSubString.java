public class LongestCommonSubString {
    //求两个字符串的最长公共子串
    public String longestString(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0, endIndex = 0;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] > max){
                    max = dp[i][j];
                    endIndex = j;
                }

            }
        }
        return s2.substring(endIndex - max, endIndex);
    }

    public static void main(String[] args) {
        String s1 = "exdrwdde";
        String s2 = "aaxdr";
        String str = new LongestCommonSubString().longestString(s1, s2);
        System.out.println(str);
    }
}
