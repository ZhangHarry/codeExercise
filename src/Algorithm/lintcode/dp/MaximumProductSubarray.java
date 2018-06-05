package Algorithm.lintcode.dp;

/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 Example
 For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

 * Created by zhanghr on 2018/6/4.
 */

public class MaximumProductSubarray {
    /**
     * beat 74%
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE;
        int p =0, n=0;
        if (nums[0]>=0){
            p = nums[0];
            max = p;
        }
        else{
            n = nums[0];
            max = n;
        }
        for (int i=1; i<nums.length; i++){
            if (nums[i]>=0){
                p = p == 0 ? nums[i] : p*nums[i];
                n = n == 0 ? 0 : n*nums[i];
                max = Math.max(max, Math.max(p, n));
            }else {
                int tmpP = p; //注意：这里的临时变量，因为n依赖p原来的值
                p = n == 0 ? 0 : n*nums[i];
                n = tmpP == 0 ? nums[i] : tmpP*nums[i];
                max = Math.max(max, Math.max(p, n));
            }
        }
        return max;
    }

    public static void main(String[] args){
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] array = new int[]{-2,-3,-4};
        System.out.println(test.maxProduct(array));
    }
}
