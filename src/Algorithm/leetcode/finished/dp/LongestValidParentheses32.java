package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/8/27.
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 Example 1:

 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"
 Example 2:

 Input: ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()"

 */
import java.util.*;
public class LongestValidParentheses32 {
    // beat 9%
    public int longestValidParentheses(String s) {
        char[] str = s.toCharArray();
        int max = 0;
        Stack<Integer> stack = new Stack<>(); // 按顺序存储（和合法长度，stack中必定是0、i的形式，不会存在两个连续元素大于0
        for (int i=0; i<str.length; i++){
            if (str[i] == '('){
                stack.push(0);
            }else{
                int before = 0;
                // 处理stack中401的情况，将1取出
                if(!stack.isEmpty() && stack.peek()>0){
                    before += stack.pop();
                    max = Math.max(max, before);
                }
                // 处理stack中40的情况，合并（）两个字符
                // 如果stack最后不是0，则表示stack是空的，）不合法，所以不需要进行任何push操作
                if (!stack.isEmpty() ){
                    stack.pop();
                    before += 2;
                    if (!stack.isEmpty() && stack.peek()>0){
                        before += stack.pop();
                    }
                    stack.push(before);
                    max = Math.max(max, before);
                }
            }
        }
        return max;
    }

    // beat 96.32%
    public int longestValidParentheses2(String s) {
        int max = 0;
        char[] str = s.toCharArray();
        int[] dp = new int[str.length+1]; // 以i位结尾的最大合法长度
        for (int i=1; i<str.length; i++){
            if (str[i] == ')'){
                if (str[i-1]=='(') // 与前一个字符结合，加上i-2位的最大合法长度
                    dp[i+1] = dp[i-1]+2;
                else if (i-dp[i]-1>=0 && str[i-dp[i]-1]=='('){ // 取出i-1位的最长合法字符串，检查它的前一位是否（，若是则可以搭配
                    dp[i+1] = dp[i]+2+dp[i-dp[i]-1];
                }
                max = Math.max(max,dp[i+1]);
            }
        }
        return max;
    }
}
