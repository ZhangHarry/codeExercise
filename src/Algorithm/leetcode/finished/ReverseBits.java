package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/8/2.

 Reverse bits of a given 32 bits unsigned integer.

 Example:

 Input: 43261596
 Output: 964176192
 Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 return 964176192 represented in binary as 00111001011110000010100101000000.
 Follow up:
 If this function is called many times, how would you optimize it?

 */

public class ReverseBits {
    // 注意负数的情况，beat 100%
    public int reverseBits(int n) {
        boolean neg = false;
        if (n<0){
            neg = true;
            n = n ^ (1<<31);
        }
        int res = 0;
        int bit = 0;
        while (n != 0){
            if (n % 2 == 1)
                res += 1<<(31-bit);
            n = n>>1;
            bit++;
        }
        if (neg)
            res++;
        return res;
    }
}
