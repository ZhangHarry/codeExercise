package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/26.
 编写一个方法，确定某字符串的所有排列组合。

 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
 保证字符串长度小于等于11且字符串中字符均为大写英文字符，排列中的字符串按字典序从大到小排序。(不合并重复字符串)
 */

import java.util.*;

public class Permutation {
    public ArrayList<String> getPermutation(String A) {
        // write code here
        char[] str = A.toCharArray();
        Arrays.sort(str);
        for (int i=0, j=str.length-1; i<j; i++, j--){
            swap(str, i, j);
        }
        ArrayList<String> list = new ArrayList<>();
        recur(list, str, 0);
        Collections.sort(list, new MyComparator());
        return list;
    }

    public void recur(ArrayList<String> list, char[] str, int index){
        if (index == str.length){
            list.add(new String(str));
            return;
        }
        Character c=null;
        for (int i=index; i<str.length; i++){
            // 该判断用于保证没有重复项，不过本题要返回的是所有排列组合
            //if (c==null || c != str[i]){
            swap(str, index, i);
            recur(list, str, index+1);
            swap(str, index, i);
            c = str[i];
            //}
        }
    }

    public void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}

class MyComparator implements Comparator<String>{
    public int compare(String s1, String s2){
        for (int i=0; i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i))
                return s2.charAt(i)-s1.charAt(i);
        }
        return 0;
    }
}