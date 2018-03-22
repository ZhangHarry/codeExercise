package Algorithm.leetcode.finished;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInString{
	public String reverseWords(String s) {
        String res = "";
        String[] words= s.trim().split("\\s+");
        for (int i = words.length-1; i >0;i--){
        	res += words[i]+" ";
        }
        return res + words[0];
    }

    public String reverseWords2(String s) {
        String res = "";
        String[] words= s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}