package Algorithm.ProgrammerInterview.star;

/**
 * Created by zhanghr on 2018/7/27.
 现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。

 给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。
 保证数组中元素均为正整数。
 */
import java.util.*;
public class NextElement {
    // 栈，倒序
    public int[] findNext(int[] A, int n) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i=A.length-1; i>=0; i--){
            while(!stack.isEmpty()){
                int next = stack.peek();
                if (next > A[i]){
                    res[i] = next;
                    stack.push(A[i]);
                    break;
                }else{
                    stack.pop();
                }
            }
            if (stack.isEmpty()){
                res[i] = -1;
                stack.push(A[i]);
            }
        }
        return res;
    }
}
