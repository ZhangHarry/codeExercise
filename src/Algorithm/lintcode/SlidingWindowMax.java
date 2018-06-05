package Algorithm.lintcode;

/**
 * 关键在于使用辅助链表存储index而不是具体的值，该链表保证排序。
 * 运行快的思想在于
 * 1、每次移动窗口不需要马上从链表中找到移走的元素，而是一次性顺序移除
 * 2、与排序nlogn的复杂度不同，链表在添加新元素时可以把比它小的元素移除，缩短链表
 *
 * Created by zhanghr on 2018/5/26.
 */
import java.util.*;
public class SlidingWindowMax {
    /*
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The maximum number inside the window at each moving
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> list = new ArrayList(k);
        if (nums.length < k || k <= 0)
            return list;
        LinkedList<Integer> maxList = new LinkedList<>();
        for (int i=0; i<nums.length; i++){

            while (!maxList.isEmpty() && maxList.get(0) <= i-k){
                maxList.remove(0);
            }
            while (!maxList.isEmpty() && nums[maxList.getLast()] < nums[i]){
                maxList.removeLast();
            }
            maxList.add(i);

            if (i >= k-1)
                list.add(nums[maxList.get(0)]);
        }
        return list;
    }

    public static void main(String[] args){
        SlidingWindowMax test = new SlidingWindowMax();
        test.maxSlidingWindow(new int[]{
                1,2,7,7,2
                 },3);
    }
}
