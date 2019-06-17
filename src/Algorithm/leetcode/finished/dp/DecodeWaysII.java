package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/9/5.

 A message containing letters from A-Z is being encoded to numbers using the following mapping way:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

 Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 */

public class DecodeWaysII {
    // 注意移溢出，直接采用long[]即可，如果dp是int数组，下面出现dp[i]与dp[j]的操作，这里因为两者都是int，所以两者之和可能发生溢出。
    // beat 50%
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        if (str.length==0 || str[0]=='0')
            return 0;
        long[] dp = new long[str.length+1];
        dp[0] = 1;
        dp[1] = str[0]=='*' ? 9 : 1;
        int MOD = 1000000007;
        for (int i=2; i<= str.length; i++){
            long tmp = 0;
            if (str[i-2]=='*'){
                if (str[i-1]=='*'){
                    tmp = (dp[i-1]*9) % MOD;
                    tmp = (tmp+dp[i-2]*15)%MOD;
                }else{
                    if (str[i-1]=='0')
                        tmp = (dp[i-2]*2)%MOD;
                    else if (str[i-1]>='1' && str[i-1]<='6')
                        tmp = ( dp[i-1]%MOD + (dp[i-2]*2)%MOD )%MOD;
                    else
                        tmp = ( dp[i-1]%MOD + dp[i-2]%MOD )%MOD;
                }
            }else{
                if (str[i-1]=='*'){
                    if (str[i-2]=='1')
                        tmp = ( (dp[i-1]*9)%MOD + (dp[i-2]*9)%MOD )%MOD;
                    else if(str[i-2]=='2')
                        tmp = ( (dp[i-1]*9)%MOD + (dp[i-2]*6)%MOD )%MOD;
                    else
                        tmp = (dp[i-1]*9)%MOD;
                }else{
                    tmp = ((str[i-1]>'0' ? dp[i-1] : 0) + (str[i-2] == '1' || (str[i-2]=='2' && str[i-1]<='6') ? dp[i-2] : 0))%MOD;
                }
            }
            dp[i] = tmp;
        }
        return (int)dp[str.length];
    }
}
