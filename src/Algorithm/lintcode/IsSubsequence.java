package Algorithm.lintcode;

/**
 * Created by zhanghr on 2018/6/3.
 */

public class IsSubsequence {
    /**
     * @param s: the given string s
     * @param t: the given string t
     * @return: check if s is subsequence of t
     */
    public boolean isSubsequence(String s, String t) {
        // Write your code here
        int ls = s.length(), lt = t.length();
        if (ls == 0)
            return true;
        if (ls > lt)
            return false;
        int si =0, ti=0;
        while (si < ls && ti < lt){
            if (s.charAt(si) == t.charAt(ti)){
                si++;
                ti++;
            }else
                ti++;
        }
        if (si == ls)
            return true;
        else
            return false;
    }
}
