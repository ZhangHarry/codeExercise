package Algorithm.DynamicProgramming.LCS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghr on 2016/11/20.
 */
public class TestLCS {
    public static void main(String[] args){
        Grid[][] lcsAray;

//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        list1.add(5);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(1);
//        list2.add(2);
//        list2.add(4);
//        list2.add(3);
//        list2.add(4);
//        list2.add(5);
//        lcsAray = new LCS<Integer>().getLCS(list1, list2);
//        LCS.showlcsArray(lcsAray, list1, list2);

        List<String> list3 = new ArrayList<>();
        list3.add("A");
        list3.add("B");
        list3.add("C");
        list3.add("B");
        list3.add("D");
        list3.add("A");
        list3.add("B");
        List<String> list4 = new ArrayList<>();
        list4.add("B");
        list4.add("D");
        list4.add("C");
        list4.add("A");
        list4.add("B");
        list4.add("A");
        LCS_A<String> lcs = new LCS_A<>(list3, list4, new NormalLCSDisplayer());
        lcs.showlcsArray();
        lcs.showlcs();
    }
}
