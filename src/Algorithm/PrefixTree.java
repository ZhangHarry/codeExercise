package Algorithm;

import java.util.HashMap;

/**
 * Created by zhanghr on 2018/8/9.
 */

public class PrefixTree {
    Node root = new Node();
    public void append(String s){
        char[] str = s.toCharArray();
        int i=0;
        PrefixTree.Node cur = root;
        while (i<str.length){
            char c = str[i];
            Node next = cur.getNext(c);
            if (next == null){
                next = new Node();
                next.val = c;
                cur.addNext(next);
            }
            cur = next;
            i++;
        }
    }

    public String find(String s){
        char[] str = s.toCharArray();
        int i=0;
        Node cur = root;
        while (i<str.length){
            char c = str[i];
            Node next = cur.getNext(c);
            if (next.num.length()>0)
                return next.num;
            if (next == null){
                return "unkown";
            }
            cur = next;
            i++;
        }
        return cur.num;
    }

    class Node{
        char val;
        String num = "";
        HashMap<Character, Node> nexts = new HashMap<>();

        public Node getNext(char n){
            return nexts.get(n);
        }

        public void addNext(Node n){
            nexts.put(n.val, n);
        }
    }
}
