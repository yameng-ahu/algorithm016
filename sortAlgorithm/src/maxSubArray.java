//要求输出  最大连续子数组的和对应的子数组
public class maxSubArray {
    public int[] maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
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
        }
        int[] res = new int[endIndex - beginIndex + 1];
        //for (int i = beginIndex; i <= endIndex; i++){
        //    int k = (i + 1) % res.length;
        //    res[k] = nums[i];
        //}
        //return res;
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
