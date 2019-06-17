package company.tencent;


/**
 * Created by zhanghr on 2018/9/16.
 */

import java.util.Arrays;
import java.util.Scanner;
public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        if (x <= 0 || y<=0){
            System.out.println(-1);
            return;
        }
        long n = getRounds((x+y)*2);
        if (n==-1){
            System.out.println(-1);
        }else{
            long p =n;
            long q = n-1;
            for (long i=1;q>=0; i++){
                if (x <=p){
                    System.out.println(i);
                    break;
                }else{
                    p = p+q;
                    q--;
                }
            }
            System.out.println(-1);
        }
    }

    public void test2(){
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        if (x <= 0 || y<=0){
            System.out.println(-1);
            return;
        }
        long n = getRounds((x+y)*2);
        if (n==-1){
            System.out.println(-1);
        }else{
            long[] dp = new long[(int)x+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (long i=1;i<=n; i++){
                for (long j=x; j>=1; j--){
                    if (j-i>=0 && dp[(int)(j-i)] < Integer.MAX_VALUE)
                        dp[(int)j] = Math.min(dp[(int)(j-i)]+1, dp[(int)j]);
                }
            }
            if (dp[dp.length-1] == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(dp[dp.length-1]);
        }
    }

    public static long getRounds(long sum){
        long tmp = (long)Math.sqrt(sum);
        if (sum%tmp==0 && sum/tmp==tmp+1)
            return tmp;
        return -1;
    }
}
