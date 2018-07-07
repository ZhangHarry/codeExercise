package Algorithm.leetcode.finished;

import java.util.Arrays;

/**
 * Created by zhanghr on 2018/6/28.
 */

public class KnightProbabilityInChessboard {
    double[][] matrix;
    double out=0.0;
    int dimention;
    int[][] moves = new int[][]{
            new int[]{-1, 2},  new int[]{-1, -2}, new int[]{1, 2},  new int[]{1, -2},
            new int[]{2,1}, new int[]{2,-1},  new int[]{-2,1}, new int[]{-2,-1}
    } ;

    public double knightProbability(int N, int K, int r, int c) {
        matrix = new double[N][N];
        dimention = N;
        if (isOutOff(r,c))
            return 0;
        if (K <= 0)
            return 1;
        knightProbability(K, r, c, 1.0);
        return 1-out;
    }

    public void knightProbability(int K, int r, int c, double p) {
        if (K == 0)
            return;
        double one = p/8;
        for (int[] move : moves){
            int nr = r+move[0], nc = c+move[1];
            if (isOutOff(nr, nc)) {
                System.out.println(r + "," + c + "," + Arrays.toString(move) + " , " + nr + "," + nc + " : " + one);
                out += one;
            }
            else{
                matrix[nr][nc] += p;
                knightProbability(K-1, nr, nc, one);
            }
        }

    }

    private boolean isOutOff(int r, int c){
        if (r < 0 || c < 0 || r >= dimention || c >= dimention)
            return true;
        return false;
    }

    public static void main(String[] args){
        KnightProbabilityInChessboard test = new KnightProbabilityInChessboard();
        System.out.println(test.knightProbability(3, 2, 0, 0));
    }
}
