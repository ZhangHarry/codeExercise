package Algorithm.casual;

import Algorithm.leetcode.util.Tool;

/**
 * Created by zhanghr on 2018/7/28.
 * 给定数组 a1,..,an,b1,..,bn
 * O(1)空间返回a1,b1,a2,...,an,bn
 * 如果要返回a1,bn,a2,bn-1,...,an,b1，也很简单，就先把b1,...,bn翻转就可以
 */

public class NewMerge {
    public static int[] resort(int[] nums){
        int n= nums.length/2;
        int i=1, j= n;
        boolean add = false;
        while (j<nums.length-1){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            if (add){
                j++;
                add = false;
            }else
                add = true;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = new int[2];
        int n = nums.length/2;
        for (int i=0; i<n;i++)
            nums[i] = i;

        for (int i=n; i<n<<1; i++)
            nums[i] = i*100;

        Tool.print(NewMerge.resort(nums));
    }
}
