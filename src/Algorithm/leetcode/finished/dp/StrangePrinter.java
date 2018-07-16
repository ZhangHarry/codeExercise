package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/7/15.
 There is a strange printer with the following two special requirements:

 The printer can only print a sequence of the same character each time.
 At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
 Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.

 Example 1:
 Input: "aaabbb"
 Output: 2
 Explanation: Print "aaa" first and then print "bbb".
 Example 2:
 Input: "aba"
 Output: 2
 Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 Hint: Length of the given string will not exceed 100.

 */
public class StrangePrinter {
    int[][] dp;
    // beat 98.16%
    // 思路：dp，需要注意的地方，dp[i,j]=min{dp[i+1,k]+dp[k+1,j]}的成立条件是str[i]=str[k]
    // 注意：dp[i,j]=min{dp[i,k]+dp[k,j]}是不对，因为若str[i]=str[k+1]，就可以覆盖到k+1，导致算出的值比最优解大
    public int strangePrinter(String s) {
        char[] tmp = s.toCharArray();
        if (tmp.length<=1)
            return tmp.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        char[] str = s.toCharArray();
        dp = new int[str.length][str.length];
        return strangePrinter_recur(str, 0, str.length-1);
    }

    public int strangePrinter_recur(char[] str, int start, int end){
        if (start > end)
            return 0;
        if (dp[start][end]>0)
            return dp[start][end];
        int min = strangePrinter_recur(str, start+1, end)+1;
        for (int i=start+1; i<=end; i++){
            if (str[start] == str[i])
                min = Math.min(strangePrinter_recur(str, start+1, i)+strangePrinter_recur(str, i+1, end), min);
        }
        dp[start][end] = min;
        return dp[start][end];
    }

    // 错误答案，注意比较
    public int strangePrinter_recur(Character[] str, int start, int end){
        if (start == end){
            dp[start][end] = 1;
            return 1;
        }
        if (dp[start][end]>0)
            return dp[start][end];
        if (str[start] == str[end]){
            dp[start][end] = strangePrinter_recur(str, start+1, end-1)+1;
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i=start; i<end; i++){
            min = Math.min(strangePrinter_recur(str, start, i)+strangePrinter_recur(str, i+1, end), min);
        }
        dp[start][end] = min;
        return dp[start][end];
    }

    public static void main(String[] args){
        StrangePrinter test = new StrangePrinter();
        String s = "baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa";
        System.out.println(test.strangePrinter(s));
    }
}
