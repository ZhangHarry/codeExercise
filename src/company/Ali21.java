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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Ali21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        boolean[][] matrix = new boolean[2*n+1][2*n+1];
        Integer[] result = new Integer[n+1];
        for (int i=0; i<m; i++){
            String s = sc.nextLine();
            String[] cons = s.split(",");
            Integer a = Integer.parseInt(cons[0]);
            Integer b = Integer.parseInt(cons[1]);
            matrix[a][b] = matrix[b][a] = true;
        }
        boolean rl = getResult(result, matrix, 1, 1);
        if (rl)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    private static boolean getResult(Integer[] result, boolean[][] matrix, Integer r, int index) {
        if (index == result.length){
            return true;
        }else{
            if (isValid(result, matrix, r)){
                result[index] = r;
                int nr = (index+1)*2-1;
                boolean bl = getResult(result, matrix, nr, index+1);
                if (!bl)
                    result[index] = 0;
                return bl;
            }else if (r == index*2){
                result[index] = 0;
                return false;
            }
            else {
                return getResult(result, matrix, r + 1, index);
            }
        }
    }

    private static boolean isValid(Integer[] result, boolean[][] matrix, Integer r){
        int index = 1;
        while (result[index] != 0){
            if (matrix[result[index]][r])
                return false;
            index++;
        }
        return true;
    }

}
