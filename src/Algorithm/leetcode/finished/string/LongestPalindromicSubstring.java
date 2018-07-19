package Algorithm.leetcode.finished.string;

/**
 * Created by zhanghr on 2018/7/19.
 *
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"

 */

public class LongestPalindromicSubstring {
    int max = 0;
    int start = 0;
    // beat 98%
    // 思路：从内往外扩展。另外性能方面需要注意的地方是我们在保存遍历过程中最长子串的时候，可以直接保存子串，但是更高效的方式是保存index，因为子串需要创建对象
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        if (str.length<2)
            return s;
        for (int i=0; i<str.length-max/2; i++){
            expandPalindromicStr(str, i, i); // odd Palindromic string
            expandPalindromicStr(str, i, i+1);// even Palindromic string
        }
        return s.substring(start, start+max);
    }

    public void expandPalindromicStr(char[]str,int i,int j){
        if (j>=str.length || str[i] != str[j])
            return;
        while (i>=0 && j<str.length && str[i] == str[j]){
            i--;
            j++;
        }
        int length = j-i-1;
        if (length > max){
            max = length;
            start = i+1;
        }
    }
}
