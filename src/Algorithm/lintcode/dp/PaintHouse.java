package Algorithm.lintcode.dp;

/**
 *
 There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Example
 Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

 house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10

 * Created by zhanghr on 2018/6/2.
 */

public class PaintHouse {
    /**
     * beat 84.4%
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int houses = costs.length;
        if (houses == 0)
            return 0;
        for (int i=1; i<houses; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        int result = Math.min(Math.min(costs[houses-1][0], costs[houses-1][1]), costs[houses-1][2]);
        return result;
    }

    /**
     * 注意到该算法与上一算法时间复杂度一样，但是多了空间的开销和一些时间开销（？），结果超时，遇到这种情况还是尽量优化下代码
     * @param costs
     * @return
     */
    public int minCost1(int[][] costs) {
        // write your code here
        int houses = costs.length;
        if (houses == 0)
            return 0;
        int[][] dp = new int[houses][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i=1; i<houses; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0])+costs[i][2];
        }
        int result = Math.min(Math.min(dp[houses-1][0], dp[houses-1][1]), dp[houses-1][2]);
        return result;
    }
}
