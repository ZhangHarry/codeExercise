package Algorithm.DynamicProgramming.LCS;

import java.util.List;

/**
 * Created by zhanghr on 2016/11/20.
 */
public interface LCSDisplayer  {
    void showlcsArray(Grid[][] lcsArray, List list1, List list2);
    void showlcs(Grid[][] lcsArray, List list1, List list2);
}
