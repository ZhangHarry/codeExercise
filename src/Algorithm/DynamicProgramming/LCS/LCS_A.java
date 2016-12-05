package Algorithm.dynamicProgramming.LCS;

import java.util.List;

/**
 * Created by zhanghr on 2016/11/19.
 */
public class LCS_A<T extends Comparable> {
    private Grid[][] lcsArray = null;
    private List<T> list1, list2;
    private LCSDisplayer displayer;

    public LCS_A(List<T> list1, List<T> list2, LCSDisplayer displayer){
        this.list1 = list1;
        this.list2 = list2;
        this.displayer = displayer;
    }

    public void showlcsArray() {
        if (lcsArray == null)
            getLCS();
        displayer.showlcsArray(lcsArray, list1, list2);
    }

    public void showlcs() {
        if (lcsArray == null)
            getLCS();
        displayer.showlcs(lcsArray, list1, list2);
    }

    public Grid[][] getLCS(){
        if (lcsArray != null)
            return lcsArray;
        initLCSArray();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if ((list1.get(i)).compareTo(list2.get(j)) == 0) {
                    Grid grid = new Grid();
                    grid.setLength(1+getLcs(i - 1, j - 1).getLength());
                    grid.setSymbol("¨I");
                    lcsArray[i + 1][j + 1] = grid;
                }
                else {
                    lcsArray[i + 1][j + 1] = getLcs(i, j);
                }
            }
        }
        return lcsArray;
    }

    private Grid getLcs(int i, int j) {
        if (lcsArray[i+1][j+1] == null) {
            Grid top = getLcs(i - 1, j);
            Grid left = getLcs(i, j - 1);
            Grid grid = new Grid();
            Grid max = max(top, left);
            grid.setLength(max.getLength());
            if (max == top)
                grid.setSymbol("¡ü");
            else
                grid.setSymbol("¡û");

            return grid;
        }
        else
            return lcsArray[i+1][j+1];
    }

    private Grid max(Grid g1, Grid g2) {
        if (g1.compareTo(g2) > 0)
            return g1;
        else
            return g2;
    }

    private void initLCSArray() {
        lcsArray = new Grid[list1.size()+1][list2.size()+1];
        for (int j = 0; j < list2.size() + 1; j++) {
            lcsArray[0][j] = new Grid();
        }
        for (int i = 0; i < list1.size() + 1; i++) {
            lcsArray[i][0] = new Grid();
        }
        for (int i = 1; i < list1.size() + 1; i++) {
            for (int j = 1; j < list2.size() + 1; j++) {
                lcsArray[i][j] = null;
            }
        }
    }

    public Grid[][] getLcsArray() {
        if (lcsArray == null)
            getLCS();
        return lcsArray;
    }

    public void setList1(List<T> list1) {
        init();
        this.list1 = list1;
    }

    private void init() {
        lcsArray = null;
    }

    public void setList2(List<T> list2) {
        init();
        this.list2 = list2;
    }
}

class Grid implements Comparable<Grid>{
    private int length;
    private String symbol = "";

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compareTo(Grid o) {
        return this.length-o.length;
    }
}
