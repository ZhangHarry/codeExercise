package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/24.
 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 */

public class Reverse {

    public String reverseString(String iniString) {
        // write code here
        char[] str = iniString.toCharArray();
        int start =0, end= str.length-1;
        char tmp=0;
        while(start<end){
            tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
        return new String(str);
    }
}
