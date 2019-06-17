package Algorithm.leetcode.finished.greedy;

/**
 * Created by zhanghr on 2018/9/12.
 * Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 一个解决方案是：把t每个字符的位置记录到一个map，遇到s的一个字符先判断有没有，没有则false，有则在map.entry里面二分查找。
 */

public class IsSubsequence392 {
    // beat 65%
    public boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if (sc.length > tc.length)
            return false;
        if (sc.length == 0)
            return true;
        int i=0, j=0;
        while (j<tc.length){
            while (j<tc.length && sc[i] != tc[j]){
                j++;
            }
            if (j != tc.length){
                i++;
                j++;
            }
            if (i==sc.length)
                return true;
        }
        return false;
    }
}
