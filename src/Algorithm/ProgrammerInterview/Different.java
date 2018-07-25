package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/24.
 *
 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。

 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。

 */

import java.util.*;

public class Different {
    char tmp;
    public boolean checkDifferent(String iniString) {
        // write code here
        char[] str = iniString.toCharArray();
        if(str.length<256){
            for (int j=0; j<str.length; j++){
                for (int k=j+1; k<str.length; k++){
                    if (str[j] == str[k])
                        return false;
                }
            }
            return true;
        }
        int i=0;
        while (i<str.length){
            int index = str[i];
            if (index < str.length){
                if (str[index] == str[i])
                    return false;
                else
                    swap(str, i,index);
            }else
                i++;
        }
        return true;
    }

    public void swap(char[] str, int start, int end){
        tmp = str[start];
        str[start] = str[end];
        str[end] = tmp;
    }
}