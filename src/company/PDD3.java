package company; /**
 * Created by zhanghr on 2018/7/22.
 */
import java.util.*;
public class PDD3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String[] s = in.nextLine().split(" ");
        for (String item : s) {
            list.add(Integer.parseInt(item));
        }
        Integer[] items = list.toArray(new Integer[]{});
        Arrays.sort(items);
        int cars = 0;
        boolean[] visited = new boolean[items.length];
        for(int i = items.length-1; i >=0; i--){
            if(!visited[i]){
                int rest = 300-items[i];
                cars++;
                visited[i]=true;
                for(int j = i-1; j >=0; j--){
                    if(!visited[j] && items[j]<=rest){
                        rest =rest-items[j];
                        visited[j]=true;
                    }
                }

            }
        }
        System.out.println(cars);
    }
}
