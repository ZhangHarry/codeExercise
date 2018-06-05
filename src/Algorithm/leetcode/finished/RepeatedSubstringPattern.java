package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/5/14.
 */
import java.util.*;
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1)
            return false;
        int[] counts =new int[26];
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length; i++){
            counts[chars[i]-'a']++;
        }
        int i =0;
        while (i < 26 && counts[i] == 0)
            i++;
        int nums = counts[i];
        while (i < 26){
            if (counts[i] > 0 && counts[i] != nums)
                return false;
            i++;
        }
        List<Integer> list = getFactor(nums);
        for (Integer length : list){
            length = s.length()/length;
            int s1 = 0, e1 = length-1,s2 =length, e2 = length<<1-1;
            while (e2 < chars.length){
                if (!equal(s1,e1,s2,e2, chars))
                    break;
                else{
                    s1 = s2;
                    e1 = e2;
                    s2 = s1+length;
                    e2 = e1+length;
                }
            }
            if (e2 >= chars.length)
                return true;
        }
        return false;
    }

    public List<Integer> getFactor(int i){
        List<Integer> list = new LinkedList<>();
        for (int factor = 1; factor <=i; factor++){
            if (i % factor == 0)
                list.add(factor);
        }
        return list;
    }

    public boolean equal(int s1,int e1, int s2,int e2, char[] chars){
        while (s1 <= e1){
            if (chars[s1] != chars[s2])
                return false;
            s1++;
            s2++;
        }
        return true;
    }

    public static void main(String[] args){
        RepeatedSubstringPattern test = new RepeatedSubstringPattern();
        String s= "abaababaab";
        System.out.println(s + " "+ test.repeatedSubstringPattern(s));
    }
}
