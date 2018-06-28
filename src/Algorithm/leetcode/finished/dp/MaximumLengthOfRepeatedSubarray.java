package Algorithm.leetcode.finished.dp;

/**
 Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

 Example 1:
 Input:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 Output: 3
 Explanation:
 The repeated subarray with maximum length is [3, 2, 1].
 Note:
 1 <= len(A), len(B) <= 1000
 0 <= A[i], B[i] < 100
 * Created by zhanghr on 2018/6/17.
 */

public class MaximumLengthOfRepeatedSubarray {
    /**
     * 比对于这两个数组[1,2,2]和[3,1,2]，我们的dp数组为：
     3 1 2
     1 0 1 0
     2 0 0 2
     2 0 0 1
     我们注意观察，dp值不为0的地方，都是当A[i] == B[j]的地方，而且还要加上左上方的dp值，即dp[i-1][j-1]，
     所以当前的dp[i][j]就等于dp[i-1][j-1] + 1，而一旦A[i] != B[j]时，直接赋值为0，
     不用多想，因为子数组是要连续的，一旦不匹配了，就不能再增加长度了。

     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int l1 = A.length, l2=B.length;
        int[][] dp = new int[l1+1][l2+1];
        int res = 0;
        for (int i=1; i<=l1; i++){
            for (int j=1; j<=l2;j++){
                dp[i][j] = A[i-1]==B[j-1] ? dp[i-1][j-1]+1 : 0;
                res = Math.max(res, dp[i][j]);

            }
        }
        return res;
    }
}
