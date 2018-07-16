package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/15.
 *
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".

 */
import java.util.*;
public class WordBreak {
    HashMap<String, Boolean> map = new HashMap<>();
    // beat 35%
    // 思路：硬算
    // 优化思路：1、使用一个一维数组存储前i个字符能否切分，不需要用一个HashMap
    //           2、按dict进行遍历，而不是按i、j顺序（这点是反转思想，在很多问题上都能取得很好的优化效果）
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size()==0)
            return false;
        char[] str = s.toCharArray();
        HashSet<String> dict = new HashSet<>(wordDict);
        return wordBreak_recur(str,0, str.length-1, dict);
    }

    public boolean wordBreak_recur(char[] str,int start, int end, HashSet<String> dict){
        if (start>end)
            return false;
        String key = start+","+end;
        if (map.containsKey(key))
            return map.get(key);
        if (dict.contains(new String(str, start, end-start+1))){
            map.put(key, true);
            return true;
        }
        for (int i=start; i<end; i++){
            if (dict.contains(new String(str, start, i-start+1))){
                if(wordBreak_recur(str, i+1, end, dict)){
                    map.put(key, true);
                    return true;
                }
            }
        }
        map.put(key, false);
        return false;
    }
}
