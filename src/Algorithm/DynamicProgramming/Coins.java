package Algorithm.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Zhanghr on 2016/4/8.
 */
public class Coins {
    private int NONTEST = -2;
    private int NONANSWER = -1;
    private int[] coinType;
    private int[][] coinAssign;

    public Coins(int[] coinType){
        this.coinType = coinType;
    }

    public void leastCoinNum(int total){
        init(total);
        getLeastCoinNum(total);
    }

    private int[] getLeastCoinNum(int total){
        // return smaller question's answer
        if (coinAssign[total][0]>=0)
            return coinAssign[total];
        ArrayList<int[]> lessCases = getLessCases(total);
        increaseCoinNum(lessCases, total);
        return coinAssign[total];
    }

    private ArrayList<int[]> getLessCases(int total) {
        ArrayList<int[]> lessTotal = new ArrayList<>();
        for (int coinValue : coinType){
            if (total-coinValue>=0) {
                int[] lessCase = getLeastCoinNum(total - coinValue);
                if (lessCase[0] >= 0)
                    lessTotal.add(lessCase);
                else
                    coinAssign[total-coinValue][0] = NONANSWER;
            }
        }
        return lessTotal;
    }

    private void increaseCoinNum(ArrayList<int[]> lessCases, int total) {
        if (lessCases.size() == 0)
            return ;
        int[] minCase = min(lessCases);
        coinAssign[total][0] = 1+minCase[0];
        int type = total;
        for (int i=0;i<coinType.length;i++) {
            coinAssign[total][i + 1] = minCase[i + 1];
            type -= minCase[i+1]*coinType[i];
        }
        for (int i=0;i<coinType.length;i++) {
            if (type == coinType[i]) {
                coinAssign[total][i + 1] += 1;
                break;
            }
        }
    }

    private int[] min(ArrayList<int[]> leftTotal) {
        int[] least = leftTotal.get(0);
        for (int i=1;i<leftTotal.size();i++){
            if (least[0]>leftTotal.get(i)[0]) {
                least = leftTotal.get(i);
            }
        }
        return least;
    }

    private void init(int total) {
        if (total>0) {
            this.coinAssign = new int[total+1][];
            coinAssign[0] = new int[coinType.length + 1];
            for (int i=1;i<coinAssign.length;i++) {
                coinAssign[i] = new int[coinType.length + 1];
                coinAssign[i][0] = NONTEST;
            }
        }
        else {
            System.out.println("total should be larger than 0");
            System.exit(1);
        }
    }
    public static void main(String[] args){
        int value = 11;
        Coins coins = new Coins(new int[]{2,3,5});
        coins.leastCoinNum(value);
        for (int i =1;i<coins.coinAssign.length;i++) {
            int[] assign = coins.coinAssign[i];
            if (assign[0]>0) {
                System.out.print(i + ":\t" + assign[0]);
                for (int j = 0; j < coins.coinType.length; j++) {
                    int v = coins.coinType[j];
                    System.out.print("\t" + v + "(" + assign[j + 1] + "个)");
                }
                System.out.println();
            }else if (assign[0]==coins.NONANSWER){
                System.out.println(i + ":\t" + "没有合适的硬币组合");
            }else if (assign[0]==coins.NONTEST){
                System.out.println(i + ":\t" + "没有计算组合");
            }
        }
    }

}
