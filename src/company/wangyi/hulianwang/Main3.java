package company.wangyi.hulianwang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Created by zhanghr on 2018/8/11.
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int max = getCmn(m+n, m>n ? n : m);
        if (k > max)
            System.out.println(-1);
        else{
            ArrayList<String> list = new Permutation().getPermutation(n, m, k);
            System.out.println(list.get(k-1));
        }
    }

    public static int getCmn(int m, int n) {
        int dividor = m;
        int divided = 1;
        for (int i=2; i<=n; i++){
            divided *= i;
            dividor *= (m-i+1);
        }
        return dividor/divided;
    }
}

class Permutation {
    public ArrayList<String> getPermutation(int n, int m, int k) {
        char[] str = new char[n+m];
        for (int i=0; i<n; i++)
            str[i] = 'a';
        for (int i=n; i<str.length; i++)
            str[i] = 'z';
        ArrayList<String> list = new ArrayList<>();
        recur(list, str, 0);
        Collections.sort(list);
        return list;
    }

    public void recur(ArrayList<String> list, char[] str, int index){
        if (index == str.length){
            list.add(new String(str));
            return;
        }
        Character c=null;
        for (int i=index; i<str.length; i++){
            if (c==null || c != str[i]){
                swap(str, index, i);
                recur(list, str, index+1);
                swap(str, index, i);
                c = str[i];
            }
        }
    }

    public void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
