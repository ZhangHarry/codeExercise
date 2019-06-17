package company.tencent;


/**
 * Created by zhanghr on 2018/9/16.
 */

import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<t; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            if (C == 0){
                System.out.println("YES");
            }else{
                int aMod = A%B;
                if (aMod == 0)
                    System.out.println("NO");
                else{
                    boolean[] mod = new boolean[B];
                    int cur = aMod;
                    while (!mod[cur]){
                        mod[cur] = true;
                        cur = (cur+aMod)%B;
                    }
                    if (mod[C])
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
            }
        }
    }
}
