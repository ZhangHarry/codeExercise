package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/15.
 Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 Example 1:
 Input: [ [1,2], [2,3], [3,4], [1,3] ]

 Output: 1

 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 */
import Algorithm.leetcode.util.Interval;
import java.util.*;

public class NonOverlappingIntervals {
    // beat 93%
    // 思路：排序然后贪婪算法一次遍历，需要注意的地方是我们需要根据end进行排序而不是start，因为end才是贪婪时区分两个interval的标准。
    public int eraseOverlapIntervals(Interval[] intervals) {
        int result = 0;
        if (intervals.length <= 1)
            return result;
        Arrays.sort(intervals,new Comp());
        Interval pre = intervals[0];
        for (int i=1; i<intervals.length; i++){
            Interval interval = intervals[i];
            if(interval.start<pre.end){
                result++;
            }else{
                pre =interval;
            }
        }
        return result;
    }

    class Comp implements Comparator<Interval>{
        public int compare(Interval c1, Interval c2){
            return c1.end-c2.end;
        }
    }

    public static void main(String[] args){
        Interval[] intervals = new Interval[]{
                new Interval(1,3),
                new Interval(2,4),
                new Interval(3,5)
        };
        NonOverlappingIntervals test = new NonOverlappingIntervals();
        System.out.print(test.eraseOverlapIntervals(intervals));
    }
}
