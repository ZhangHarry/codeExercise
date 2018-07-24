package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/22.
 请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）

 给定一个int x，请返回交换后的数int。

 测试样例：
 10
 返回：5
 */

public class Exchange {
    public int exchangeOddEven(int x) {
        // write code here
        int odd = 0x55555555;
        int even =0xaaaaaaaa;
        return ((x&odd)<<1)^((x&even)>>1);
    }
}
