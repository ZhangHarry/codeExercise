package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/26.
 *
 我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。
 例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，槽4为蓝色)，作为玩家，你需要试图猜出颜色的组合。
 比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。要是只是猜对了颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。

 给定两个string A和guess。分别表示颜色组合，和一个猜测。请返回一个int数组，第一个元素为猜中的次数，第二个元素为伪猜中的次数。

 */

public class Result {
    public int[] calcResult(String A, String guess) {
        // write code here
        int[] res = new int[2];
        int[] numA = new int[4];
        int[] numB = new int[4];
        for (int i=0; i<A.length(); i++){
            if (A.charAt(i) == guess.charAt(i))
                res[0]++;
            else{
                add(numA, A.charAt(i));
                add(numB, guess.charAt(i));
            }
        }
        for (int i=0; i<4;i++){
            res[1] += Math.min(numA[i], numB[i]);
        }
        return res;
    }

    public void add(int[] a,char c){
        switch(c){
            case 'R':
                a[0]++;
                break;
            case 'Y':
                a[1]++;
                break;
            case 'G':
                a[2]++;
                break;
            case 'B':
                a[3]++;
                break;
            default:
                break;
        }
    }
}
