package Algorithm.leetcode.finished;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhanghr on 2018/7/31.
 * Given a list of non negative integers, arrange them such that they form the largest number.

 Example 1:

 Input: [10,2]
 Output: "210"
 Example 2:

 Input: [3,30,34,5,9]
 Output: "9534330"
 */

public class LargestNumber {public String largestNumber(int[] nums) {
    Integer[] array = new Integer[nums.length];
    for (int i=0;i<nums.length;i++)
        array[i] = nums[i];
    BigComparator comparator = new BigComparator();
    Arrays.sort(array, comparator);
    if (array[0] == 0)
        return "0";
    StringBuilder sb = new StringBuilder();
    for (int num : array){
        sb.append(num);
    }
    return sb.toString();
}
    class BigComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2){
            String s1 = i1+""+i2;
            String s2 = i2+""+i1;
            return s2.compareTo(s1);
        }
    }
}
