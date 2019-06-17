package company.RedBook;


/**
 * Created by zhanghr on 2018/9/15.
 */

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N<=0){
            System.out.println(0);
            return;
        }
        int[] dp = new int[N+1];
        for (int i=1; i<=N; i++){
            if (i%5==0)
                dp[i] = dp[i/5]+1;
        }
        int res = 0;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=i; j++)
                res += dp[j];
        }
        System.out.println(res);
    }
}
