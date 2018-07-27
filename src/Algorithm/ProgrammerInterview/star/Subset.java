package Algorithm.ProgrammerInterview.star;

/**
 * Created by zhanghr on 2018/7/27.
 请编写一个方法，返回某集合的所有非空子集。

 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
 保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序，见样例。

 测试样例：
 [123,456,789]
 返回：{[789,456,123],[789,456],[789,123],[789],[456 123],[456],[123]}
 */

import java.util.*;

public class Subset {
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A.length==0)
            return res;
        Arrays.sort(A);
        for (int i=0, j=n-1; i<j;i++, j--){
            A[i] = A[i] ^A[j];
            A[j] = A[i] ^A[j];
            A[i] = A[i] ^A[j];
        }
        res.add(new ArrayList<Integer>());
        for (int i : A){
            ArrayList<ArrayList<Integer>> nres = new ArrayList<>();
            int size = res.size();
            for (int j=size-1; j>=0; j--){
                ArrayList<Integer> list = res.get(j);
                ArrayList<Integer> nList = new ArrayList<>(list);
                nList.add(i);
                nres.add(0, list);
                nres.add(0, nList);
            }
            res = nres;
        }
        res.remove(res.size()-1);
        return res;
    }
}
