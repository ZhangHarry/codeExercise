package Algorithm.ProgrammerInterview;

import java.util.HashMap;

/**
 * Created by zhanghr on 2018/7/24.
 在二维平面上，有一些点，请找出经过点数最多的那条线。

 给定一个点集vector<point>p和点集的大小n,没有两个点的横坐标相等的情况,请返回一个vector<double>，代表经过点数最多的那条直线的斜率和截距。</double></point>
 */


public class DenseLine {
    public double[] getLine(Point[] p, int n) {
        // write code here
        Sol res = new Sol(0,0,0);
        for (int i=0; i<n; i++){
            HashMap<String, Sol> map = new HashMap<>();
            Point cur = p[i];
            for (int j=i+1;j<n;j++){
                Point next = p[j];
                int deltax = cur.x-next.x;
                int deltay = cur.y-next.y;
                int factor = getMaxCommonFactor(Math.abs(deltax), Math.abs(deltay));
                String key = deltax/factor+","+deltay/factor;
                if (map.containsKey(key)){
                    Sol tmp = map.get(key);
                    tmp.number++;
                    if (tmp.number > res.number)
                        res = tmp;
                }
                else{
                    double a = (cur.y-next.y)*1.0/(cur.x-next.x);
                    double b = next.y-a*next.x;
                    Sol tmp = new Sol(a,b,1);
                    map.put(key, tmp);
                    if (tmp.number > res.number)
                        res = tmp;
                }
            }
        }
        double[] d = new double[2];
        d[0] = res.a;
        d[1] = res.b;
        return d;
    }

    public int getMaxCommonFactor(int x, int y){
        if (x<y){
            x = x^y;
            y = x^y;
            x = x^y;
        }
        while (y%x != 0){
            int tmp = x;
            x = y%x;
            y = tmp;
        }
        return x;
    }
}

class Sol{
    double a,b;
    int number = 0;
    public Sol(double a, double b, int number){
        this.a = a;
        this.b = b;
        this.number = number;
    }
}
