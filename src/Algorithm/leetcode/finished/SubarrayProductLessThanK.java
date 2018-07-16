package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/11.
 *
 Your are given an array of positive integers nums.

 Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

 Example 1:
 Input: nums = [10, 5, 2, 6], k = 100
 Output: 8
 Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 Note:

 0 < nums.length <= 50000.
 0 < nums[i] < 1000.
 0 <= k < 10^6.
 *
 */
import java.util.*;
public class SubarrayProductLessThanK {
    // time limit
    // 思路：使用一个列表存储可以接收的当前元素结尾的相邻元素
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0)
            return 0;
        int sum = 0;
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i] >= k){
                list = new LinkedList<>();
            }else {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(nums[i]);
                int cur = nums[i];
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()){
                    int next = it.next();
                    cur = cur * next;
                    if (cur < k){
                        tmp.add(next);
                    }else
                        break;
                }
                list = tmp;
                sum += list.size();
            }
        }
        return sum;
    }

    // beat 3%
    // 思路：处理元素是1的问题，极限条件下全部是1的话，当数组很大时会导致运行很慢
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if(k<=0 || nums.length == 0)
            return 0;
        int sum = 0;
        List<Pair> list = new LinkedList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i] >= k){
                list = new LinkedList<>();
            }else {
                List<Pair> tmp = new LinkedList<>();
                Iterator<Pair> it = list.iterator();

                int cur = nums[i];
                Pair t;
                if (nums[i] == 1 && it.hasNext()){
                    if ((t = it.next()).item == 1){
                        t.size++;
                        tmp.add(t);
                        sum += t.size;
                    }else {
                        tmp.add(new Pair(1,1));
                        sum += 1;
                        if (t.item < k){
                            tmp.add(new Pair(t.item, 1));
                            sum += 1;
                            cur = t.item;
                        }else {
                            list=new LinkedList<>();
                            it = list.iterator();
                        }
                    }
                }else {
                    Pair p = new Pair(cur, 1);
                    tmp.add(p);
                    sum += p.size;
                }
                while (it.hasNext()) {
                    Pair p = it.next();
                    int next = p.item;
                    cur = cur * next;
                    if (cur < k) {
                        tmp.add(p);
                        sum += p.size;
                    } else
                        break;
                }
                list = tmp;
            }
        }
        return sum;
    }
}
class Pair{
    int item;
    int size;
    Pair(int item, int size){
        this.item= item;
        this.size = size;
    }
}