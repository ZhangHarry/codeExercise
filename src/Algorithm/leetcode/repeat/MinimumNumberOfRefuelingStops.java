package Algorithm.leetcode.repeat;

import Algorithm.leetcode.util.Tool;

/**
 * Created by zhanghr on 2018/8/1.
 * A car travels from a starting position to a destination which is target miles east of the starting position.

 Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.

 The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

 When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

 What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.

 Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 */

import java.util.*;

public class MinimumNumberOfRefuelingStops {
    // 答案不对，该解法与frog game相同，但是实际上不同，因为汽油可以积累。
    // 正确解法通过一个优先队列来维护所有可以获得的汽油，每次从该队列中取出最大的汽油，增大到startFuel。直至队列为空或者已经到了target。
    // 其实该解法与正常思路一样--我们要做的是在同样的停顿次数内获得最多的汽油！！！！可达位置中从大到小按需得到汽油。想出解法后，亮点是优先队列。
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target)
            return 0;
        if (stations.length == 0)
            return -1;
        int res = 0;
        int[][] nstations = new int[stations.length+1][2];
        nstations[0][0] = 0;
        nstations[0][1] = startFuel;
        for (int i=1; i<nstations.length; i++){
            nstations[i][0] = stations[i-1][0];
            nstations[i][1] = stations[i-1][1];
        }
        stations = nstations;
        for (int i=0; i<stations.length; ){
            int j=i+1;
            int max = Integer.MIN_VALUE;
            int index = j;
            while (j<stations.length && startFuel >= stations[j][0]){
                if (startFuel+stations[j][1] >= max &&
                        (j == stations.length-1 || startFuel+stations[j][1] >= stations[j+1][0])){
                    index = j;
                    max = startFuel+stations[j][1];
                }
                j++;
            }
            System.out.println(index +" " + startFuel);
            if (max < 0)
                return -1;
            i = index;
            startFuel = max;
            res++;
            if (max >= target)
                return res;
        }
        return -1;
    }

    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0, fuel= startFuel, i = 0;
        while(true) {
            if (fuel >= target) return ans;
            while(i < stations.length && stations[i][0] <= fuel)
                pq.add(stations[i++][1]);
            if (pq.isEmpty()) return -1;
            fuel += pq.poll();
            ans++;
        }
    }

    public static void main(String[] args){
        String str = "[[14,123],[145,203],[344,26],[357,68],[390,35],[478,135],[685,108],[823,186],[934,217],[959,80]]";
        int[][] stop = Tool.toIntAA(str);
        System.out.println(MinimumNumberOfRefuelingStops.minRefuelStops(1000, 299, stop));
    }
}
