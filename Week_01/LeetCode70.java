package my;

public class LeetCode70 {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int fn2 = 1;
        int fn1 = 2;
        int fn = 0;
        for(int j = 3; j<= n; j++){
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }
        return fn;
    }
    /*public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int j = 3; j <= n; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }
        return dp[n];
    }*/
}
