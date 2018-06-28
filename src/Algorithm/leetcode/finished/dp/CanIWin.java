package Algorithm.leetcode.finished.dp;

/**
 In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

 What if we change the game so that players cannot re-use integers?

 For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

 Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

 You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

 * Created by zhanghr on 2018/6/27.
 */

public class CanIWin {
    // beat 93.22%
    // 思路：基本思路很简单，记录选取了哪些值的时候的状态，这里优化的地方是不需要使用HashMap。
    //       只需要一个数组，数组每个元素的二进制表示就代表了选取了那些元素，所以数组的大小是2^M（i.e., 1<<M）。
    int[] states;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int max = (maxChoosableInteger+1) * maxChoosableInteger/2;
        if (desiredTotal > max)
            return false;
        if (desiredTotal <=0)
            return true;
        states = new int[1<<maxChoosableInteger];
        return dfs(maxChoosableInteger, desiredTotal, 0);
    }

    private boolean dfs(int choices, int desiredTotal,int state){
        if (desiredTotal <= 0)
            return false;
        if (states[state] != 0)
            return states[state] == 1;
        for (int i=0; i< choices; i++){
            if ((state & (1<<i)) == 0){
                if (!dfs(choices, desiredTotal-(i+1), state | (1<<i))){
                    states[state] = 1;
                    return true;
                }
            }
        }
        states[state] = -1;
        return false;
    }

    public static void main(String[] args){
        CanIWin test = new CanIWin();
        System.out.println(test.canIWin(10, 11));
        System.out.println();
    }
}
