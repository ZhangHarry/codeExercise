package Algorithm.leetcode.unfinished;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * Created by zhanghr on 2016/12/15.
 */
public class Code260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums){
            xor = xor ^ num;
        }
        int differentBit = getFirst1Bit(xor);
        int one = 0,two = 0,dividor = 1 << differentBit;
        for (int num : nums){
            if (num % dividor == 0)
                one = one ^ num;
            else
                two = two ^ num;
        }
        return new int[]{one, two};
    }

    /**
     * return first bit which is 1 in the binary form of xor
     * @param xor
     * @return
     */
    private int getFirst1Bit(int xor) {
        int bit = 0;
        while (xor/2 != 0 || xor%2 == 0){
            xor = xor/2;
            bit++;
        }
        return bit;
    }

    public static void main(String[] args){
        int[] array = {1, 3, 5, 2, 1, 2, 6, 6};
        int[] result = new Code260().singleNumber(array);
        System.out.format("%d, %d", result[0], result[1]);
    }
}
