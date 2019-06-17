package company.Indeed;



/**
 * Created by zhanghr on 2018/9/14.
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i=0; i<N; i++)
            nums[i] = sc.nextInt();
        int[] dp1 = new int[N]; // 第n个元素不变
        int[] dp2 = new int[N]; // 第n个元素取反
        dp1[0] = 0;
        dp2[0] = 1;
        for (int n=1; n<N; n++){
            int t1 = dp1[n-1] == Integer.MAX_VALUE ? Integer.MAX_VALUE :
                    (nums[n] >=nums[n-1] ? dp1[n-1] : Integer.MAX_VALUE);
            int t2 = dp2[n-1] == Integer.MAX_VALUE ? Integer.MAX_VALUE :
                    (nums[n] >= -nums[n-1] ? dp2[n-1] : Integer.MAX_VALUE);
            dp1[n] = Math.min(t1, t2);

            t1 = dp1[n-1] == Integer.MAX_VALUE ? Integer.MAX_VALUE :
                    (-nums[n] >= nums[n-1] ? dp1[n-1]+1 : Integer.MAX_VALUE);
            t2 = dp2[n-1] == Integer.MAX_VALUE ? Integer.MAX_VALUE :
                    (-nums[n] >= -nums[n-1] ? dp2[n-1]+1 : Integer.MAX_VALUE);
            dp2[n] = Math.min(t1, t2);
            if (dp1[n] == Integer.MAX_VALUE && dp2[n] == Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }
        }
        int res = Math.min(dp1[N-1], dp2[N-1]);
        if (res == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(res);
    }
}
