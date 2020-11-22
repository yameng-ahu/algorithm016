package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2712 👎 0

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }*/
    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int target = -nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (target == nums[left] + nums[right]) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }*/
    /*//双指针，先对数组排序，默认从小到大升序，target从第一个数字开始，left指针从第二个数字开始，right指针从最后一个数字开始；
    // 如果left+right < target， 则left++；否则right--;此处去重的办法是用hashset来存数组
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if (target == nums[left] + nums[right]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;right--;
                }else if (nums[left] + nums[right] < target) left++;
                else right--;
            }
        }
        return new ArrayList<>(res);
    }*/


    /*//结合两数之和，找三个数的和为0，可以转换为 a + b = -c；转化为两数之和的问题
    //先遍历一遍数组把c放进去
    //让a从第1~第n-2个，b从2~第n-1个，c从第3到第n个元素，所以c的index一定要大于b和a的index，要不然会出现重复
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> res = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                int sum = - (nums[i] + nums[j]);
                if (map.containsKey(sum) && map.get(sum) > j){  // map.get(sum) > j的判断是为了去重
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sum);
                    res.add(list);
                }
            }
        }
        return new ArrayList<>(res);
    }*/
    /*    //暴力解法，三层循环遍历数组,超时
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> subres = new ArrayList<>();
                        subres.add(nums[i]);
                        subres.add(nums[j]);
                        subres.add(nums[k]);
                        res.add(subres);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
