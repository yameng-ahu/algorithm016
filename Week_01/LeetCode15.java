package my;

import java.util.*;

public class LeetCode15
{
    /*public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++){
            for(int j = i+1; j < nums.length -1; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }*/
    /*public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++){
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i+1; j < nums.length-1; j++){
                int v = target - nums[j];
                if(map.containsKey(v)){

                }
                map.put(v, )
            }
        }
        return new ArrayList<>(result);
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 2) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if (nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) i++;

            int lo = i+1, hi = nums.length-1, sum = -nums[i];
            while (lo < hi){
                if(nums[lo] + nums[hi] == sum){
                    res.add(Arrays.asList(nums[lo], nums[i], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;hi--;
                }else if(nums[lo] + nums[hi] < sum) lo ++;
                else hi--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
//    	Scanner sc = new Scanner(System.in);
//    	int [] nums = new int[6];
//    	for (int i = 0; i < nums.length; i++) {
//    		nums[i] = sc.nextInt();
//    	}
    	int [] nums = new int[] {0, 0, 0};
    	List<List<Integer>> res = new LeetCode15().threeSum(nums);
    }
}
