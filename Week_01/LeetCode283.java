package my;

import java.util.Scanner;

public class LeetCode283
{
	public int [] moveZeros(int [] nums) {
		if (nums == null || nums.length == 0) {
			nums = null;
		}
		
		int insertPos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[insertPos++] = nums[i];
			}
		}
		while (insertPos < nums.length) {
			nums[insertPos++] = 0;
		}
		return nums;
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please input an array:");
		int [] num = new int[5];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			//System.out.println(num[i]);
		}
		int [] result = new LeetCode283().moveZeros(num);
//		System.out.println(result);
		for (int re: result) {
			System.out.println(re);
		}
	}
}
