package Algorithm.ProgrammerInterview.star;

/**
 * Created by zhanghr on 2018/7/27.
 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。

 给定一个数int k，请返回第k个数。保证k小于等于100。
 */
import java.util.*;

public class KthNumber {
    // 采用三个队列来记录队列首元素的下一个乘积，更简单的方法是使用数组保存所有生成的元素，通过三个指针来记录当前元素的下一个乘积
    public int findKth(int k) {
        // write code here
        List<Integer> l3 = new LinkedList<>();
        List<Integer> l5 = new LinkedList<>();
        List<Integer> l7 = new LinkedList<>();
        l3.add(3);
        l3.add(5);
        l3.add(7);
        int[] list = new int[3];
        list[0] = 3;
        list[1] = 5;
        list[2] = 7;
        if (k<=3)
            return list[k-1];
        k = k-3;
        int res=0;
        while (k>0){
            int t3 = l3.size()>0 ? l3.get(0)*3 : Integer.MAX_VALUE;
            int t5 = l5.size()>0 ? l5.get(0)*5 : Integer.MAX_VALUE;
            int t7 = l7.size()>0 ? l7.get(0)*7 : Integer.MAX_VALUE;
            while (!l3.isEmpty() && (t3 = l3.get(0)*3) <= res){
                l3.remove(0);
            }
            res = Math.min(Math.min(t5,t7), t3);
            if (res == t3){
                l5.add(l3.get(0));
                l3.remove(0);
                l3.add(res);
            }
            if (res == t5){
                l7.add(l5.get(0));
                l5.remove(0);
                l3.add(res);
            }
            if (res == t7){
                l7.remove(0);
                l3.add(res);
            }
            System.out.println(String.format("%d : %d", k, res));
            k--;
        }
        return res;
    }


    public int findKth1(int index) {
        // write code here
        index++;
        int[] array = new int[index];
        int index1 = 0, index2 = 0, index3 = 0;
        int n = 1;
        array[0] = 1;
        while (n < index){
            int t1 = array[index1] * 3;
            int t2 = array[index2] * 5;
            int t3 = array[index3] * 7;
            int min = Math.min (Math.min(t1, t2), t3);
            array[n] = min;
            n++;

            if (min == t1)
                index1++;
            if (min == t2)
                index2++;
            if (min == t3)
                index3++;
        }
        return array[index-1];
    }

    public static void main(String[] args){
        KthNumber test = new KthNumber();
        System.out.println(test.findKth(16));
    }

}
