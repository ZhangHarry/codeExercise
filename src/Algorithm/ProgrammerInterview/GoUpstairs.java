package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/20.
 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
 请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007

 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。

 测试样例：
 1
 返回：1
 */

public class GoUpstairs {
    // 注意溢出，每次加都要mode
    public int countWays(int n) {
        // write code here
        int[] step = new int[]{1,2,4};
        if (n <=3)
            return step[n-1];
        int result = 0;
        for (int i=4; i<=n ;i++){
            result = ((step[0]+step[1])%1000000007+step[2])%1000000007;
            step[0] = step[1];
            step[1] = step[2];
            step[2] = result;
        }

        return result;
    }
}
