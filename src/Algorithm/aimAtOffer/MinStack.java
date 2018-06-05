package Algorithm.aimAtOffer;
import java.util.*;
/**
 * Created by zhanghr on 2018/5/26.
 */

public class MinStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack= new LinkedList<>();

    public void push(int node) {
        stack.add(0, node);
        if (minStack.isEmpty() || node <= minStack.peek()){
            minStack.add(0, node);
        }
    }

    public void pop() {
        Integer r = stack.remove(0);
        if (r == min())
            minStack.remove(0);
    }

    public int top() {
        return stack.get(0);
    }

    public int min() {
        return minStack.get(0);
    }

    public static void main(String[] args){
        MinStack test = new MinStack();
        test.push(3);
        System.out.println(test.min());
        test.push(4);
        System.out.println(test.min());
        test.push(2);
        System.out.println(test.min());
        test.push(3);
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.push(0);
        System.out.println(test.min());
    }
}
