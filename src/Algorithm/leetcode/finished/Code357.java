package Algorithm.leetcode.finished;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding [11,22,33,44,55,66,77,88,99])
 * Created by zhanghr on 2016/12/14.
 */
public class Code357 {
    int[] reverse_factor = new int[10];
    int[] result = new int[11];

    public Code357(){
        reverse_factor[0] = 1;
        result[0] = 1;

    }
    public int countNumbersWithUniqueDigits(int n) {
        if (n > reverse_factor.length-1)
            n = reverse_factor.length-1;
        if (result[n] == 0)
            compute(n);
        return result[n];
    }

    public void compute(int n){
        for (int i =1; i<= n;i++){
            if (reverse_factor[i] == 0)
                reverse_factor[i] = reverse_factor[i-1] * (10-i);
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == 0)
                result[i] = result[i-1] + 9*reverse_factor[i-1];
        }
    }



    public void case1(){
        System.out.print(countNumbersWithUniqueDigits(3));
    }

    public static void main(String[] args){
        new Code357().case1();
    }
}
