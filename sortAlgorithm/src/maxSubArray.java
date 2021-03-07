//要求输出  最大连续子数组的和对应的子数组
public class maxSubArray {
    public int[] maxSubArray(int[] nums) {
        //暴力解法
        /*int max = Integer.MIN_VALUE;
        int beginIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum > max){
                    max = sum;
                    endIndex = j;
                    beginIndex = i;
                }
            }
        }*/

        //dp：dp[i]为前i个数字组成的数组的最大子序和，那么要判断当前数是否可以加到前面的队列里，或者直接从当前数开始往后再找新的连续数组
        //dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        int beginIndex = 0, endIndex = 0;
        for (int i = 1; i < nums.length; i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
                beginIndex = i;
            }

            if (max < dp[i]){
                max = dp[i];
                endIndex = i;
            }
        }
        int[] res = new int[endIndex - beginIndex + 1];
        System.arraycopy(nums, beginIndex, res, 0, res.length);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] res = new maxSubArray().maxSubArray(nums);
        for (int a : res){
            System.out.println(a);
        }
    }
}
