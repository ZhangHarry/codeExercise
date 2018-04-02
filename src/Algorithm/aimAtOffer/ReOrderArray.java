package Algorithm.aimAtOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author zhanghr
 *
 */

public class ReOrderArray {
	public void reOrderArray(int [] array) {
        int oddCount = 0;
        for (int i =0; i<array.length; i++){
            if (array[i] % 2 == 1)
                oddCount++;
        }
        if (oddCount == 0 || oddCount == array.length)
            return;
        int[] copy = array.clone();
        int oddIndex = 0, evenIndex = oddCount;
        for (int i = 0; i<copy.length; i++){
            if (copy[i] % 2 == 1){
                array[oddIndex] = copy[i];
                oddIndex++;
            }else {                
                array[evenIndex] = copy[i];
                evenIndex++;
            }
        }
    }
}
