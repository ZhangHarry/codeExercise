import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhanghr on 2018/7/22.
 */

public class PDD1 {
    public static void main(String[] args) {
//        while(true) {
//            Scanner in = new Scanner(System.in);
//            long n = in.nextInt();
//            String[] persons = new String[]{"Alice", "Bob", "Cathy", "Dave"};
//            int m = 0;
//            while (2 * m * (m + 1) <= n)
//                m++;
//            long rest = n - 2 * m * (m - 1);
//            int slot = (int)rest / m;
//            if (rest == 0)
//                System.out.println(persons[3]);
//            else if (rest % m == 0)
//                System.out.println(persons[slot - 1]);
//            else
//                System.out.println(persons[slot]);
//        }
        PDD1.test(1000000000-28, 1000000000);
    }

    public static void test(int start, int end){
        for (int i=start;i<=end; i++){
            int n = i;
            String[] persons = new String[]{"Alice", "Bob", "Cathy", "Dave"};
            int m = 0;
            while (2 * m * (m + 1) <= n)
                m++;
            long rest = n - 2 * m * (m - 1);
            int slot = (int)rest / m;
            if (rest == 0)
                System.out.println(persons[3]);
            else if (rest % m == 0)
                System.out.println(persons[slot - 1]);
            else
                System.out.println(persons[slot]);
        }
    }

    public static void main1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] persons = new String[]{"Alice", "Bob", "Cathy", "Dave"};
        int m = 0;
        while (4 * (Math.pow(2, m) - 1) < n)
            m++;
        m--;
        if (m == 0)
            System.out.println(persons[n - 1]);
        else {
            int rest = n - 4 * ((int) Math.pow(2, m) - 1);
            System.out.println(persons[(rest - 1) / (int) Math.pow(2, m)]);
        }
    }
}
