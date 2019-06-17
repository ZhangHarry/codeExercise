package company.wangyi.hulianwang;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by zhanghr on 2018/8/11.
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] apples = new int[N];
        int[] sum = new int[N];
        String[] appleD = sc.nextLine().split(" ");
        for (int i=0; i<N; i++){
            apples[i] = Integer.parseInt(appleD[i]);
            sum[i] = apples[i] + (i >0 ? sum[i-1] : 0);
        }
        int m = Integer.parseInt(sc.nextLine());
        String[] queryD = sc.nextLine().split(" ");
        int[] queries = new int[m];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            queries[i] = Integer.parseInt(queryD[i]);
            sb.append(bindex(sum, queries[i]) + "\n");
        }
        System.out.println(sb.toString().substring(0, sb.toString().length()-1));
    }

    public static int index(int[] sum, int number){
        for (int i=0; i<sum.length; i++){
            if (number <= sum[i])
                return i+1;
        }
        return sum.length;
    }

    public static int bindex(int[] sum, int number){
        int start = 0, end = sum.length-1;
        while(start < end){
            if (number <= sum[start])
                return start+1;
            if (start == end-1)
                return end+1;
            int mid = start + (end-start)/2;
            if (number > sum[mid])
                start = mid;
            else if (number < sum[mid])
                end = mid;
            else
                return mid+1;
        }
        return sum.length;
    }
}
