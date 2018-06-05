package Algorithm.lintcode;

/**
 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 Example
 given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 * Created by zhanghr on 2018/6/3.
 */

public class IntegerBreak {
    /**
     * @param n: a positive integer n
     * @return: the maximum product you can get
     */
    int[] record = new int[59];
    public int integerBreak(int n) {
        // Write your code here
        record[1]=1;
        if (record[n] > 0)
            return record[n];
        int max = 0;
        for (int i=1; i<=n/2; i++){
            int left = Math.max(i, integerBreak(i));
            int right = Math.max(n-i,integerBreak(n-i));
            max = Math.max(left * right, max);
        }
        record[n] = max;
        return max;
    }

    public static void main(String[] args){
        IntegerBreak test = new IntegerBreak();
        System.out.println(test.integerBreak(10));
        System.out.println();
    }
}
