package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/27.
 约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。
 有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。

 给定一个int n，代表游戏的人数。请返回最后一个人的编号
 */

import java.util.*;

public class JosephII {
    public static int getResult(int n) {
        // write code here
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        for (int i=1;i<=n;i++)
            list.add(i);
        int max = 2;
        while(list.size()>1){
            int index=1;
            while (list.size()>0) {
                Integer i = list.poll();
                if(index != 1){
                    if (index == max)
                        index = 1;
                    else
                        index++;
                }else{
                    tmp.add(i);
                    index++;
                }
            }
            max++;
            tmp.add(0, tmp.getLast());
            tmp.removeLast();
            list = tmp;
            tmp = new LinkedList<>();
        }
        return list.poll();
    }

    public static void main(String[] args){
        System.out.println(JosephII.getResult(5));
    }
}