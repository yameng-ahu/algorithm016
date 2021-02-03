package leetcode.editor.cn;

//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 383 👎 0

import java.util.PriorityQueue;

public class UglyNumberIi{
    public static void main(String[] args) {
        //int n = 3;
        Solution solution = new UglyNumberIi().new Solution();
        //solution.nthUglyNumber(n);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //丑数的计算，先用3个因子获取最小的三个丑数2 3 5，下一个丑数则是用之前的丑数同样乘以2或3或5，
    //用最小堆维护丑数的顺序，堆的大小为n，因为会有重复的数字，所以需要去重
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
       // long answer = 1;
        pq.add(1L);
        for (int i = 1; i < n; i++){
            long answer = pq.poll();
            while (!pq.isEmpty() && answer == pq.peek()) pq.poll();
            pq.add(answer * 2);
            pq.add(answer * 3);
            pq.add(answer * 5);
        }
        return pq.poll().intValue();
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//        long answer = 1;
//        for (int i = 0; i < n - 1; i++){
//            pq.add(answer * 2);
//            pq.add(answer * 3);
//            pq.add(answer * 5);
//            answer = pq.poll();
//            while (!pq.isEmpty() && answer == pq.peek()) pq.poll();
//        }
//        return (int)answer;
    }
/*    public int nthUglyNumber(int n) {
        //动态规划的思想
        //dp[]初始化只包含一个丑数1，初始化三个指针p2 p3 p5，代表第几个数和2 3 5相乘
        //比较，取最小的丑数，判断最小的丑数是哪个指针相乘得到的，则该指针往前挪
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == 2 * dp[p2]) p2 ++;
            if(dp[i] == 3 * dp[p3]) p3 ++;
            if(dp[i] == 5 * dp[p5]) p5 ++;
        }
        return dp[n-1];
    }*/
    /*public int nthUglyNumber(int n) {
        //用小顶堆来存放前n个丑数
        //1）丑数的计算：一个丑数乘以2 3 5还是丑数，把1（最小的丑数）放到heap里面，每次弹出root，即为最小的丑数，用来计算后面的丑数，添加到heap里面
        //2）while最近重复子问题：每次弹出root，即为最小的丑数，用来计算后面的丑数，添加到heap里面(要去重)
        //3）if分支如果弹出的次数大于等于n，说明已经找到了第n个丑数，弹出该数即可
        //4）while截止条件：heap为空
        PriorityQueue<Long> heap = new PriorityQueue<>();
        int[] uglyNum = {2, 3, 5};
        int count = 0;
        heap.add(1L);
        while(!heap.isEmpty()){
            long cnt = heap.poll();
            if(++ count >= n){
                return (int)cnt;
            }
            for(int num : uglyNum){
                if(!heap.contains(num * cnt)) heap.add(num * cnt);
            }
        }
        return -1;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}