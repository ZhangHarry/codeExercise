package company; /**
 * 举例：
 输入：
 4
 3
 1,4
 2,3
 7,3
 输出：yes

 输入：n(代表有n个组）
 m(m条约束关系），接下来会有m行
 a,b(代表a，b两位客服标号不能同时上班)
 输出：判断有没有可行方案：如果不可行输出no；如果可行输出yes
 * Created by zhanghr on 2018/5/11.
 */
import java.util.*;
public class Ali2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        boolean[][] matrix = new boolean[n+1][n+1];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        Integer[] result = new Integer[n+1];
        for (int i=0; i<m; i++){
            String s = sc.nextLine();
            String[] cons = s.split(",");
            Integer a = Integer.parseInt(cons[0]);
            Integer b = Integer.parseInt(cons[1]);
            if (a > b) {
                if (!map.containsKey(a)) {
                    map.put(a, new HashSet<>());
                }
                map.get(a).add(b);
            }else {
                if (!map.containsKey(b)) {
                    map.put(b, new HashSet<>());
                }
                map.get(b).add(a);
            }
        }
        boolean rl = getResult(result, map, 1, 1);
        if (rl)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    private static boolean getResult(Integer[] result, HashMap<Integer, HashSet<Integer>> map, Integer r, int index) {
        if (index == result.length){
            return true;
        }else{
            if (isValid(result, map.get(r))){
                result[index] = r;
                int nr = (index+1)*2-1;
                boolean bl = getResult(result, map, nr, index+1);
                if (!bl)
                    result[index] = 0;
                return bl;
            }else if (r == index*2){
                result[index] = 0;
                return false;
            }
            else {
                return getResult(result, map, r + 1, index);
            }
        }
    }

    private static boolean isValid(Integer[] result, HashSet<Integer> enermy){
        if (enermy == null || enermy.size() == 0)
            return true;
        for (Integer i : enermy){
            int index = (i+1)/2;
            if (result[index] == i)
                return false;
        }
        return true;
    }

}
