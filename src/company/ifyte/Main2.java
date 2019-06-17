package company.ifyte;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/7.
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<num; i++)
            list.add(in.nextInt());
        int res = 0;
        while (true){
            boolean ifBreak = true;
            for (int i=list.size()-1; i>0; i--){
                if (list.get(i) < list.get(i-1)){
                    list.remove(i);
                    ifBreak = false;
                }
            }
            if (ifBreak)
                break;
            res++;
        }
        System.out.println(res);
    }
}
