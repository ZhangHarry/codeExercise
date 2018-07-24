package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/24.
 题目描述
 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。

 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。
 */
import java.util.*;
public class TwoStacks {

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        if (numbers.length==0)
            return res;
        Stack<Integer> stack = new Stack<>();
        res.add(numbers[0]);
        for (int i=1; i<numbers.length; i++){
            int num = numbers[i];
            if (num<res.get(res.size()-1) && (stack.isEmpty() || num>=stack.peek()))
                res.add(num);
            else if(num > res.get(res.size()-1)){
                while (!res.isEmpty() && num > res.get(res.size()-1)){
                    stack.push(res.get(res.size()-1));
                    res.remove(res.size()-1);
                }
                res.add(num);
            }else if(num<stack.peek()){
                while (!stack.isEmpty() && num<=stack.peek()){
                    res.add(stack.pop());
                }
                res.add(num);
            }
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;
    }
}
