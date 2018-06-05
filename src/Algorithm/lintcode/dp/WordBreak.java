package Algorithm.lintcode.dp;

/**
 * Created by zhanghr on 2018/6/1.
 */
import java.util.*;
public class WordBreak {

    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s.length()==0 && dict.size()==0)
            return true;
        if (s.length()==0 || dict.size()==0)
            return false;
        boolean[] dp = new boolean[s.length()+1];
        int maxLength =0;
        for (String str: dict){
            maxLength = Math.max(maxLength, str.length());
        }
        for (int i=1; i<=s.length();i++){
            boolean checked = false;
            for (int j=1; j<=maxLength && i-j>=0;j++){
                String tmp = s.substring(i-j, i);
                if (dict.contains(tmp)){
                    if (i-j == 0 || dp[i-j]) {
                        dp[i] = true;
                        checked = true;
                        break;
                    }
                }
            }
            if (!checked)
                 dp[i] = false;
        }
        return dp[s.length()];
    }

    int[] record;
    // runtime error stack overflow
    public boolean wordBreak(String s, Set<String> dict, int start) {
        // write your code here
        int length = s.length();
        if (start == length)
            return true;
        int end = start+1;
        while (end <= length){
            String sub = s.substring(start,end);
            if (dict.contains(sub)){
                if(record[end] != 0) {
                    if (record[end] == 1)
                        return true;
                }else{
                    boolean bl =wordBreak(s, dict, end);
                    if(bl)
                        return true;
                    else
                        record[end] = -1;
                }
            }
            end++;
        }
        return false;
    }

    public static void main(String[] args){
        WordBreak test = new WordBreak();
        String s ="lintcode";
        Set<String> dict = new HashSet<>();
        dict.add("lint");
        dict.add("code");
        System.out.println(test.wordBreak(s, dict));
    }
}
