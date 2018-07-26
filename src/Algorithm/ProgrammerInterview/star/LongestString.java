package Algorithm.ProgrammerInterview.star;

/**
 * Created by zhanghr on 2018/7/27.
 有一组单词，请编写一个程序，在数组中找出由数组中字符串组成的最长的串A，即A是由其它单词组成的(可重复)最长的单词。

 给定一个string数组str，同时给定数组的大小n。请返回最长单词的长度，保证题意所述的最长单词存在
 */

import java.util.*;

public class LongestString {
    HashMap<String, Boolean> map = new HashMap<>();
    HashSet<String> record = new HashSet<>();
    int max = 0;
    public int getLongest(String[] str, int n) {
        // write code here
        for (String s :str){
            record.add(s);
        }
        for (String s :str){
            isValid(s);
        }
        return max;
    }

    public boolean isValid(String s){
        if (map.containsKey(s))
            return map.get(s);
        for (int i=1; i<s.length(); i++){
            if (record.contains(s.substring(0, i)) && (record.contains(s.substring(i)) || isValid(s.substring(i)))){
                map.put(s, true);
                max = Math.max(s.length(), max);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}