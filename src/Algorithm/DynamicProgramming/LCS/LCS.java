package Algorithm.DynamicProgramming.LCS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhanghr on 2016/11/19.
 */
public class LCS<T extends Comparable> {
    private int[][] lcsArray = null;

    public static void showlcsArray(int[][] lcsAray, List list1, List list2) {
        System.out.print("\t\t");
        for (int j = 0; j < list2.size(); j++) {
            System.out.print(list2.get(j)+"\t");
        }
        System.out.println();
        for (int i = 0; i < lcsAray.length ; i++) {
            if ( i>=1)
                System.out.print(list1.get(i-1)+"\t");
            else
                System.out.print("\t");
            for (int j = 0; j < lcsAray[0].length; j++) {
                System.out.print(lcsAray[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public int[][] getLCS(List<T> c1, List<T> c2){
        initLCSArray(c1, c2);
        for (int i = 0; i < c1.size(); i++) {
            for (int j = 0; j < c2.size(); j++) {
                if ((c1.get(i)).compareTo(c2.get(j)) == 0)
                    lcsArray[i+1][j+1] = 1+getLcs(c1, c2, i-1, j-1);
                else
                    lcsArray[i+1][j+1] = getLcs(c1, c2, i, j);
            }
        }
        return lcsArray;
    }

    private int getLcs(List<T> c1, List<T> c2, int i, int j) {
        if (lcsArray[i+1][j+1] < 0)
            return max(getLcs(c1, c2, i - 1, j), getLcs(c1, c2, i, j - 1));
        else
            return lcsArray[i+1][j+1];
    }

    private int max(int num1, int num2) {
        return Math.max(num1, num2);
    }

    private void initLCSArray(Collection<T> c1, Collection<T> c2) {
        lcsArray = new int[c1.size()+1][c2.size()+1];
        for (int i = 1; i < c1.size() + 1; i++) {
            for (int j = 1; j < c2.size() + 1; j++) {
                lcsArray[i][j] = -1;
            }
        }
    }
}
