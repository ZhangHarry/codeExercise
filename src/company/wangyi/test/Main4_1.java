package company.wangyi.test;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/8.
 */

public class Main4_1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            int N = sc.nextInt();
            int[] count = new int[10001];
            for (int j=0; j<N; j++) {
                count[sc.nextInt()]++;
                count[sc.nextInt()]++;
            }
            int res = 0;
            int intCount = 0;
            for (int k=0; k<count.length; k++){
                if (count[k]%2 == 1)
                    res++;
                if (count[k] > 0)
                    intCount++;
            }
            if (res == 2 || intCount == 1)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

}
