package company.wangyihulianwnag;

/**
 * Created by zhanghr on 2018/9/8.
 */
import java.util.*;
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] votes = new int[n];
        int[][] persons = new int[m][2];
        for (int i=0; i<m; i++){
            persons[i][0] = sc.nextInt();
            persons[i][1] = sc.nextInt();
            votes[persons[i][0]]++;
        }
        int max = votes[0];
        boolean ifMax = true;
        for (int i=1; i<n; i++){
            if (max <= votes[i]){
                ifMax = false;
                break;
            }
        }
        if (!ifMax)
            System.out.println(0);
        else
            System.out.println(6);
    }
}
