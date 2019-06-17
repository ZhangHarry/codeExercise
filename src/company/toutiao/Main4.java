package company.toutiao;

/**
 * Created by zhanghr on 2018/8/12.
 */
import java.util.*;
public class Main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i=0; i<n; i++)
            a[i] = sc.nextInt();
        for (int i=0; i<n; i++)
            b[i] = sc.nextInt();
        int res = 0;
        for (int i = 0; i<n; i++){
            int amax = Integer.MIN_VALUE;
            int bmin = Integer.MAX_VALUE;
            for (int j=i; j<n; j++){
                amax = Math.max(amax, a[j]);
                bmin = Math.min(bmin, b[j]);
                if (bmin > amax)
                    res++;
            }
        }
        System.out.println(res);
    }
}
