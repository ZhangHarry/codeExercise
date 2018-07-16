package Algorithm.leetcode.finished;

/**
 Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 Return the maximum valued number you could get.

 Example 1:
 Input: 2736
 Output: 7236
 Explanation: Swap the number 2 and the number 7.
 Example 2:
 Input: 9973
 Output: 9973
 Explanation: No swap.
 Note:
 The given number is in the range [0, 108]

 * Created by zhanghr on 2018/7/8.
 */

public class MaximumSwap {
    // beat 100%, 111 test cases, 5ms
    // 思路：从后往前遍历，获取当前位置可以替换的最佳位置
    // 注意点：这里的解法中maxs数组存index，应该也可以改成直接存value
    // 注意点：当有多个可选的替换值时选择最后的那个，
    public int maximumSwap(int num) {
        if (num <= 10)
            return num;
        char[] array = new String(""+num).toCharArray();
        int[] maxs = new int[array.length];
        int i = array.length-1;
        int max = i;
        maxs[i] = max;
        i--;
        for (; i>=0; i--){
            if (array[i] > array[max]) // 选择最后的那个，所以不能是>=
                max = i;
            maxs[i] = max;
        }
        for (int j=0; j<maxs.length; j++){
            if (maxs[j] != j && array[maxs[j]] != array[j]){
                char tmp = array[j];
                array[j] = array[maxs[j]];
                array[maxs[j]] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(array));
    }
}
