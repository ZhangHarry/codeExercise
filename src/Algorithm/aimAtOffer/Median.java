package Algorithm.aimAtOffer;
import java.util.*;
/**
 * 求输入流的中位数
 * Created by zhanghr on 2018/4/29.
 */

public class Median {

    Queue<Integer> minQ = new PriorityQueue<>(); // big
    Queue<Integer> maxQ = new PriorityQueue<>(new MBigComparator()); // small

    public void Insert(Integer num) {
        if (minQ.size() == maxQ.size()){
            if (minQ.size() == 0 || num < maxQ.peek())
                maxQ.add(num);
            else
                minQ.add(num);
        }else if (minQ.size() < maxQ.size()){
            maxQ.add(num);
            Integer move = maxQ.poll();
            minQ.add(move);
        }else{
            minQ.add(num);
            Integer move = minQ.poll();
            maxQ.add(move);
        }
        System.out.println(minQ);
        System.out.println(maxQ);
    }

    public Double GetMedian() {
        if (minQ.size() == maxQ.size())
            return ((minQ.peek() + maxQ.peek())/2.0);
        else if (minQ.size() < maxQ.size())
            return  maxQ.peek()*1.0;
        else
            return minQ.peek()*1.0;
    }

    public static void main(String[] args){
        Median test = new Median();
        int[] array = new int[]{ 5,2,3,4,1,6,7,0,8 };
        // "5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
        for (int i : array){
            System.out.println("insert "+i);
            test.Insert(i);
            System.out.println(test.GetMedian());
            System.out.println("========================");
        }
    }
}

class MBigComparator implements Comparator<Integer>{
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}
