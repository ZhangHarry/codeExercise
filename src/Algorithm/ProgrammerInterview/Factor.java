package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/20.
 请设计一个算法，计算n的阶乘有多少个尾随零。

 给定一个int n，请返回n的阶乘的尾零个数。保证n为正整数。

 测试样例：
 5
 返回：1
 */

public class Factor {

    // 统计每个数的因子种5的个数
    public int getFactorSuffixZero(int n) {
        // write code here
        if (n<0)
            return 0;
        if (n==0)
            return 1;
        int count = 0;
        int cur = 5;
        while (cur <= n){
            count += get5(cur);
            cur += 5;
        }
        return count;
    }

    public int get5(int r){
        int count = 0;
        while (r>0 && r%5==0){
            count++;
            r = r/5;
        }
        return count;
    }
}
