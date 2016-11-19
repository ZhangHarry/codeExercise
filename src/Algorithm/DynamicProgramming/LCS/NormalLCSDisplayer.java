package Algorithm.DynamicProgramming.LCS;

import java.util.List;

/**
 * Created by zhanghr on 2016/11/20.
 */
public class NormalLCSDisplayer implements LCSDisplayer{
    public void showlcsArray(Grid[][] lcsArray, List list1, List list2) {
        System.out.print("\t\t");
        for (int j = 0; j < list2.size(); j++) {
            System.out.print(list2.get(j)+"\t");
        }
        System.out.println();
        for (int i = 0; i < lcsArray.length ; i++) {
            if ( i>=1)
                System.out.print(list1.get(i-1)+"\t");
            else
                System.out.print("\t");
            for (int j = 0; j < lcsArray[0].length; j++) {
                System.out.print(lcsArray[i][j].getSymbol()+lcsArray[i][j].getLength()+"\t");
            }
            System.out.println();
        }
    }

    @Override
    public void showlcs(Grid[][] lcsArray, List list1, List list2) {
        StringBuffer sb1 = new StringBuffer(), sb2 = new StringBuffer(), sb3 = new StringBuffer();
        int i = list1.size(), j= list2.size();
        while (i>0 && j>0){
            Grid grid = lcsArray[i][j];
            if (grid.getSymbol().compareTo("¨I") == 0){
                i--;j--;
                sb1.insert(0, "\t"+i);
                sb2.insert(0, "\t"+j);
                sb3.insert(0, "\t"+list1.get(i));
            }else if (grid.getSymbol().compareTo("¡ü") == 0) {
                i--;
            }else  if (grid.getSymbol().compareTo("¡û") == 0) {
                j--;
            }else
                j--;
        }
        System.out.println("list1 :"+sb1.toString());
        System.out.println("list2 :"+sb2.toString());
        System.out.println("cl :"+sb3.toString());
    }
}
