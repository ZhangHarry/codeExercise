package Algorithm.lintcode;

/**
 Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.

 Example
 Given a grid:

 0 E 0 0
 E 0 W E
 0 E 0 0
 return 3. (Placing a bomb at (1,1) kills 3 enemies)

 * Created by zhanghr on 2018/6/6.
 */

public class BombEnemy {
    /**
     * beat 91.2%
     * 思路：使用区间和，分别计算行和列的敌人区间和，得到两个矩阵，然后遍历两个区间和的矩阵，和即为杀死的敌人的数目。注意对于不同的区间和，顺序不同：一个按列，一个按行
     * 注意：写时越界情况；lintcode上面不允许在有敌人的格子上投放炸弹，所以在求最大杀伤时，需要跳过这种情况
     *
     * 有种更简单的思路：分别计算一个格子四个方向杀死的数目，然后四个方向相加。计算每个方向的杀敌数目时，实际上是dp[i] = char[i]=='W' ? 0 : dp[i-1]。
     * 不过区间和的做法，遍历矩阵的次数更少
     *
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if(grid.length == 0 || grid[0].length==0)
            return 0;
        int rows = grid.length, columns = grid[0].length;
        int[][] rowInteval = new int[rows][columns];
        for (int i=0; i< rows; i++){
            int start = 0;
            int enemies = 0;
            for (int j=0; j<columns; j++){
                if (grid[i][j] == 'E')
                    enemies++;
                else if(grid[i][j] == 'W'){
                    rowInteval[i][start] = enemies;
                    rowInteval[i][j] = -enemies;
                    start = j+1;
                    enemies = 0;
                }
            }
            if (start < columns)
                rowInteval[i][start] = enemies;
        }

        int[][] colInteval = new int[rows][columns];
        for (int j=0; j< columns; j++){
            int start = 0;
            int enemies = 0;
            for (int i=0; i<rows; i++){
                if (grid[i][j] == 'E')
                    enemies++;
                else if(grid[i][j] == 'W'){
                    colInteval[start][j] = enemies;
                    colInteval[i][j] = -enemies;
                    start = i+1;
                    enemies = 0;
                }
            }
            if (start < rows)
                colInteval[start][j] = enemies;
        }
        int[][] killed = new int[rows][columns];
        for (int i=0; i<rows; i++){
            int interval = 0;
            for (int j=0; j<columns; j++){
                interval += rowInteval[i][j];
                killed[i][j] = interval;
            }
        }
        int max = 0;
        for (int j=0; j<columns; j++){
            int interval = 0;
            for (int i=0; i<rows; i++){
                interval += colInteval[i][j];
                if (grid[i][j]!='E') { // 不能投放炸弹，所以这个格子的杀伤情况不考虑了
                    killed[i][j] += interval;
                    max = Math.max(max, killed[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        BombEnemy test = new BombEnemy();
        char[][] grid = new char[][]{
                "0E00".toCharArray(),
                "E0WE".toCharArray(),
                "0E00".toCharArray()
        };
        System.out.println(test.maxKilledEnemies(grid));
        grid = new char[][]{
                "E".toCharArray()
        };
        System.out.println(test.maxKilledEnemies(grid));
    }
}
