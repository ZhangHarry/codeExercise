package Algorithm.leetcode.finished;

import java.util.Stack;

/**
 * Created by zhanghr on 2018/7/16.
 */

public class DecodeString {
    public String decodeString(String s) {
        char[] str = s.toCharArray();
        int val = 0;
        StringBuilder sb = new StringBuilder();
        boolean needPush = false;
        Stack<String> stack = new Stack<>();
        for (char ch : str){
            if (ch=='['){
                stack.push(""+val);
                val=0;
                stack.push("[");
            }else if (ch==']'){
                String tmp = needPush ? sb.toString() : stack.pop();
                if (needPush)
                    needPush = false;
                stack.pop();//移除[
                int times = Integer.parseInt(stack.pop());
                for (int i=1; i<times; i++){
                    sb.append(tmp);
                }
                tmp = sb.toString();
                sb = new StringBuilder();
                if(stack.empty()) {
                    stack.push(tmp);
                }else if(!stack.peek().equals("[")){
                    stack.push(stack.pop()+tmp);
                }
            }else if (ch-'0'>=0 && ch-'9'<=0){ // 整数
                if (sb.length()>0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                val = val*10+ch-'0';
            }else { // 字母
                sb.append(ch);
                needPush = true;
            }
        }
        if (stack.empty())
            return s;
        return stack.pop();
    }

    public static void main(String[] args){
        DecodeString test = new DecodeString();
        System.out.println(test.decodeString("3[a2[bc]]"));
        System.out.println(test.decodeString("3[a]2[bc]"));
        System.out.println(test.decodeString("2[b4[F]c]"));
    }
}
