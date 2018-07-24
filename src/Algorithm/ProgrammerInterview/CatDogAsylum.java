package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/21.
 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，第一种为直接收养所有动物中最早进入收容所的，
 第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。

 给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。若第一个元素为1，则代表有动物进入收容所，
 第二个元素为动物的编号，正数代表狗，负数代表猫；若第一个元素为2，则代表有人收养动物，
 第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。
 若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。

 测试样例：
 [[1,1],[1,-1],[2,0],[2,-1]]
 返回：[1,-1]
 */

import java.util.*;

public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        LinkedList<Integer> dogs =new LinkedList<>();
        LinkedList<Integer> cats =new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<ope.length; i++){
            int[] op = ope[i];
            int event = op[0];
            int pick = op[1];
            if (event == 1){ // 进入收容所
                if (pick>0)
                    dogs.add(i);
                else if (pick<0)
                    cats.add(i);
            }else if(event == 2){// 收养
                if(pick == 0){ // 收养所有动物中最早的一只
                    if(dogs.size()>0 && cats.size()>0){
                        if (dogs.get(0)>cats.get(0)){
                            pick(cats, result, ope);
                        }else{
                            pick(dogs, result, ope);
                        }
                    }else if(dogs.size()>0)
                        pick(dogs, result, ope);
                    else
                        pick(cats, result, ope);
                }else if(pick==1){ // 收养狗
                    pick(dogs, result, ope);
                }else if(pick == -1){ // 收养猫
                    pick(cats, result, ope);
                }
            }
        }
        return result;
    }

    public void pick(LinkedList<Integer> animals, ArrayList<Integer> result, int[][] ope){
        if (animals.size()>0){
            result.add(ope[animals.get(0)][1]);
            animals.removeFirst();
        }
    }
}
