package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/25.
 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。

 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
 */

public class LCA {
    // 注意：需要保证a、b处于同一层
    public int getLCA(int a, int b) {
        // write code here
        if (a > b){
            a = a^b;
            b = a^b;
            a= a^b;
        }
        int aL = getLevel(a);
        int bL = getLevel(b);
        while (aL != bL){
            b = b/2;
            bL--;
        }
        if (b/2==a)
            return a;
        if (a/2 == b)
            return b;
        while (a != b){
            a/=2;
            b/=2;
        }
        return a;
    }

    public int getLevel(int i){
        int level = 0;
        while (Math.pow(2, level)-1 < i)
            level++;
        return level;
    }
}
