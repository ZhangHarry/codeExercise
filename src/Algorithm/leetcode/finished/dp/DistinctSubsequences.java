package Algorithm.leetcode.finished.dp;

import java.util.Arrays;

/**
 Given a string S and a string T, count the number of distinct subsequences of S which equals T.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Example 1:

 Input: S = "rabbbit", T = "rabbit"
 Output: 3
 Explanation:

 As shown below, there are 3 ways you can generate "rabbit" from S.
 (The caret symbol ^ means the chosen letters)

 rabbbit
 ^^^^ ^^
 rabbbit
 ^^ ^^^^
 rabbbit
 ^^^ ^^^
 Example 2:

 Input: S = "babgbag", T = "bag"
 Output: 5
 Explanation:

 As shown below, there are 5 ways you can generate "bag" from S.
 (The caret symbol ^ means the chosen letters)

 babgbag
 ^^ ^
 babgbag
 ^^    ^
 babgbag
 ^    ^^
 babgbag
 ^  ^^
 babgbag
 ^^^
 * Created by zhanghr on 2018/7/4.
 */

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        if (s.length() == 0)
            return 1;
        int l2 = s.length(),l1 = t.length();
        int[][] dp = new int[l2+1][l1+1]; // dp[i][j]表示s.substring(i)与t.substring(j)的个数，要求s.i=t.j
        dp[l2][l1] = 1;
        for (int i=l2-1; i>=0; i--){
            for (int j=l1-1; j>=0; j--){
                if (s.charAt(i) == t.charAt(j)){
                    for (int k=l2-l1+j; k>=i; k--){
                        dp[i][j] += dp[k+1][j+1];
                    }
                }
            }
            System.out.println(i+ " : " + Arrays.toString(dp[i]));
        }
        int sum = 0;
        for (int i=0; i<= l2-l1; i++)
            sum += dp[i][0];
        return sum;
    }

    // beat 63.25%
    public int numDistinct1(String s, String t) {
        if (s.length() < t.length())
            return 0;
        if (s.length() == 0)
            return 1;
        int l2 = s.length(),l1 = t.length();
        int[][] dp = new int[l2+1][l1+1]; // dp[i][j]表示s.substring(i)与t.substring(j)的个数
        for (int i =0; i<=l2; i++)
            dp[i][l1] = 1;
        for (int i=l2-1; i>=0; i--){
            for (int j=l1-1; j>=0; j--){
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j] += dp[i+1][j+1];
                }
                dp[i][j] += dp[i+1][j];
            }
            System.out.println(i+ " : " + Arrays.toString(dp[i]));
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        DistinctSubsequences test = new DistinctSubsequences();
        System.out.println(test.numDistinct1("babgbag", "bag"));
        System.out.println(test.numDistinct1("rabbbit", "rabbit"));
    }
}
