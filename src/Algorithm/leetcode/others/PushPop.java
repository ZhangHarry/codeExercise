package Algorithm.leetcode.others;

import java.util.*;

/**
 * Created by zhanghr on 2017/4/5.
 */
public class PushPop {
    /**
     * 题目：
     * 1、输入两个整数序列。其中一个序列表示栈的push顺序，判断另一个序列有没有可能是对应的pop顺序。
     * 2、生成所有合法的pop顺序
     * @param pushQ
     * @param popQ
     * @param print
     * @return
     */
    public static boolean verify_push_pop(Queue<Integer> pushQ, Queue<Integer> popQ, boolean print){
        Stack<Integer> stack = new Stack<>();
        if (pushQ.size() < popQ.size())
            return false;
        while (!popQ.isEmpty()){
            int pop = popQ.poll();
            while (stack.isEmpty() || stack.peek() != pop) {
                if (pushQ.isEmpty())
                    return false;
                stack.push(pushQ.poll());
                if (print){
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.print(stack.get(i)+"|");
                    }
                    System.out.print("\t<----------- push "+stack.peek()+"\n");
                    System.out.print("===============\n");
                }
            }
            stack.pop();
            if (print){
                for (int i = 0; i < stack.size(); i++) {
                    System.out.print(stack.get(i)+"|");
                }
                System.out.print("\t-----------> pop "+pop+"\n");
                System.out.print("===============\n");
            }
        }
        return true;
    }


    static HashMap<String, List<String>> map = new HashMap<>(); // 方便解决序列中出现相同字符的情况，比如push两个2
    public static List<String> generatePopStr(String pushQ){
        if (pushQ.equals(""))
            return new LinkedList<>();
        // 下面需要reverse的原因是具体实现中将后半段当作已有栈，从左往右就是push顺序
        // 而输入顺序与栈的顺序恰恰相反 5 4 3 与 3 4 5
        return generatePopStr(reverse(pushQ), "");
    }

    private static List<String> generatePopStr(String dynSeq, String fixSeq){
        List<String> list = new LinkedList<>();
        // 递归的返回条件，当动态组为空时，返回fixSeq
        if (dynSeq.equals("")){
            list.add(fixSeq);
            return list;
        }
        // 先移出动态组中一个
        String[] dynSequence = dynSeq.split(seperator);
        for (int i = 0; i < dynSequence.length; i++) {
            StringBuffer dynSb = new StringBuffer();
            StringBuffer fixSb = new StringBuffer();
            for (int j =0 ; j < i; j++) {
                dynSb.append(dynSequence[j] + seperator);
            }
            if (dynSb.toString().endsWith(seperator))
                dynSb.deleteCharAt(dynSb.toString().length() - 1);
            for (int j=i+1; j < dynSequence.length; j++) {
                fixSb.append(dynSequence[j] + seperator);
            }
            String newFixSeq = fixSb.toString()+fixSeq;
            String newPushSeq = dynSb.toString();
            List<String> subPopQ;
            if ((subPopQ = map.get(newPushSeq+","+newFixSeq)) == null){
                subPopQ = generatePopStr(newPushSeq, newFixSeq);
            }
            List<String> popQ = new LinkedList<>();
            for(String subQ : subPopQ) {
                popQ.add(dynSequence[i] + seperator + subQ);
            }
            list.addAll(popQ);
        }
        // 先移出静态组的第一个
        if (!fixSeq.equals("")) {
            String[] fixSequence = fixSeq.split(seperator);
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < fixSequence.length; i++) {
                sb.append(fixSequence[i] + seperator);
            }
            if (sb.toString().endsWith(seperator))
                sb.deleteCharAt(sb.toString().length() - 1);
            List<String> subPopQ;
            if ((subPopQ = map.get(dynSeq + "," + sb.toString())) == null) {
                subPopQ = generatePopStr(dynSeq, sb.toString());
            }
            List<String> popQ = new LinkedList<>();
            for (String subQ : subPopQ) {
                popQ.add(fixSequence[0] + seperator + subQ);
            }
            list.addAll(popQ);
        }
        map.put(dynSeq+","+fixSeq, list);
        return list;
    }

    static String seperator = " ";
    public static void main(String[] args){
        String push = "4 3 2 1";
        List<String> popList = PushPop.generatePopStr(push);
        for (String str : popList){
            if (!(PushPop.verify_push_pop(createQ(push), createQ(str), false))) {
                System.err.println(str);
            }else {
                System.out.println(str);
            }
        }
    }

    private static String reverse(String push) {
        StringBuffer sb = new StringBuffer();
        for (int i = push.length()-1; i >= 0 ; i--) {
            sb.append(push.charAt(i));
        }
        return sb.toString();
    }

    private static Queue<Integer> createQ(String str) {
        Queue<Integer> queue = new LinkedList<>();
        String[] sequence = str.split(seperator);
        for (String integer : sequence) {
            queue.add(Integer.parseInt(integer));
        }
        return queue;
    }
}
