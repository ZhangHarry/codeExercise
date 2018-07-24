package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/23.
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。

 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，
 返回一个string，为所求的压缩后或未变化的串。
 */

public class Zipper {
    public String zipString(String iniString) {
        // write code here
        char[] str = iniString.toCharArray();
        if (str.length<=2)
            return iniString;
        StringBuilder sb = new StringBuilder();
        char cur = str[0];
        int number = 1;
        for(int i=1; i<str.length;i++){
            if (str[i] == cur){
                number++;
            }else{
                sb.append(cur);
                sb.append(number);
                cur = str[i];
                number = 1;
            }
        }
        sb.append(cur);
        sb.append(number);
        String res = sb.toString();
        if (res.length() < str.length)
            return res;
        else
            return iniString;
    }
}
