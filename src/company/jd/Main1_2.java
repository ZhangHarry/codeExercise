package company.jd;

/**
 * Created by zhanghr on 2018/9/9.
 */
import java.util.*;
public class Main1_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            if (N == 1 || M == 0)
                System.out.println("Yes");
            else {
                boolean isConnect = true;
                boolean initial = true;
                int begin = in.nextInt();
                Set<Integer> joinset = new HashSet<>();
                Set<Integer> distinctset = new HashSet<>();
                joinset.add(in.nextInt());
                for (int j = 1; j < M; j++) {
                    int tempBegin = in.nextInt();
                    int tempEnd = in.nextInt();
                    if (tempBegin == begin) {
                        joinset.add(tempEnd);
                    }
                    else {
                        if (initial) {
                            initial = false;
                            for (int k = 1; k <= N; k++) {
                                if (k != begin && !joinset.contains(k))
                                    distinctset.add(k);
                            }
                        }
                        int newj = j + 1;
                        if (distinctset.contains(tempBegin) && distinctset.contains(tempEnd)) {
                            isConnect = false;
                            while (newj < M) {
                                in.nextInt();
                                in.nextInt();
                                newj++;
                            }
                            break;
                        }
                    }
                }
                if (isConnect)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }

    public static void test(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            if (N == 1 || M == 0)
                System.out.println("Yes");
            else {
                boolean isConnect = true;
                boolean initial = true;
                int begin = in.nextInt();
                Set<Integer> joinset = new HashSet<>();
                Set<Integer> distinctset = new HashSet<>();
                joinset.add(in.nextInt());
                for (int j = 1; j < M; j++) {
                    int tempBegin = in.nextInt();
                    int tempEnd = in.nextInt();
                    if (tempBegin == begin) {
                        joinset.add(tempEnd);
                    }
                    else {
                        if (initial) {
                            initial = false;
                            for (int k = 1; k <= N; k++) {
                                if (k != begin && !joinset.contains(k))
                                    distinctset.add(k);
                            }
                        }
                        int newj = j + 1;
                        if (distinctset.contains(tempBegin) && distinctset.contains(tempEnd)) {
                            isConnect = false;
                            while (newj < M) {
                                in.nextInt();
                                in.nextInt();
                                newj++;
                            }
                            break;
                        }
                    }
                }
                if (isConnect)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
