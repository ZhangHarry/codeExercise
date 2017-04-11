package Algorithm.leetcode.finished;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 *
 * Created by zhanghr on 2016/12/16.
 */
public class Code263 {

    /**
     * 1012 / 1012 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * beats 17%
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num < 1)
            return false;
        else if (num == 1)
            return true;
        else {
            while (num%2 == 0){
                num = num/2;
                if (num == 1)
                    return true;
            }
            while (num%3 == 0){
                num = num/3;
                if (num == 1)
                    return true;
            }
            while (num%5 == 0){
                num = num/5;
                if (num == 1)
                    return true;
            }
            return false;
        }
    }


    /**
     *
     * Runtime: 3 ms
     * @param num
     * @return
     */
    public boolean isUgly1(int num) {
        if (num < 1)
            return false;
        else if (num == 1)
            return true;
        else if (num%2 != 0 && num%5!=0 && sumDigit(num)%3!=0){
            return false;
        }
        else {
            while (num%2 == 0){
                num = num/2;
                if (num == 1)
                    return true;
            }
            while (num%3 == 0){
                num = num/3;
                if (num == 1)
                    return true;
            }
            while (num%5 == 0){
                num = num/5;
                if (num == 1)
                    return true;
            }
            return false;
        }
    }

    private int sumDigit(int num) {
        int result=0;
        while (num/10!=0){
            result += num%10;
            num = num/10;
        }
        result += num;
        return result;
    }

    public static void main(String[] args){
        new Code263().isUgly1(27);
    }
}
