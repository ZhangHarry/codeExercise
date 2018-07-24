package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/22.
 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 注意这次的网格中有些障碍点是不能走的。

 给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。
 另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50

 笔记
 收藏
 纠错

 */

public class RobotII {

    // 注意dp[0]
    public int countWays(int[][] map, int x, int y) {
        // write code here
        int[]dp = new int[y];
        for (int i=0; i<x; i++){
            if (map[i][0] == 0)
                dp[0] = 0;
            else if (i==0)
                dp[0]=1;
            for (int j=1;j<y;j++){
                if (map[i][j] == 1)
                    dp[j] = (dp[j]+dp[j-1])%1000000007;
                else
                    dp[j] = 0;
            }
        }
        return dp[y-1];
    }
}
