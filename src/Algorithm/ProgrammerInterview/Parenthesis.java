package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/25.
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。

 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。

 测试样例：
 "(()())",6
 返回：true
 测试样例：
 "()a()()",7
 返回：false
 测试样例：
 "()(()()",7
 返回：false
 */

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        char[] a = A.toCharArray();
        int left=0;
        for (char c : a){
            if (c=='(')
                left++;
            else if (c==')'){
                left--;
                if (left<0)
                    return false;
            }else{
                if (left == 0)
                    return false;
            }
        }
        if (left != 0 )
            return false;
        return true;
    }
}
