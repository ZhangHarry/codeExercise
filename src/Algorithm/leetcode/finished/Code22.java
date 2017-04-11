package Algorithm.leetcode.finished;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 * Created by zhanghr on 2017/3/2.
 */
public class Code22 {

    /**
     * 类似于动态规划，n个括号是在n-1个括号的基础上拓展：外套()，左加()，右加()
     * 另外就是注意重复的情况： 只有()()()这种类型会出现重复——左加和右加相同
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        result.add("()");
        if (n == 1){
            return result;
        }
        for (int i=0;i<n-1;i++){
            List<String> newResult = new LinkedList<>();
            newResult.add("()"+result.get(0));
            for (int j = 0; j < result.size(); j++) {
                newResult.add("("+result.get(j)+")");
                if (j!=0){
                    newResult.add("()"+result.get(j));
                    newResult.add(result.get(j)+"()");
                }
            }
            result = newResult;
        }
        return result;
    }

    /**
     * 8 / 8 test cases passed.
     * Status: Accepted
     * Runtime: 11 ms
     * Beats 7.2%
     *
     * 类似于树结构，优先选择(进行拓展
     *           ()
     *        /   \
     *      ((    ()
     *      |     |
     *     (()   ()(
     *     |      |
     *   (())   ()()
     * @param n
     * @return
     */
    public static List<String> generateParenthesis2(int n) {
        List<Node> tree = new LinkedList<>();
        Node root = new Node("", n, n);
        tree.add(root);
        int length = 0;
        while (length < 2*n){
            List<Node> temp = new LinkedList<>();
            for (int i = 0; i < tree.size(); i++) {
                Node curNode = tree.get(i);
                if (curNode.left > 0 ){
                    Node newNode = new Node(curNode.content+"(", curNode.left-1, curNode.right);
                    temp.add(newNode);
                }
                if (curNode.right >0 && curNode.left < curNode.right){
                    Node newNode = new Node(curNode.content+")", curNode.left, curNode.right-1);
                    temp.add(newNode);
                }
            }
            length++;
            tree = temp;
        }
        List<String> result = new LinkedList<>();
        for (int i = 0; i < tree.size(); i++) {
            result.add(tree.get(i).content);
        }
        return result;
    }

    public static void main(String[] args){
        List<String> result = Code22.generateParenthesis2(3);
        Code22.print(result);
//        String realResult = "[\"()()()()\",\"(()()())\",\"((()()))\",\"()(()())\",\"(()())()\",\"(((())))\",\"()((()))\",\"((()))()\",\"(()(()))\",\"()()(())\",\"()(())()\",\"((())())\",\"()(())()\",\"(())()()\"]";
//        Parser.diff(result, Parser.strings2List(realResult));
    }

    public static void print(List<String> list){
        for (String s : list){
            System.out.format("%s%n", s);
        }
    }
}

class Node{
    String content;
    int left, right;

    Node(String s, int left, int right){
        this.content = s;
        this.left = left;
        this.right = right;
    }
}
