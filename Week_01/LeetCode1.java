package my;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LeetCode1
{
    public int[] twoSum(int[] nums, int target){
        /*int [] index = new int[2];
        int left = 0, right = nums.length - 1;
      //  int[] num = Arrays.sort(nums);
        while (left < right){
            if (nums[left] + nums[right] < target){
                left ++;
            } else if (nums[left] + nums[right] > target){
                right --;
            } else{
                index[0] = left;
                index[1] = right;
            }
            // if (nums[left] + nums[right] == target){
            //     index[0] = left;
            //     index[1] = right;
            // }

        }
        return index;*/
/*暴力遍历*/
/*    int [] index = new int[2];
    for(int i = 0; i < nums.length; i++){
        for (int j = i+1; j < nums.length; j++){
            if(nums[i] + nums[j] == target){
                index[0] = i;
                index[1] = j;
                return index;
            }
        }
    }
    return index;*/
/*两遍hash表*/
/*        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[] {i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");*/

/*一遍hash表*/
/*        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length-1; i++){
           // if(map.containsKey(nums[i]))
            map.put(nums[i], i);
            if(map.containsKey(target-nums[i+1])){
                return new int[] {map.get(target-nums[i+1]), i+1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");*/
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int[] nums = new int[x];
        for(int i = 0; i < x; i++){
            nums[i] = in.nextInt();
        }*/
        int[] nums = new int[] {2,5,7,11};
        LeetCode1 sum = new LeetCode1();
        int[] index = sum.twoSum(nums, 9);
        System.out.println(index[0] + " and " + index[1]);
    }
}
