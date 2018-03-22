package Algorithm.leetcode.finished;

/**
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

 *
 * Created by zhanghr on 2018/3/22.
 */

public class UglyNumberII {
    // beat 89.4%
    public int nthUglyNumber(int n) {
        if (n<=5)
            return n;
        int[] array=new int[n];
        array[0]=1;
        int index1=0,index2=0,index3=0;
        for (int i=1;i<n;i++){
            int m1=array[index1]*2;
            int m2=array[index2]*3;
            int m3=array[index3]*5;
            int m=Math.min(m1, Math.min(m2,m3));
            if (m==m1)
                index1++;
            if (m==m2)
                index2++;
            if (m==m3)
                index3++;
            array[i]=m;
        }
        return array[n-1];
    }
}
