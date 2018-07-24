package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/21.
 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 这里规定大小写为不同字符，且考虑字符串中的空格。

 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 */

public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        if (stringA.length() != stringB.length())
            return false;
        int[][] chars = new int[256][2];
        for (int i=0; i<stringA.length(); i++){
            chars[stringA.charAt(i)][0]++;
            chars[stringB.charAt(i)][1]++;
        }
        for (int i=0; i<256; i++){
            if(chars[i][0] != chars[i][1])
                return false;
        }
        return true;
    }
}
