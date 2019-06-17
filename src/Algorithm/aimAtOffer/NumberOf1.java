package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/9/5.
 */

public class NumberOf1 {
    public int NumberOf1(int n) {
        int res=0;
        if (n<0){
            res++;
            n = n&Integer.MAX_VALUE;
        }
        while (n>0){
            res++;
            n = (n-1) & n;
        }
        return res;
    }
}
