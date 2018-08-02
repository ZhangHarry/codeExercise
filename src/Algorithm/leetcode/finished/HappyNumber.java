package Algorithm.leetcode.finished;

import java.util.HashSet;

/**
 * Created by zhanghr on 2018/8/2.

 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example:

 Input: 19
 Output: true
 Explanation:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */

public class HappyNumber {
    // 注意循环的情况
    // beat 70%
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int pre = n;
        while (true){
            if (pre == 1)
                return true;
            int res = calcsum(pre);
            if (res == pre || set.contains(res))
                return false;
            else{
                pre = res;
                set.add(res);
            }
        }
    }

    public static int calcsum(int n){
        int x = n;
        int sum = 0;
        while(x>0){
            sum+= (x%10)*(x%10);
            x/= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(HappyNumber.isHappy(2));
    }
}
