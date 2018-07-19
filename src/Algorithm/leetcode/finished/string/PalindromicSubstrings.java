package Algorithm.leetcode.finished.string;

/**
 * Created by zhanghr on 2018/7/19.

 iven a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:
 The input string length won't exceed 1000.

 */

public class PalindromicSubstrings {
    int count=0;
    // beat 100%
    // 思路：从特定位置往外扩展得到回文字符串
   public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        for (int i=0; i<str.length; i++){
            expandPalindromicStr(str, i, i); // odd Palindromic string
            expandPalindromicStr(str, i, i+1);// even Palindromic string
        }
        return count;
    }

    public void expandPalindromicStr(char[]str,int i,int j){
        while (i>=0 && j<str.length && str[i] == str[j]){
            count++;
            i--;
            j++;
        }
    }
}
