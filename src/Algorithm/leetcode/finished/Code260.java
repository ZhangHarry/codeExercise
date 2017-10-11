package Algorithm.leetcode.finished;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * beat 73.60%, 1ms
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
        int one = 0,two = 0;
        for (int num : nums){
            if (((num>>differentBit) &1) == 0)
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
        while (xor != 0 && (xor&1) == 0){
            xor = xor>>1;
            bit++;
        }
        return bit;
    }

    public static void main(String[] args){
    	Code260 code = new Code260();
        int[] array = {1, 3, 5, 2, 1, 2, 6, 6};
        int[] result = code.singleNumber(array);
        System.out.format("%d, %d%n", result[0], result[1]);
        
        int[]  array1 ={43772400,1674008457,1779561093,744132272,1674008457,448610617,1779561093,124075538,-1034600064,49040018,612881857,390719949,-359290212,-812493625,124732,-1361696369,49040018,-145417756,-812493625,2078552599,1568689850,865876872,865876872,-1471385435,1816352571,1793963758,2078552599,-1034600064,1475115274,-119634980,124732,661111294,-1813882010,1568689850,448610617,1347212898,-1293494866,612881857,661111294,-1361696369,1816352571,-1813882010,-359290212,1475115274,1793963758,1347212898,43772400,-1471385435,124075538,-1293494866,-119634980,390719949};
         result =code.singleNumber(array1);
//        int[] result1 = {-145417756,744132272};
        System.out.format("%d, %d%n", result[0], result[1]);
    }
}
