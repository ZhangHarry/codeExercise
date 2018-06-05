package Algorithm.lintcode;

/**
 *
 Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

 Example
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

 * Created by zhanghr on 2018/6/3.
 */

public class CountNumbersWithUniqueDigits {
    /**
     * 注意：对于太大的n，返回的是一个固定的值（小于它的unique digits）而不是0.
     * @param n: a non-negative integer
     * @return: number of numbers with unique digits
     */
    public int countNumbersWithUniqueDigits(int n) {
        // Write your code here
        if (n==0)
            return 1;
        if (n==1)
            return 10;
        if (n>=10)
            n=10;
        int sum = 10;// 0~100
        for (int i=2;i<=n;i++){
            int tmp = 9;
            int index =2;
            while (index <= i){
                tmp *= (11-index);
                index++;
            }
            sum += tmp;
            System.out.println(String.format("%d, %d", i, tmp));
        }
        return sum;
    }

    public static void main(String[] args){
        CountNumbersWithUniqueDigits test = new CountNumbersWithUniqueDigits();
        System.out.println(test.countNumbersWithUniqueDigits(11));
    }
}
