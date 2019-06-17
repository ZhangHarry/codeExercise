package company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/26.
 */

public class TmpMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for (int i=0;i<n; i++) {
            array[i] = sc.nextInt();
            rightMap.put(array[i], rightMap.getOrDefault(array[i], 0)+1);
        }
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n-1; i++){
            int cur = array[i];
            int tmp = rightMap.get(cur);
            if (tmp == 1) {
                rightMap.remove(cur);
            } else {
                rightMap.put(cur, tmp - 1);
            }
            if (!leftMap.containsKey(cur)){
                res-= leftMap.size();
                if (tmp == 1) {
                    res += rightMap.size();
                } else {
                    res +=  rightMap.size()-1;
                }
            }
            sb.append(res+" ");
        }
        String str = sb.toString();
        System.out.println(str.substring(0, str.length()-1));
    }
}
