package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/24.
 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。

 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
 请返回一个int[][](C++为vector&ltvector&ltint>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */

import java.util.*;

public class SetOfStacks {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> stacks = new ArrayList<>();
        for (int i=0; i<ope.length;i++){
            int op = ope[i][0];
            int num = ope[i][1];
            if (op == 1){ // push
                if (stacks.size()==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num);
                    stacks.add(list);
                }else{
                    ArrayList<Integer> list = stacks.get(stacks.size()-1);
                    if (list.size()==size){
                        list = new ArrayList<>();
                        list.add(num);
                        stacks.add(list);
                    }else
                        list.add(num);
                }
            }else if (op == 2){ // pop
                ArrayList<Integer> list = stacks.get(stacks.size()-1);
                list.remove(list.size()-1);
                if (list.size()==0)
                    stacks.remove(stacks.size()-1);
            }
        }
        return stacks;
    }
}
