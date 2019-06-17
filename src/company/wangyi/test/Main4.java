package company.wangyi.test;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/8.
 */

public class Main4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            int N = sc.nextInt();
            int[][] matrices = new int[N][2];
            for (int j=0; j<N; j++) {
                matrices[j][0] = sc.nextInt();
                matrices[j][1] = sc.nextInt();
            }
            if (check(matrices))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static boolean check(int[][] matrices){
        int[] array = new int[10001];
        for (int[] matrix : matrices){
            if (matrix[0] == matrix[1]){
                if (array[matrix[0]] ==0)
                    array[matrix[0]] = 2;
            }else{
                if (array[matrix[0]] == 0)
                    array[matrix[0]] = 1;
                else
                    array[matrix[0]]--;

                if (array[matrix[1]] == 0)
                    array[matrix[1]] = 1;
                else
                    array[matrix[1]]--;
            }
        }

        int count = 0;
        for (int i=0; i<array.length; i++){
            count+=array[i];
        }
        return count == 2;
    }
}
