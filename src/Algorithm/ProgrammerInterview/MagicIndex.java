package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/20.

 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，
 编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。

 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。

 测试样例：
 [1,2,3,4,5]
 返回：false

 */

public class MagicIndex {
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        return findMagicIndex(A, 0, n-1);
    }

    public boolean findMagicIndex(int[] A, int start, int end) {
        while (start<=end){
            int mid = start + (end-start)/2;
            if (A[start]==start || A[end] == end || A[mid] == mid)
                return true;
            if (start+1>=end)
                return false;
            if (A[mid] > mid)
                end = mid;
            else if (A[mid] < mid)
                start =mid;
        }
        return false;
    }
}
