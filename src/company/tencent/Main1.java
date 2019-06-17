package company.tencent;

/**
 * Created by zhanghr on 2018/9/16.
 */
import java.util.Arrays;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        for (int i=2; i<n; i++){
            int j = i<<1;
            while (j<=n){
                primes[j] = false;
                j += i;
            }
        }
        int res = n;
        for (int i=n; i>0; i--){
            if (primes[i]){
                res = i;
                break;
            }
        }
        System.out.println(2*res);

    }
}
