package Algorithm.leetcode.finished;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 * Created by zhanghr on 2018/3/22.
 */

public class MaximumProductSubarray {
    // beat 47.7%
    public int maxProduct(int[] nums) {
        if (nums.length==1)
            return nums[0];
        int[] p= new int[nums.length], n=new int[nums.length];
        if (nums[0]>0){
            p[0]=nums[0];
            n[0]=1;
        }else if (nums[0]<0){
            n[0]=nums[0];
            p[0]=-1;
        }
        for (int i=1;i<nums.length;i++){
            if (nums[i]==0)
                ;
            else if (nums[i]>0){
                p[i]=p[i-1]>0 ? p[i-1]*nums[i] : nums[i];
                n[i]=n[i-1]<0 ? n[i-1]*nums[i] : 1;
            }else if (nums[i]<0){
                p[i]=n[i-1]<0 ? n[i-1]*nums[i] : -1;
                n[i]=p[i-1]>0 ? p[i-1]*nums[i] : nums[i];
            }
        }
        int maxP=-1;
        int maxN=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            if (maxP<p[i])
                maxP=p[i];
            if (maxN<n[i])
                maxN=n[i];
        }
        if(maxP>-1)
            return maxP;
        else
            return maxN;
    }
}
