package Algorithm.aimAtOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhanghr on 2018/4/30.
 */

public class Permutation {
    public static void main(String[] args){
        Permutation test = new Permutation();
        test.Permutation("aabc");
        test.Permutation("aa");
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str.length()==0)
            return list;
        int[] lowChars = new int[26];
        int[] upperChars = new int[26];
        for (int i=0;i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch >='a' && ch<='z')
                lowChars[ch-'a']++;
            else
                upperChars[ch-'A']++;
        }
        char[] chars = new char[str.length()];
        int index =0;
        for (int i=0;i<26;i++){
            int j = lowChars[i];
            while (j-->0)
                chars[index++] = (char)('a'+i);
        }
        for (int i=0;i<26;i++){
            int j = upperChars[i];
            while (j-->0)
                chars[index++] = (char)('A'+i);
        }
        backTrack(list, chars, 0, chars.length-1);
        Collections.sort(list);
        System.out.println(list);
        return list;
    }

    public void backTrack(ArrayList<String> list, char[] chars, int start, int end){
        if (start == end){
            list.add(new String(chars));
            return;
        }
        backTrack(list, chars, start+1, end);

        for (int i=start+1; i<= end;i++){
            while (i<= end && chars[i] == chars[i-1]) // skip
                i++;
            if (i>end) // end
                return;
            if (chars[start] != chars[i]) { // valid swap
                swap(chars, start, i);
                backTrack(list, chars, start + 1, end);
                swap(chars, i, start);
            }
        }
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
