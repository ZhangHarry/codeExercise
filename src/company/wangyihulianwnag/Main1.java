package company.wangyihulianwnag;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/8.
 */

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        if(str.length<=1) {
            System.out.println(str.length);
            return;
        }
        int res = 1;
        int cur = 1;
        int curStart = 0;
        for(int i = 1; i<str.length;i++){
            if (str[i] != str[i-1]) {
                cur++;
                res = Math.max(cur,res);
            } else if (str[curStart] != str[i]){
                cur++;
                res = Math.max(cur,res);
                str[curStart] = str[i-1];
            } else {
                cur = 1;
                curStart = i;
            }
        }
//        if (str[0] != str[str.length-1] && res < str.length) {
//            res++;
//        }
        System.out.println(res);
    }
}
