package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/22.
 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。
 请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。

 给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
 同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
import java.util.*;
public class Flood {
    int n,m;
    // 回溯法，注意可以剪枝，不剪枝会导致超时
    public int floodFill(int[][] map, int n, int m) {
        // write code here
        this.n = n;
        this.m = m;
        int[][] steps = new int[n][m];
        for (int i=0; i<n;i++){
            Arrays.fill(steps[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[n][m];
        backTrack(steps, map, visited, 0, 0, 0);
        return steps[n-1][m-1];
    }

    int[][] moves = new int[][]{
            new int[]{1,0}, new int[]{-1,0}, new int[]{0, 1}, new int[]{0, -1}
    };

    public void backTrack(int[][] steps, int[][] map, boolean[][]visited, int i, int j, int step){
        if (i<0 || i>=n || j<0 ||j>=m)
            return;
        if (visited[i][j] || map[i][j] == 1)
            return;
        int pre = steps[i][j];
        if (pre < step) // 剪枝
            return;
        steps[i][j] = step;
        visited[i][j] = true;
        for (int[] move : moves){
            backTrack(steps, map, visited, i+move[0], j+move[1], step+1);
        }
        visited[i][j] = false;
    }

    public static void main(String[] args){
        int[][] map = new int[][]{
                new int[]{0,0,1},
                new int[]{0,1,1},
                new int[]{0,0,0},
                new int[]{0,0,0}
        };
        Flood flood = new Flood();
        System.out.println(flood.floodFill(map, map.length, map[0].length));
    }

}
