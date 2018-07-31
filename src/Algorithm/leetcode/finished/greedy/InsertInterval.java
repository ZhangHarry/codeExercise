package Algorithm.leetcode.finished.greedy;

/**
 * Created by zhanghr on 2018/7/31.
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
import Algorithm.leetcode.util.Interval;

import java.util.*;
public class InsertInterval {
    // 12%
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> resList = new LinkedList<>();
        Iterator<Interval> it = intervals.iterator();
        while (it.hasNext()){
            Interval cur = it.next();
            if (cur.start < newInterval.start){
                if (cur.end >= newInterval.end){
                    newInterval.start = cur.start;
                    newInterval.end = cur.end;
                    it.remove();
                    break;
                }else if (cur.end < newInterval.start){
                    resList.add(cur);
                    it.remove();
                }else{
                    newInterval.start = cur.start;
                    it.remove();
                }
            }else{
                if (newInterval.end < cur.start){
                    break;
                }else if (newInterval.end <= cur.end){
                    newInterval.end = cur.end;
                    it.remove();
                    break;
                }
                it.remove();
            }
        }
        resList.add(newInterval);
        resList.addAll(intervals);
        return resList;
    }
}
