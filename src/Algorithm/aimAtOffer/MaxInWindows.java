package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/4/25.
 */
import  java.util.*;
public class MaxInWindows {
    public static void main(String[] args){
        MaxInWindows test = new MaxInWindows();
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        test.maxInWindows(num, 3);
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num.length < size || size <= 0)
            return list;
        Queue<Integer> queue = new PriorityQueue<>(size, new BigComparator());
        int i=0;
        for (; i<num.length && i<size; i++){
            queue.add(num[i]);
        }
        int remove = 0;
        while (i < num.length){
            list.add(queue.peek());
            System.out.println("peek : " + queue.peek() + ", " + queue.size());
            Integer r = num[remove++];
            queue.remove(r);
            System.out.println("remove : " + r + ", " + queue.size());
            Integer add = num[i++];
            queue.add(add);
            System.out.println("add : " + add + ", " + queue.size());
        }
        list.add(queue.peek());
        return list;
    }
}

class BigComparator implements Comparator<Integer>{
    public int compare(Integer i1, Integer i2){
        return i2-i1;
    }
}