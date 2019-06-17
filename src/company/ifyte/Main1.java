package company.ifyte;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/7.
 */

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i=0; i<num; i++){
            int personNum = in.nextInt();
            int X = in.nextInt();
            int target = X * personNum;
            int[] persons = new int[personNum];
            int sum = 0;
            for (int j=0; j<personNum; j++) {
                persons[j] = in.nextInt();
                sum += persons[j];
            }
            if (sum >= target)
                System.out.println(0);
            else{
                Arrays.sort(persons);
                int res = 0;
                while (target > sum){
                    sum += 100-persons[res];
                    res++;
                }
                System.out.println(res);
            }
        }
    }
}
