package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/27.
 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。
 然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。

 给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
 */

import java.util.*;

public class Joseph {
    public static int getResult(int n, int m) {
        // write code here
        Queue<Integer> list = new LinkedList<>();
        for (int i=1;i<=n;i++)
            list.add(i);
        int index=1;
        while(list.size()>1){
            Integer i = list.poll();
            if(index == m){
                index = 1;
            }else{
                list.add(i);
                index++;
            }
        }
        return list.poll();
    }

    public static void main(String[] args){
        System.out.println(Joseph.getResult(5, 3));
    }
}