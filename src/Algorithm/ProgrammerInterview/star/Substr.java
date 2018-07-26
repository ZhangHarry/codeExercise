package Algorithm.ProgrammerInterview.star;

/**
 * Created by zhanghr on 2018/7/25.
 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串。

 给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，每个元素代表p中的对应字符串是否为s的子串。
 保证p中的串长度小于等于8，且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
 */
import java.util.*;
public class Substr {
    // 实现后缀树
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        SuffixTree tree = new SuffixTree();
        int sL = s.length();
        for (int i=sL-1; i>=0; i--){
            tree.add(s.substring(i));
        }
        boolean[] res = new boolean[p.length];
        for (int i = 0; i<res.length; i++){
            res[i] = tree.contains(p[i]);
        }
        return res;
    }
}

class SuffixTree{
    Node root = new Node();

    public void add(String s){
        char[] str = s.toCharArray();
        int i=0;
        Node node = root;
        while (i<str.length){
            char c = str[i];
            Node next = node.search(c);
            if (next == null){
                for (int j=i; j<str.length; j++){
                    Node nNode = new Node();
                    nNode.val = str[j];
                    node.next.add(nNode);
                    node = nNode;
                }
                break;
            }else{
                node = next;
                i++;
            }
        }
    }

    public boolean contains(String s){
        char[] str = s.toCharArray();
        int i=0;
        Node node = root;
        while (i<str.length){
            char c = str[i];
            Node next = node.search(c);
            if (next == null){
                return false;
            }else{
                node = next;
                i++;
            }
        }
        return true;
    }

    class Node{
        char val;
        List<Node> next =new LinkedList<>();

        Node search(char c){
            for (Node n : next){
                if (n.val == c)
                    return n;
            }
            return null;
        }
    }
}
