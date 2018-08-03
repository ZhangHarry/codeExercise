package wangyi;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/8/3.

 考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如：
 "car" < "carriage" < "cats" < "doggies < "koala"
 2.根据字符串的长度排序。例如：
 "car" < "cats" < "koala" < "doggies" < "carriage"
 考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
 输入描述:
 输入第一行为字符串个数n(n ≤ 100)
 接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
 输出描述:
 如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",

 如果根据长度排列而不是字典序排列输出"lengths",

 如果两种方式都符合输出"both"，否则输出"none"
 */

public class TwoSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n <=0){
            System.out.println("both");
            return;
        }
        boolean ifLen = true;
        boolean ifLexico = true;
        String preS = sc.nextLine();
        int preL = preS.length();
        int i=1;
        while (i<n){
            String curS = sc.nextLine();
            int curL = curS.length();
            if (ifLen && curL <= preL)
                ifLen = false;
            if (ifLexico && !ifLex(preS, curS))
                ifLexico = false;
            if (!ifLen && !ifLexico)
                break;
            else{
                preS = curS;
                preL = curL;
            }
            i++;
        }
        if (ifLen && ifLexico)
            System.out.println("both");
        else if (ifLen)
            System.out.println("lengths");
        else if (ifLexico)
            System.out.println("lexicographically");
        else
            System.out.println("none");
    }

    public static boolean ifLex(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        for (int i=0; i<str1.length && i<str2.length; i++){
            if (str2[i] > str1[i])
                return true;
            else if (str2[i] < str1[i])
                return false;
        }
        if (str1.length >= str2.length)
            return false;
        else
            return true;
    }
}
