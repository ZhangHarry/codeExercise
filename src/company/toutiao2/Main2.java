package company.toutiao2;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/8/25.
 */

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int mod = 1000000007;
        long[] dp = new long[n>3 ? n+1 : 4];
        dp[0] = 0;
        dp[1] = 10;
        dp[2] = 10*10;
        dp[3] = dp[1] + 10*10*10 + 10*2*dp[1];
        for (int i=4; i<=n;i++){
            int sum = i-1;
            long r=0;
            for (int j=1; j<sum; j++){
                long tmp = (dp[j]*dp[sum-j]*2)%mod;
                r = (r+tmp)%mod;
            }
            r = (r+dp[i-2])%mod;
            r = (r+((int)Math.pow(10, i))%mod)%mod;
            dp[i] = r;
        }
        System.out.println(dp[n]);
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final int MOD = 1000_000_007;
        long[] dp = new long[n+1];
        for(int i=1;i<=n; i++){
            dp[i] = ((long)Math.pow(10, i))%MOD;
            if(i>=3){
                dp[i]+=dp[i-2];
                dp[i]%=MOD;
                int rest = i-1;
                for(int j=1; j<rest;j++){
                    dp[i]+=(dp[j]*dp[rest-j]*2);
                    dp[i]%=MOD;
                }
            }
        }
    }
}
