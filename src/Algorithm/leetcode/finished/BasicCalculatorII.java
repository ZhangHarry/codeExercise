package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/13.
 *
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 Example 1:

 Input: "3+2*2"
 Output: 7
 Example 2:

 Input: " 3/2 "
 Output: 1
 Example 3:

 Input: " 3+5 / 2 "
 Output: 5
 Note:

 You may assume that the given expression is always valid.
 Do not use the eval built-in library function.
 *
 */
import java.util.*;
public class BasicCalculatorII {
    // 思路：注意在新操作入栈前，需要和前一个操作比较优先级；最后操作栈可能存在一个或两个操作符，两个的情况是第二个操作符比前一个高级
    // beat 20%
    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] str = s.toCharArray();
        Stack<Integer> operators = new Stack<>();
        Stack<Character> operations = new Stack<>();
        int val = 0;
        boolean hasRest = false;
        for (int i=0; i<str.length; i++){
            char ch = str[i];
            if (ch -'0'<0 || ch-'9'>0){
                operators.push(val);
                val = 0;
                hasRest = false;
                while (!operations.empty() && ahead(operations.peek(), ch)){
                    char op = operations.pop();
                    int op2 = operators.pop();
                    int op1 = operators.pop();
                    operators.push(getVal(op, op1, op2));
                }
                operations.push(ch);
            }else{
                val = val*10+ch-'0';
                hasRest = true;
            }
        }
        if (hasRest) {
            operators.push(val);
        }
        while (!operations.empty()){
            int op2 = operators.pop();
            int op1 = operators.pop();
            int v = getVal(operations.pop(), op1, op2);
            operators.push(v);
        }
        return operators.pop();
    }

    public int getVal(char operation, int op1, int op2){
        switch(operation){
            case '+':
                return op1+op2;
            case '-':
                return op1-op2;
            case '*':
                return op1*op2;
            default:
                return op1/op2;
        }
    }

    public boolean ahead(char op1, char op2){
        if ((op2=='*'||op2=='/') && (op1=='+'||op1=='-'))
            return false;
        return true;
    }

    public static void main(String[] args){
        BasicCalculatorII test = new BasicCalculatorII();
        System.out.println(test.calculate("1-1+1"));
        System.out.println(test.calculate("100000/2/3/4/10"));
        System.out.println(test.calculate("3+2*2"));
        System.out.println(test.calculate("2-2*3+1"));
    }
}
