package Algorithm.leetcode.finished;

/**
 *
 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]

 * Created by zhanghr on 2018/7/8.
 */
import java.util.*;
public class FindAllDuplicatesInArray {
    // 99.58%
    // 思路是：因为元素是有序的1~n，所以保证每个元素在自己的位置上即可。因为我们提前知道元素的位置，所以O(n)时间+O(1)空间可以完成。
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int n = nums.length;
        int i=0;
        while (i<n){
            if (nums[i] != i+1){
                int index = nums[i];
                if(nums[index-1] != index){
                    swap(nums, i, index-1);
                }else
                    i++;
            }else
                i++;
        }
        i =0;
        while (i<n){
            if (nums[i] != i+1){
                list.add(nums[i]);
            }
            i++;
        }
        return list;
    }

    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args){
        FindAllDuplicatesInArray test = new FindAllDuplicatesInArray();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.print(test.findDuplicates(nums));
    }
}
