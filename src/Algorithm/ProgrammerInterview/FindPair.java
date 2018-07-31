package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/29.
 * 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。

 给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。
 */
import java.util.*;
public class FindPair {
    public int countPairs(int[] A, int n, int sum) {
        // write code here
        Arrays.sort(A);
        int start = 0, end = n-1;
        int res = 0;
        while(start<end){
            int s = A[start] + A[end];
            if (s > sum){
                end--;
            }else if (s < sum){
                start++;
            }else{
                res++;
                int tmp = end-1;
                while (tmp > start && A[tmp] == A[end]){
                    res++;
                    tmp--;
                }
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        FindPair test = new FindPair();
        int[] A = new int[] {1,2,2,2,3,4,4,4,5};
        System.out.println(test.countPairs(A, A.length, 6));
    }
}
