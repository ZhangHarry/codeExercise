package Algorithm;

/**
 * Created by zhanghr on 2018/4/26.
 */
import java.util.*;
public class NestedInteger {
    int val;
    List<NestedInteger> list = new LinkedList<>();

    // 字符串不为空，不包含空格，仅包含数字0-9,[,-,],和逗号
    public NestedInteger parse(String s){
        if (s.length() == 0)
            return null;
        Stack<Character> list = new Stack<>();
        Stack<NestedInteger> nest = new Stack<>();
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (c == '['){
                NestedInteger element = new NestedInteger();
                nest.add(element);
            }else if (c == ','){
                String temp = "";
                Character ch = null;
                while (!list.isEmpty() && isInteger((ch =list.peek()))){
                    temp = ch + temp;
                    list.pop();
                }
                NestedInteger element = nest.pop();
                element.val = Integer.parseInt(temp);

            }
        }
        return nest.get(0);
    }

    public boolean isInteger(char ch){
        return ch == '-' || (
                ch >= '0' && ch <= '9');
    }
}
