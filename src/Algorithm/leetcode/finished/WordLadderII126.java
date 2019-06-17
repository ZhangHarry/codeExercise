package Algorithm.leetcode.finished;

import java.util.*;

/**
 * Created by zhanghr on 2018/8/27.
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output:
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: []

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadderII126 {
    public static void main(String[] args){
        WordLadderII126 test = new WordLadderII126();
        String beginWord = "red";
        String endWord = "tax";
        String[] words = new String[]{"ted","tex","tax","tad","den","rex","pee"};
        List<String> wordList = new LinkedList<>();
        wordList.addAll(Arrays.asList(words));
        List<List<String>> res = test.findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }

    // beat 15%
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        LinkedList<List<String>> queue = new LinkedList<>();
        dict.remove(beginWord);
        List<String> begin = new LinkedList<>();
        begin.add(beginWord);
        queue.add(begin);
        int layerNum = 1;
        List<List<String>> res = new LinkedList<>();
        while (!queue.isEmpty() && dict.size()>0){
            int tmp=0;
            HashSet<String> remove = new HashSet<>();
            while (layerNum>0){
                layerNum--;
                List<String> trace = queue.poll();
                char[] str = trace.get(trace.size()-1).toCharArray();
                for (int i=0; i<str.length; i++){
                    char ch = 'a';
                    while (ch<='z'){
                        if (str[i] != ch){
                            char t = str[i];
                            str[i] = ch;
                            String ns =new String(str);
                            if (dict.contains(ns)){
                                tmp++;
                                remove.add(ns);
                                List<String> ntrace = new LinkedList<>(trace);
                                ntrace.add(ns);
                                queue.add(ntrace);
                                if (ns.equals(endWord))
                                    res.add(ntrace);
                            }
                            str[i] = t;
                        }
                        ch++;
                    }
                }
            }
            dict.removeAll(remove);
            if (res.size() > 0)
                break;
            layerNum= tmp;
        }
        return res;
    }
}
