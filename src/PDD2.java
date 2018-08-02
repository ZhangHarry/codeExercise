/**
 * Created by zhanghr on 2018/7/22.
 */
import java.util.*;
public class PDD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int players = in.nextInt();
        int votes = in.nextInt();

        int[][] rate = new int[players][votes];
        for(int i = 0; i < votes; i++){
            String vote = in.next();
            char[] tmp = vote.toCharArray();
            for(int j = 0; j < players; j++){
                rate[j][i] = tmp[j]-'a';
            }
        }

        for(int i = 0; i < players; i++){
            Arrays.sort(rate[i]);
        }

        int tmp = 0;
        int king = 0;
        for(int i = 1; i < players; i++){
            int betterPlayer = getBetter(tmp, i, rate);
            if(betterPlayer == -1){
                king = -1;
            }else{
                if( tmp!=betterPlayer){
                    tmp = betterPlayer;
                    king = tmp;
                }
            }
        }
        System.out.println(king);
    }

    public static int getBetter(int player1,int player2,int[][] rate) {
        int p1 = 0;
        int p2 = 0;
        int votes = rate[0].length;
        int[] v1 =rate[player1];
        int[] v2 = rate[player2];
        for(int i = 0; i < votes; i++){
            if(v1[i]<v2[i]){
                p2++;
            }else if(v1[i]>v2[i]){
                p1++;
            }
        }
        return p1>p2 ? player2 : p2>p1 ? player2 : -1;
    }

}
