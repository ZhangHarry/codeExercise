package Algorithm.leetcode.finished;

/**
 * Given an array of integers, return indices of the two numbers such that they addNext up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Created by zhanghr on 2016/12/14.
 */
public class Code1 {

    /**
     * 16 test cases 39ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i <nums.length; i++){
            for (int j=i;j<nums.length;j++){
                if (nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return null;
    }

    /**
     * 16 test cases 11ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>(nums.length);
        for(int i = 0; i <nums.length; i++){
            String temp = ""+(target - nums[i]);
            Integer key = map.get(temp);
            if (key == null)
                map.put(""+nums[i], i);
            else
                return new int[]{i, key};
        }
        return null;
    }


    /**
     * 16 test cases 7ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>(nums.length);
        for(int i = 0; i <nums.length; i++){
            Integer key = map.get(target - nums[i]);
            if (key == null)
                map.put(nums[i], i);
            else
                return new int[]{i, key};
        }
        return null;
    }

    public static void main(String[] args){
        new Code1().twoSum2(new int[]{3, 2, 4}, 6);
    }
}
