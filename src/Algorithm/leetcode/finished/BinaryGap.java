package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/8/1.
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

 If there aren't two consecutive 1's, return 0.

 Input: 22
 Output: 2
 Explanation:
 22 in binary is 0x10110.
 */

public class BinaryGap {
    public static int binaryGap(int N) {
        int max = 0;
        int before = -1;
        int bits = 0;
        while(N>0){
            if (N%2 == 1){
                if (before >=0){
                    max = Math.max(max, bits-before);
                    before = bits;
                }else{
                    before = bits;
                }
            }
            bits++;
            N = N>>1;
        }
        return max;
    }

    public static void main(String[] args){
        BinaryGap.binaryGap(22);
    }
}
