package Algorithm.lintcode.dp;

/**

 Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Example
 Given S = "rabbbit", T = "rabbit", return 3.

 * Created by zhanghr on 2018/6/2.
 */

public class DistinctSubsequences {
    /**
     * 空间还可以优化为O(n)：注意到dp[i][j]都依赖与dp[i-1]的值
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (T.length()==0)
            return 1;
        if (S.length() ==0)
            return 0;
        int l1 = S.length(), l2 = T.length();
        int[][] dp = new int[l1][l2]; // S的前i个字符和T的前j个字符有多少个可行的序列
        int tmp = 0;
        for (int i=0; i<l1; i++){
            if (S.charAt(i) == T.charAt(0)){
                tmp++;
            }
            dp[i][0] = tmp;
        }
        for (int i=1; i<l1;i++){
            for (int j=1; j<l2;j++){
                if (S.charAt(i) == T.charAt(j)){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[l1-1][l2-1];
    }

    public static void main(String[] args){
        DistinctSubsequences test = new DistinctSubsequences();
        String a = "aacaacca", b="ca";
        System.out.println(test.numDistinct(a,b));
    }

}
