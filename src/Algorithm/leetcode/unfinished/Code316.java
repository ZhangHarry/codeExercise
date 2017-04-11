package Algorithm.leetcode.unfinished;

import java.util.*;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * Example:
 * Given "bcabc"
 * Return "abc"
 * Given "cbacdcbc"
 * Return "acdb"
 *
 * Created by zhanghr on 2016/12/15.
 */
public class Code316 {
    boolean debug = true;
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0)
            return "";
        String result = remove(s, true);
        if (debug)
            System.out.println(result);
        while (!result.equals(s)){
            s = result;
            result = remove(s, true);
            if (debug)
                System.out.println(result);
        }
        result = remove(s, false);
        if (debug)
            System.out.println(result);
        result = removeDuplicateLettersSimply(result);
        if (debug)
            System.out.println(result);
        return result;
    }

    private String removeDuplicateLettersSimply(String result) {
        int[] position = new int[26]; //该字母的位置
        init(position);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (position[c-'a'] < 0) {
                sb.append(c);
                position[c-'a'] = i;
            }
        }
        return sb.toString();
    }


    private String remove(String s, boolean preserve){
        int[] map = new int[26]; // b在某个本来排在它前面的字母前面，map[1]表示b在s中的位置
        int[] position = new int[26]; //该字母在s中的位置
        init(map);
        init(position);
        List<Content> list = new LinkedList<>();
        Map<Integer, Content> contentMap = new HashMap<>(); // <index, c>

        add(list, contentMap, new Content(s.charAt(0), 0));
        position[s.charAt(0)-'a'] = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 't')
                System.out.print("");
            if (position[c-'a'] < 0) { //新字母
                Content pre = list.get(list.size()-1);
                add(list, contentMap, new Content(c, i));
                position[c-'a'] = i;
                if (pre.c > c){
                    map[pre.c-'a'] = pre.index;
                }
            }
            else {
                if (map[c-'a'] >= 0){ // 将顺序不对的字母删除，加在末尾
                    int index = removeChar(contentMap.get(map[c-'a']), list);
                    add(list, contentMap, new Content(c, i));
                    update(map, index, c, list);
                    position[c-'a'] = i;
                }else { //虽然顺序正确，但是可能跟在它后面的字母会被删除导致出现顺序不正确，所以需要保留
                    if (c == s.charAt(i-1)){ // 消除连续的重复项
                        list.remove(list.size()-1);
                        position[c-'a'] = i;
                        add(list, contentMap, new Content(c, i));
                    }
                    else if (preserve)
                        add(list, contentMap, new Content(c, i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).c);
        }
        return sb.toString();
    }

    private void add(List<Content> list, Map<Integer, Content> contentMap, Content content) {
        list.add(content);
        contentMap.put(content.index, content);
    }

    private int removeChar(Content c, List<Content> list) {
        int i = list.indexOf(c);
        list.remove(i);
        return i;
    }

    private void update(int[] map, int removeIndex, char c, List<Content> list) {
        Content pre;
        if (removeIndex > 0 && (pre = list.get(removeIndex-1)).c > list.get(removeIndex).c){ // 变换字母后，前一个字母可能变成是顺序错误的
            map[pre.c-'a'] = pre.index;
        }
        if (list.size()>1 && (pre = list.get(list.size()-2)).c > c){ // 添加一个字母到列表末尾，判断是否令前一个字母变成顺序错误
            map[pre.c-'a'] = pre.index;
        }
        map[c-'a'] = -1;

    }

    private void init(int[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = -1;
        }
    }

    class Content{
        Character c;
        int index;
        Content(Character c, int index){
            this.c = c;
            this.index = index;
        }
    }


    public static void main(String[] args){
        String s , result;
        Code316 obj = new Code316();
//        obj.debug = false;
//        s = "bcabc";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("abc")));
//        s = "cbacdcbc";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("acdb")));
//        s = "bddbccd";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("bcd")));
//        s = "cbaddabaa";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("cadb")));
//        s = "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("bfegkuyjorndiqszpcaw")));
//        s = "beeaddbeb";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("adbe")));
//        s = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("chzafipuegjlxdqnbsotwrym")));
        s = "wmxkuuoordmnpnebikzzujdpscpedcrsjphcaykjsmobturjjxxpoxvvrynmapegvtlasmyuddgxygkaztmbpkrnukbxityz";
        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("wbcdhajmoegvlskprnuxityz")));
    }

}
