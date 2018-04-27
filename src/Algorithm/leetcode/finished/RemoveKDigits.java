package Algorithm.leetcode.finished;

/**
 * 
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 */
public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if (k<=0)
            return num;
        int digits = num.length()-k;
        char[] array = new char[num.length()];
        int index = 0;
        // 贪心算法，有k次机会移除前面的项。后一项比前一项小的时候，移除前面的就是最优解
        for (int i =0; i<num.length(); i++){
            char c = num.charAt(i);
            while (index > 0  && k > 0 && array[index-1] > c){
                index--;
                k--;
            }
            array[index] = c;
            index++;
        }
        int firstNonZero = 0;
        while (array[firstNonZero] == '0' && firstNonZero < digits)
            firstNonZero++;
        if (firstNonZero == digits)
            return "0";
        else 
            return new String(array, firstNonZero, digits-firstNonZero);
    }
}
