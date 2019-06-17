package Algorithm.ProgrammerInterview.star;

/**
 * Created by zhanghr on 2018/7/27.
 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。

 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。
 */

import java.util.*;

public class Frequency {
    // 前缀树，注意1、append时计数的情况。2、要求的是单词出现的次数，不是子串出现的次数，所以要在word后面加上特殊字符表示结束符
    public int getFrequency(String[] article, int n, String word) {
        // write code here
        PrefixTree tree = new PrefixTree();
        for (String w : article){
            tree.append(w+"$");
        }
        return tree.getCount(word+"$");
    }

    public static void main(String[] args){
        Frequency test = new Frequency();
        String[] article = new String[]{"a","b","a","ab","abc"};
        System.out.println(test.getFrequency(article, article.length, "a"));
    }
}

class PrefixTree{
    Node root = new Node();
    public void append(String s){
        char[] str = s.toCharArray();
        int i=0;
        Node cur = root;
        while (i<str.length){
            char c = str[i];
            Node next = cur.getNext(c);
            if (next == null){
                next = new Node();
                next.val = c;
                cur.addNext(next);
            }
            next.num++;
            cur = next;
            i++;
        }
    }

    public int getCount(String s){
        char[] str = s.toCharArray();
        int i=0;
        Node cur = root;
        while (i<str.length){
            char c = str[i];
            Node next = cur.getNext(c);
            if (next == null){
                return 0;
            }
            cur = next;
            i++;
        }
        return cur.num;
    }

    class Node{
        public char val;
        public int num=0;
        public HashMap<Character, Node> nexts = new HashMap<>();

        public Node getNext(char n){
            return nexts.get(n);
        }

        public void addNext(Node n){
            nexts.put(n.val, n);
        }
    }
}


