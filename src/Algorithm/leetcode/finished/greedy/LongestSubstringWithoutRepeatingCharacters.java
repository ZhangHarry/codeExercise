package Algorithm.leetcode.finished.greedy;

/**
 * Created by zhanghr on 2018/7/12.
 *
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
    // beat 85.77%
    // 思路：使用一个list按顺序存储适合的元素，在加入新元素时按次序遍历，遇到相同的元素则抛弃剩下的。在遍历过程中保留最大长度。
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int max = 0;
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<array.length; i++){
            List<Integer> tmp = new LinkedList<>();
            tmp.add((int)array[i]);
            for (Integer integer : list){
                if (integer == array[i])
                    break;
                else
                    tmp.add(integer);
            }
            list = tmp;
            max = Math.max(max, list.size());
        }
        return max;
    }
}
