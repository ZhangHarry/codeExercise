package company.wangyi.hulianwang;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/8/11.
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nkLine = sc.nextLine().split(" ");
        int n = Integer.parseInt(nkLine[0]);
        int k = Integer.parseInt(nkLine[1]);
        int[] points = new int[n];
        String[] pointLine = sc.nextLine().split(" ");
        for(int i = 0; i < n; i++){
            points[i] = Integer.parseInt(pointLine[i]);
        }
        int originPoints = 0;
        boolean[] wakes = new boolean[n];
        String[] wakeLine = sc.nextLine().split(" ");
        for(int i = 0; i < n; i++){
            int wake = Integer.parseInt(wakeLine[i]);
            if (wake == 1){
                originPoints += points[i];
                wakes[i] = true;
            }
        }
        int result = originPoints + getMax(k,points,wakes);
        System.out.println(result);
    }

    /**
     *
     * @param k 清醒时间
     * @param points
     * @param wakes
     * @return
     */
    private static int getMax(int k, int[] points, boolean[] wakes) {
        int max = 0;
        for(int i=0;i<points.length;i++){
            int tmp = 0;
            int wakeTime = i+k;
            for(int j=i;j<wakeTime && j<points.length;j++){
                if(wakes[j]==false){
                    tmp+=points[j];
                }
            }
            max = max > tmp ? max : tmp;
        }
        return max;
    }
}
