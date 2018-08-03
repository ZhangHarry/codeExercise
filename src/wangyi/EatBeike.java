package wangyi;

/**
 * Created by zhanghr on 2018/8/3.

 链接：https://www.nowcoder.com/questionTerminal/5ee8df898312465a95553d82ad8898c3
 来源：牛客网

 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。
 对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
 贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
 输入描述:
 输入一个初始位置x_0,范围在1到1,000,000,006
 */
import java.util.*;
public class EatBeike {
    // 数学题：注意4 * x + 3与8 * x + 7的关系。设h(x)=2x+1，f(x)=4x+3=h(h(x)), g(x)=8x+7=h(h(h(x)))，都是h的符合函数。
    // 下面的答案直接统计经过多少次h(x)得到答案，然后分解成若干个3与2的和，3的个数加上2的个数最小。
    // 其实还可以加速一下：注意到f是2次，g是3次，2次g等于3次f/6次h，所以可以分三种情况讨论：先让x经过0/1/2次f，然后统计经过多少次g（相当于一次做了3次h）。
    public void solution(){
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int count = 0;
        while (x != 0 && count < 300000){
            x = ((x<<1)+1) % 1000000007;
            count++;
        }
        if (x != 0)
            System.out.println(-1);
        else{
            if (count%3 == 1){
                int res = count/3-1 +2;
                System.out.println(res);
            }else{
                int res = count/3 +(count%3)/2;
                System.out.println(res);
            }

        }
    }

}
