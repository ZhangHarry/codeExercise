package Algorithm.leetcode.finished.string;

import java.util.Arrays;

/**
 * Created by zhanghr on 2018/7/13.
 Find the length of the longest substring T of a given string (consists of lowercase letters only)
 such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

 */

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    // beat 61.53%
    // 思路来自于 https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution
    // 思路：进行26次循环，每次循环的意思是从字符串中取出符合条件的子字符串并且substring里只包含i个不同字符。
    //       对于恰好i个不同字符，这里是通过chars==satifiedChars表示。两个指针的作用就是用来指示起始和结束位置。
    //       因为每次循环的执行次数与两个指针的移动次数相关，每次都有一个指针移动，所以每次循环的复杂度是O(n)。
    //       所以算法的总复杂度是O(n)！
    // 另外一种常见的思路是分治法，先遍历一次字符串，找出小于k的字符的位置，从这个位置把字符串切成两个小字符串，然后递归。
    public int longestSubstring(String s, int k) {
        if(s.length()==0 || k<=0)
            return 0;
        char[] str = s.toCharArray();
        int max = 0;
        int i,j;
        int[] counts = new int[26];
        int chars, satifiedChars;
        for (int charNum=1; charNum<=26; charNum++){
            Arrays.fill(counts, 0);
            i=0;
            j=0;
            chars=0;
            satifiedChars=0;
            while (j<str.length){
                if(chars<=charNum){
                    if (counts[str[j]-'a'] == 0)
                        chars++;
                    counts[str[j]-'a']++;
                    if (counts[str[j]-'a'] == k)
                        satifiedChars++;
                    j++;
                }else{
                    if (counts[str[i]-'a'] == 1)
                        chars--;
                    if (counts[str[i]-'a'] == k)
                        satifiedChars--;
                    counts[str[i]-'a']--;
                    i++;
                }
                if (chars == charNum && satifiedChars==chars)
                    max = Math.max(max, j-i);
            }
        }
        return max;
    }


}
