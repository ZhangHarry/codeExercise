package company.wangyihulianwnag;



/**
 * Created by zhanghr on 2018/9/8.
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] cases = new int[t][2];
        for (int i=0; i<t; i++){
            cases[i][0] = sc.nextInt();
            cases[i][1] = sc.nextInt();
        }

        for (int i=0; i<t; i++){
            int n = cases[i][0];
            int k = cases[i][1]; // #
            int res = n-k; // -
            int min = 0;
            int max = 0;
            if (k <= res)
                max = Math.max(0, k-1);
            else
                max = res;
            System.out.println(min + " " + max);
        }
    }
}
