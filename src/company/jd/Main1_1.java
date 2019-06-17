package company.jd;

/**
 * Created by zhanghr on 2018/9/9.
 */
import java.util.*;
public class Main1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            boolean [][] edges = new boolean[n+1][n+1];
            for(int j=0;j<m;j++){
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();
                edges[v1][v2] = true;
                edges[v2][v1] = true;
            }
            System.out.println(isCG(n,m,edges));
        }

    }

    private static String isCG(int n, int m, boolean[][] edges) {
        ArrayList<List<Integer>> sets = new ArrayList<>();
        boolean[] vs = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vs[i]){
                List<Integer> s= new ArrayList<>();
                s.add(i);
                vs[i] = true;
                for(int j=i+1;j<=n;j++){
                    if(edges[i][j]==false){
                        s.add(j);
                        vs[j] = true;
                    }
                }
                sets.add(s);
            }
        }
        for(List<Integer> set:sets){
            for(int i = 0; i<set.size();i++){
                for(int j =i+1;j<set.size();j++){
                    if(edges[set.get(i)][set.get(j)]==true){
                        return "No";
                    }
                }
            }
        }

        for(int k = 0; k<sets.size();k++){
            for(int l = k+1; l<sets.size();l++){
                List<Integer> tmp1 = sets.get(k);
                List<Integer> tmp2 = sets.get(l);
                for(int i = 0; i<tmp1.size();i++){
                    for(int j =0;j<tmp2.size();j++){
                        if(edges[tmp1.get(i)][tmp2.get(j)]==false){
                            return "No";
                        }
                    }
                }
            }

        }

        return "Yes";
    }
}
