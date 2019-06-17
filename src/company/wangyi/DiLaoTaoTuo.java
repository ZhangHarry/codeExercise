package company.wangyi;

/**
 * Created by zhanghr on 2018/8/6.

 题目描述
 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，和一般的游戏所不同的是，
 他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，
 他需要多少步才可以离开这个地牢。

 输入描述:
 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。接下来的 n 行，每行 m 个字符，
 描述地牢，地牢将至少包含两个 '.'。接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），出发位置一定是 '.'）。
 之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）

 输出描述:
 输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，
 地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。

 示例1
 输入
 3 3
 ...
 ...
 ...
 0 1
 4
 1 0
 0 1
 -1 0
 0 -1
 输出 3
 */
import java.util.*;
public class DiLaoTaoTuo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int m = Integer.parseInt(tmp[0]);
        int n = Integer.parseInt(tmp[1]);
        char[][] matrix = new char[m][n];
        for (int i=0; i<m; i++){
            String line = sc.nextLine();
            char[] str = line.toCharArray();
            for (int j=0; j<n; j++)
                matrix[i][j] = str[j];
        }
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int k = sc.nextInt();
        int[][] steps = new int[k][2];
        for (int i=0; i<k; i++){
            steps[i][0] = sc.nextInt();
            steps[i][1] = sc.nextInt();
        }
        setDistance(matrix, steps, k, startX, startY);
        int res = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j] == '.'){
                    System.out.println(-1);
                    return;
                }else if (matrix[i][j] != 'X'){
                    res = Math.max(res, matrix[i][j]-'0');
                }
            }
        }
        System.out.println(res);
    }

    public static void setDistance(char[][]matrix, int[][] steps, int k, int startX, int startY){
        int i =0;
        int m = matrix.length, n = matrix[0].length;
        LinkedList<Integer> xlist = new LinkedList<>();
        LinkedList<Integer> ylist = new LinkedList<>();
        int layer = 1;
        xlist.add(startX);
        ylist.add(startY);
        matrix[startX][startY] = '0';
        while (!xlist.isEmpty()){
            i++;
            int nlayer = 0;
            while (layer > 0){
                layer--;
                int x = xlist.poll();
                int y = ylist.poll();
                for (int[] step : steps){
                    int nx = x +step[0];
                    int ny = y +step[1];
                    if (nx >=0 && nx < m && ny >=0 && ny < n && matrix[nx][ny] == '.'){
                        xlist.add(nx);
                        ylist.add(ny);
                        nlayer++;
                        matrix[nx][ny] = (char)('0'+i);
                    }
                }
            }
            layer = nlayer;
        }
    }
}
