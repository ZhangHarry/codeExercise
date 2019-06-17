package Algorithm.leetcode.finished;

import java.util.*;
/**
 * Created by zhanghr on 2018/8/27.
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadder127 {
    public static void main(String[] args){
        WordLadder127 test = new WordLadder127();
        String beginWord = "red";
        String endWord = "tax";
        String[] words = new String[]{"ted","tex","red","tax","tad","den","rex","pee"};
        List<String> wordList = new LinkedList<>();
        wordList.addAll(Arrays.asList(words));
        System.out.println(test.ladderLength(beginWord, endWord, wordList));
    }

    // beat 25%，广度搜索
    // 答案里更优的代码不是从wordList里面找合适的，而是变动自己的一位，看是否在wordList里面。不过这个解法需要商榷，因为题目没有给定字符串和wordList的长度，这种做法是指数的，字符串很长时很可能比wordList长。
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int layerNum = 1;
        int times = 1;
        while (!queue.isEmpty() && wordList.size()>0){
            times++;
            int tmp=0;
            while (layerNum>0){
                layerNum--;
                String str = queue.poll();
                int num = addNext(str, queue, wordList, endWord);
                if (num==-1)
                    return times;
                else
                    tmp += num;
            }
            System.out.println(queue);
            layerNum= tmp;
        }
        return 0;
    }

    public int addNext(String s, LinkedList<String> queue, List<String> wordList, String endWord){
        char[] str = s.toCharArray();
        Iterator<String> it = wordList.iterator();
        int num = 0;
        while(it.hasNext()){
            String w = it.next();
            char[] word = w.toCharArray();
            if(ifTransformed(str, word)){
                if (w.equals(endWord))
                    return -1;
                queue.add(w);
                it.remove();
                num++;
            }
        }
        return num;
    }

    public boolean ifTransformed(char[] str, char[] word){
        if (str.length != word.length)
            return false;
        boolean res = false;
        for (int i=0; i<str.length; i++){
            if (str[i] != word[i]){
                if (res)
                    return false;
                else
                    res = true;
            }
        }
        return res;
    }
}
