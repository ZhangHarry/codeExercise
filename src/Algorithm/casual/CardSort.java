package Algorithm.casual;

import java.util.*;

/**
 * Created by zhanghr on 2018/7/31.
 */

public class CardSort {
    public static void sort(int n){
        LinkedList<Integer> B = new LinkedList<>();
        LinkedList<Integer> A = new LinkedList<>();
        for (int i=1; i<=n; i++){
            B.add(0,i);
        }
        while (!B.isEmpty()){
            if (!A.isEmpty()) {
                int sec = A.getLast();
                A.removeLast();
                A.addFirst(sec);
            }
            A.addFirst(B.getFirst());
            B.removeFirst();
        }
        System.out.println(A);
    }

    public static void main(String[] args){
        CardSort.sort(5);
    }

}
