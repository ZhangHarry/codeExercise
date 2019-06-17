package company.jd;

import java.util.*;

/**
 * Created by zhanghr on 2018/9/9.
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0; i<T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            LinkedList<Graph> graphs = new LinkedList<>();
            for (int j=0; j<M; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graphs.add(new Graph(a,b));
            }
            if (ifValid(graphs)){
                System.out.println("Yes");
            }else
                System.out.println("No");
        }
    }

    public static boolean ifValid(LinkedList<Graph> points){
        Collections.sort(points);
        List<Graph> distinctG = new LinkedList<>();
        while (!points.isEmpty()){
            Graph cur = points.poll();
            distinctG.add(cur);
            Iterator<Graph> itr = points.iterator();
            while (itr.hasNext()){
                Graph g = itr.next();
                if (cur.merge(g)){
                    itr.remove();
                }
            }
        }
        if (distinctG.size() <= 1)
            return false;
        else{
            int size = distinctG.get(0).count;
            for (Graph g : distinctG){
                if (g.count != size)
                    return false;
            }
            return true;
        }
    }
}

class Graph implements Comparable<Graph>{
    int a,b;
    int count=0;
    public Graph(int a, int b){
        if (a > b){
            this.a = b;
            this.b = a;
        }else{
            this.a = a;
            this.b = b;
        }
    }
    public boolean merge(Graph g){
        if (g.a == this.b) {
            this.b = g.b;
            count++;
            return true;
        }
        else if (g.b == this.a) {
            this.a = g.a;
            count++;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Graph o) {
        return this.a-o.a;
    }
}
