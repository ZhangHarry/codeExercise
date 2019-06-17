package company.Indeed;

/**
 * Created by zhanghr on 2018/9/14.
 */
import java.util.*;
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] data = new int[m][3];
        for (int i = 0; i < m; i++) {
            data[i][0] = scanner.nextInt();
            data[i][1] = scanner.nextInt();
            data[i][2] = scanner.nextInt();
        }

        keys.add(1);
        rooms.add(1);
        walk(data, 1);
        System.out.println(rooms.size());
    }

    private static Set<Integer> keys = new HashSet<Integer>();
    private static Set<Integer> rooms = new HashSet<Integer>();

    public static void walk(int[][] data, int current) {
        boolean keyChanged = true;
        while (keyChanged) {
            int size = keys.size();

            walkWithKeys(data, current);

            if (keys.size() == size)
                keyChanged = false;
        }
    }

    public static void walkWithKeys(int[][] data, int current) {
        Stack<Integer> nexts = new Stack<Integer>();
        nexts.add(current);
        while (!nexts.empty()) {
            int next = nexts.pop();
            for (int i = 0; i < data.length; i++) {
                int[] info = data[i];
                if (info[0] == next && keys.contains(info[2])) {
                    if (!rooms.contains(info[1]))
                        nexts.push(info[1]);

                    rooms.add(info[1]);
                    keys.add(info[1]);
                }

                if (info[1] == next && keys.contains(info[2])) {
                    if (!rooms.contains(info[0]))
                        nexts.push(info[0]);

                    rooms.add(info[0]);
                    keys.add(info[0]);
                }
            }
        }
    }
}
