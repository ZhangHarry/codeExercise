package company.toutiao2;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/8/25.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                Map<Integer, List<String>> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    String s = sc.next();
                    map.computeIfAbsent(s.length(), x -> new ArrayList<>()).add(s);
                }
                System.out.println(haveDouble(map));
            }
        }

        static String haveDouble(Map<Integer, List<String>> map) {
            for (Integer i : map.keySet()) {
                List<String> list = map.get(i);
                if (list.size() <= 1)
                    continue;
                int max = list.size();
                for (int j = 0; j < max; j++) {
                    for (int k = j + 1; k < max; k++) {
                        if (isDouble(list.get(j), list.get(k)))
                            return "Yeah";
                    }
                }
            }
            return "Sad";
        }

        static boolean isDouble(String s1, String s2) {
            if (s1.equals(s2))
                return true;
            if (new StringBuilder(s1).reverse().toString().equals(s2))
                return true;
            int len = s1.length();
            int[] same = new int[26];
            for (int i = 0; i < len; i++)
                same[s1.charAt(i) - 'a']++;
            for (int i = 0; i < len; i++)
                same[s2.charAt(i) - 'a']--;
            for (int i = 0; i < same.length; i++)
                if (same[i] != 0)
                    return false;
            for (int i = 1; i < len; i++) {
                String front1 = s1.substring(0, i);
                String back1 = s1.substring(i);
                if ((back1 + front1).equals(s2))
                    return true;
                StringBuilder sbf1 = new StringBuilder(front1);
                StringBuilder sbb1 = new StringBuilder(back1);
                if ((sbf1.reverse().toString() + sbb1.reverse().toString()).equals(s2))
                    return true;
            }
            return false;
        }
}

