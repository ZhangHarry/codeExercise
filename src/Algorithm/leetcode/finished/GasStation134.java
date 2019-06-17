package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/9/30.
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

 Note:

 If there exists a solution, it is guaranteed to be unique.
 Both input arrays are non-empty and have the same length.
 Each element in the input arrays is a non-negative integer.
 Example 1:

 Input:
 gas  = [1,2,3,4,5]
 cost = [3,4,5,1,2]

 Output: 3

 */

public class GasStation134 {
    // beat 100%
    // 如果gas总和大于等于cost一定有解，贪婪算法，最后一段连续子序列和非负的起点，可以通过反证法证明。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int curI = 0;
        int cur = Integer.MIN_VALUE;
        for (int i=0; i<gas.length; i++){
            int tmp = gas[i]-cost[i];
            sum += tmp;
            if (cur < 0){
                cur = tmp;
                curI = i;
            }else{
                if (cur + tmp >=0){
                    cur += tmp;
                }else{
                    cur = tmp;
                    curI = i;
                }
            }
        }
        if (sum < 0)
            return -1;
        else
            return curI;
    }
}
