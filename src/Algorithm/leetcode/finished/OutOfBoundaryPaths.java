package Algorithm.leetcode.finished;

/**
 There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right).
 However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.
 * Created by zhanghr on 2018/6/28.
 */

public class OutOfBoundaryPaths {

    // beat 46.74%
    // 注意：溢出，以及可以往回走
    public int findPaths(int m, int n, int N, int i, int j) {
        if (m <= 0 || N <= 0)
            return 0;
        long[][] table = newTable(m, n);
        long[][] nTable = newTable(m, n);
        for (int step = 1; step <= N-1; step++){
            for (int row = 1; row<=m; row++){
                for (int col = 1; col <= n; col++){
                    nTable[row][col] = table[row-1][col]% 1000000007 + table[row][col-1]% 1000000007 + table[row+1][col]% 1000000007 + table[row][col+1]% 1000000007;
                }
            }
            long[][] tmp = table;
            table = nTable;
            nTable = tmp;
        }

        for (int row = 1; row<=i+1; row++){
            for (int col = 1; col <= j+1; col++){
                nTable[row][col] = table[row-1][col]% 1000000007 + table[row][col-1]% 1000000007 + table[row+1][col]% 1000000007 + table[row][col+1]% 1000000007;
            }
        }
        return (int)(nTable[i+1][j+1] % 1000000007);
    }

    private long[][] newTable(int m, int n) {
        long[][] table = new long[m+2][n+2];
        for (int i=1; i<=n;i++) {
            table[0][i] = 1;
            table[m+1][i] = 1;
        }
        for (int i=1; i<=m;i++) {
            table[i][0] = 1;
            table[i][n+1] = 1;
        }
        return table;
    }

    public static void main(String[] args){
        OutOfBoundaryPaths test = new OutOfBoundaryPaths();
        System.out.println(test.findPaths(36, 5,50, 15, 3));
    }

}
