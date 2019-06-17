package company.xunlei;

/**
 * Created by zhanghr on 2018/9/12.
 */

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int k = 1; // 最少多少个B使得7个积木和为负
        while (A*(7-k) + B * k > 0){
            k++;
        }
        int res = 0;
        res += 2*k*B;
        res += (14-2*k)*A;
        if (7-k <= 3){
            res += (7-k)*A;
            res += (3-7+k)*B;
        }else{
            res += 3*A;
        }
        System.out.println(res);
    }
}
