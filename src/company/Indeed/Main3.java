package company.Indeed;

/**
 * Created by zhanghr on 2018/9/14.
 */

import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[][] grid = new int[H+1][W+1];
        sc.nextLine();
        for (int i=0; i<H; i++){
            char[] str = sc.nextLine().toCharArray();
            for (int j=0;j<str.length; j++){
                if (str[j] == '#') //black
                    grid[i+1][j+1] = 1;
            }
        }
        int MOD = (int)Math.pow(10,9)+7;
        int[][] dp1 = new int[H+1][W+1]; // from (1,1) to (H,W)
        dp1[0][1] = 1;
        for (int i=1; i<= H; i++){
            for (int j=1; j<=W; j++){
                if (grid[i][j] == 0){
                    long sum = dp1[i-1][j] + dp1[i][j-1];
                    dp1[i][j] = (int)(sum % MOD);
                }
            }
        }

        int[][] dp2 = new int[H+1][W+1]; // from (H,W) to (1,1)
        dp2[H][W] = 1;
        for (int j=W-1; j>0; j--){
            if (grid[H][j] == 0 && dp2[H][j+1] == 1)
                dp2[H][j] = 1;
        }
        for (int i=H-1; i>0; i--){
            if (grid[i][W] == 0 && dp2[i+1][W] == 1)
                dp2[i][W] = 1;
        }
        for (int i=H-1; i>0; i--){
            for (int j=W-1; j>0; j--){
                if (grid[i][j] == 0){
                    long sum = dp2[i+1][j] + dp2[i][j+1];
                    dp2[i][j] = (int)(sum % MOD);
                }
            }
        }

        int Q = sc.nextInt();
        for (int i=0; i<Q;i++){
            int I = sc.nextInt();
            int J = sc.nextInt();
            long n1 = dp1[I][J];
            long n2 = dp2[I][J];
            long res = (n1*n2*1L) % MOD;
            System.out.println(res);
        }
    }
}
