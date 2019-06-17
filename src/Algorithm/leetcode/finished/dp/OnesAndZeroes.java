package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/9/13.

 In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

 For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

 Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

 Note:
 The given numbers of 0s and 1s will both not exceed 100
 The size of given string array won't exceed 600.
 Example 1:
 Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 Output: 4

 Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 Example 2:
 Input: Array = {"10", "0", "1"}, m = 1, n = 1
 Output: 2

 Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

 */

public class OnesAndZeroes {
    public static void main(String[] args){
        String[] strs = new String[]{"10","0","1"};
        System.out.println(findMaxForm(strs, 1, 1));
    }
    // beat 46%
    // 其实就是背包问题，不过容量和代价由0、1的个数共同表示
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int[][] items = new int[strs.length][2];
        for (int i=0; i<items.length;i++){
            char[] str = strs[i].toCharArray();
            for (char c : str){
                items[i][c-'0']++;
            }
        }
        for (int k=0; k<strs.length; k++){
            int[] item = items[k];
            for (int i=m; i>=0; i--){
                for (int j=n; j>=0; j--){
                    if (i-item[0] >= 0 && j-item[1]>=0){
                        dp[i][j] = Math.max(dp[i][j], dp[i-item[0]][j-item[1]]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
