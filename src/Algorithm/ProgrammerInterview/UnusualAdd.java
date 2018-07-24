package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/20.

 请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。

 给定两个int A和B。请返回A＋B的值

 测试样例：
 1,2
 返回：3

 */

public class UnusualAdd {
    public int addAB(int A, int B) {
        // write code here
        if (A == 0)
            return B;
        if (B == 0)
            return A;
        while (B != 0){
            int tmp = A;
            A = A^B;
            B = (tmp&B)<<1;
        }
        return A;
    }
}
