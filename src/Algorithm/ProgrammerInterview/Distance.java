package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/20.
 */

public class Distance {
    public int getDistance(String[] article, int n, String x, String y) {
        // write code here
        int min = Integer.MAX_VALUE;
        String cur = "";
        int i =0;
        while (!article[i].equals(x) && !article[i].equals(y)){
            i++;
        }
        cur = article[i];
        int index = i;
        for (; i<n; i++){
            if (article[i].equals(x)){
                if (cur.equals(y)){
                    min = Math.min(min,i-index);
                    cur = x;
                }
                index = i;
            }else if (article[i].equals(y)){
                if (cur.equals(x)){
                    min = Math.min(min,i-index);
                    cur = y;
                }
                index = i;
            }
        }
        return min;
    }
}
