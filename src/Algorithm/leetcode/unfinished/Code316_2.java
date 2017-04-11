package Algorithm.leetcode.unfinished;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
public class Code316_2 {
    boolean debug = true;
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0)
            return "";
        String result = remove(s);
        if (debug) {
            System.out.println(s);
            System.out.println(result);
        }
        return result;
    }

    int[] map = new int[26]; // b可以调换到前面，map[1]表示b在s中的位置
    int[] position = new int[26]; //该字母在s中的位置
    List<Content> list = new LinkedList<>();
    Map<Integer, Content> contentMap = new HashMap<>(); // <index, c>

    private String remove(String s){
        init(map);
        init(position);

        add(list, contentMap, new Content(s.charAt(s.length()-1), s.length()-1));
        position[s.charAt(s.length()-1)-'a'] = 0;
        for (int i = s.length()-2;i>=0; i--) {
            char c = s.charAt(i);
            if (c == 'g' || c == 'b')
                System.out.print("");
            if (position[c-'a'] < 0) { //新字母
                position[c-'a'] = i;
                for (Content content : list) {
                    if (content.c < c) {
                        map[content.c - 'a'] = content.index;
                    }else {
                        map[content.c - 'a'] = -1;
                    }
                }
                add(list, contentMap, new Content(c, i));
            }
            else {
                if (map[c-'a'] >= 0){
                    int endIndex = contentMap.get(map[c - 'a']).index;
                    list.remove(contentMap.get(map[c - 'a']));
                    if (endIndex+1<s.length()) {
                        update(map, s.charAt(endIndex + 1), list);
                        reCheck(s, endIndex, i, list, map);
                    }
                    update(map, c, list);
                    add(list, contentMap, new Content(c, i));
                    position[c-'a'] = i;
                    map[c-'a']=-1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).c);
        }
        return sb.toString();
    }

    private void reCheck(String s, int endIndex, int startIndex, List<Content> list, int[] map) {
        for (int i=startIndex+1; i<endIndex; i++){
            char c = s.charAt(i);
            if (map[c - 'a'] >= 0) {
                list.remove(contentMap.get(map[c - 'a']));
                update(map, c, list);
                add(list, contentMap, new Content(c, i));
                position[c-'a'] = i;
                map[c-'a']=-1;
            }
        }
    }

    private void add(List<Content> list, Map<Integer, Content> contentMap, Content content) {
        list.add(0,content);
        contentMap.put(content.index, content);
    }

    private void update(int[] map,char c, List<Content> list) {
        for (Content content : list) {
            if (content.c < c) {
                map[content.c - 'a'] = content.index;
            }else {
                map[content.c - 'a'] = -1;
            }
        }
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
        String s , result, expect;
        Code316_2 obj = new Code316_2();
        obj.debug = true;
//        s = "bcabc";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("abc")));
//        s = "cbacdcbc";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("acdb")));
//        s = "bddbccd";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("bcd")));
//        s = "cbaddabaa";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("cadb")));
        s = "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws";
        expect = "bfegkuyjorndiqszpcaw";
        System.out.println((result=obj.removeDuplicateLetters(s)) + "-----" +(result.equals(expect))+ "-----"+expect);
//        s = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
//        expect = "chzafipuegjlxdqnbsotwrym";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + "-----"+(result.equals(expect))+ "-----"+expect);
//        s = "wmxkuuoordmnpnebikzzujdpscpedcrsjphcaykjsmobturjjxxpoxvvrynmapegvtlasmyuddgxygkaztmbpkrnukbxityz";
//        expect = "wbcdhajmoegvlskprnuxityz";
//        System.out.println((result=obj.removeDuplicateLetters(s)) + "-----"+(result.equals(expect))+ "-----"+expect);
    }

}
