package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/25.
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。

 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。
 请返回计算的结果，保证数据合法且结果一定在int范围内。
 */

public class AddSubstitution {
    public int calc(int a, int b, int type) {
        // write code here
        if (type == 1)
            return multiply(a, b);
        else if (type == 0)
            return divide(a, b);
        else
            return reduce(a, b);
    }

    public int multiply(int a,int b){
        int r = 0;
        int i=0;
        while (i<b){
            r += a;
            i++;
        }
        return r;
    }

    public int reduce(int a,int b){
        return a + (~b+1);
    }

    public int divide(int a,int b){
        int count=0;
        while (a>=b){
            count++;
            a -= b;
        }
        return count;
    }
}
