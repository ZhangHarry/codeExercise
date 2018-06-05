package Algorithm.lintcode.dp;

/**
 Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

 Example
 For s1 = "aabcc", s2 = "dbbca"

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.

 * Created by zhanghr on 2018/6/4.
 */

public class InterleavingString {
    /**
     * beat 62.4%
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int l1 = s1.length(), l2=s2.length(), l3=s3.length();
        if (l3!=l1+l2)
            return false;
        boolean[][] dp = new boolean[l1+1][l2+1]; // dp[i][j]=true表示s1前i个字符串和s2前j个字符串可以组成s3前i+j个字符串
        for (int i=1; i<=l1;i++){
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int j=1; j<=l2; j++){
            dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1);
        }
        dp[0][0] = true;
        for (int i=1; i<=l1;i++){
            for (int j=1;j<=l2;j++){
                dp[i][j] = (s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j]) ||
                        (s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1]);
            }
        }
        return dp[l1][l2];
    }
}
