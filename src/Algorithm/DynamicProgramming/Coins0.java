package Algorithm.DynamicProgramming;

import java.util.ArrayList;

/**
 * Created by Zhanghr on 2016/4/8.
 */
public class Coins0 {
    private int[] coinType;
    private int[][] coinAssign;

    public Coins0(int[] coinType){
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
        ArrayList<int[]> lessCase = getLessCase(total);
        if (lessCase.size() == 0)
            return null;
        increaseCoinNum(lessCase, total);
        return coinAssign[total];
    }

    private ArrayList<int[]> getLessCase(int total) {
        ArrayList<int[]> lessTotal = new ArrayList<>();
        for (int coinValue : coinType){
            if (total-coinValue>=0) {
                int[] lessCase = getLeastCoinNum(total - coinValue);
                if (lessCase != null)
                    lessTotal.add(lessCase);
                else
                    coinAssign[total-coinValue][0] = 0;
            }
        }
        return lessTotal;
    }

    private void increaseCoinNum(ArrayList<int[]> leastCase, int total) {
        int[] min = min(leastCase);
        coinAssign[total][0] = 1+min[0];
        int minTotal = 0;
        for (int i=0;i<coinType.length;i++) {
            coinAssign[total][i + 1] = min[i + 1];
            minTotal+=min[i+1]*coinType[i];
        }
        int type = total-minTotal;
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
                coinAssign[i][0] = -1;
            }
        }
        else {
            System.out.println("total should be larger than 0");
            System.exit(1);
        }
    }
    public static void main(String[] args){
        int value = 11;
        Coins0 coins = new Coins0(new int[]{2,3,5});
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
            }else if (assign[0]==0){
                System.out.println(i + ":\t" + "没有合适的硬币组合");
            }else if (assign[0]==-1){
                System.out.println(i + ":\t" + "没有测试组合");
            }
        }
    }

}
