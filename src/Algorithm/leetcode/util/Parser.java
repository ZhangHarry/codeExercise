package Algorithm.leetcode.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhanghr on 2017/3/5.
 */
public class Parser {
    /**
     *
     * @param s ["()()()()","(()()())","((()()))","()(()())","(()())()","(((())))","()((()))","((()))()","(()(()))","()()(())","()(())()","((())())","()(())()","(())()()"]
     * @return
     */
    public static List<String> strings2List(String s){
        String[] set = s.substring(1, s.length()-1).split(",");
        List<String> list = new LinkedList<>();
        for (String str : set){
            list.add(str.substring(1, str.length()-1));
        }
        return list;
    }

    public static void diff(List<String> list1, List<String> list2){
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (String s : list1){
            boolean ifRemove = false;
            for (int i = 0;i < list2.size();i++){
                if (s.equals(list2.get(i))) {
                    ifRemove = true;
                    list2.remove(i);
                    break;
                }
            }
            if (!ifRemove)
                sb1.append(s+",");
        }
        for (String s : list2)
            sb2.append(s+",");
        System.out.format("sb1:%s%nsb2:%s", sb1.toString(), sb2.toString());
    }
}
