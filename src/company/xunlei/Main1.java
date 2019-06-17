package company.xunlei;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/12.
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for (int i=2; i<n; i++){
            int a = i;
            for (int b=a+1; b<n; b++){
                int sum = a*a + b*b;
                int c = (int)Math.sqrt(sum);
                if (sum == c*c && c<=n) {
                    if (ifValid(a, b) && ifValid(b,c) && ifValid(a,c))

                        res++;
                }
                if (c >= n)
                    break;
            }
        }
        System.out.println(res);
    }

    public static boolean ifValid(int a, int b){
        if (a == b)
            return false;
        if (maxCommonDivisor(a, b) == 1)
            return true;
        return false;
    }

    public static int maxCommonDivisor(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        } else {
            return maxCommonDivisor(b, a % b);
        }
    }
}
