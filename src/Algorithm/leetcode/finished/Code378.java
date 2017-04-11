package Algorithm.leetcode.finished;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * Created by zhanghr on 2016/12/15.
 */
public class Code378 {

    /**
     * 85 / 85 test cases passed.
     * Status: Accepted
     * Runtime: 322 ms
     * beat 0.72%
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows == 1)
            return matrix[0][k-1];
        else if (columns == 1)
            return matrix[k-1][0];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            int index = Math.min(columns, (k - 1) / (i + 1));
            list = merge(list, k, matrix, i, index);
        }
        if (list.size() <= k){
            int result = list.size()< k? Integer.MAX_VALUE : list.get(list.size()-1);
            for (int i = 0; i < rows; i++) {
                int index = Math.min(columns, (k - 1) / (i + 1));
                if (index != columns)
                    result = Math.min(result, matrix[i][index]);
            }
            return result;
        }
        return list.get(k-1);
    }

    /**
     *
     * @param list
     * @param array
     * @param index exclude
     * @return
     */
    private List<Integer> merge(List<Integer> list,int k, int[] array, int index) {
        List<Integer> merged = new LinkedList<>();
        int start = 0;
        while (list.size()>0 && start<index){
            if (list.get(0) > array[start]){
                merged.add(array[start]);
                start++;
            }else {
                merged.add(list.get(0));
                list.remove(0);
            }
            if (merged.size()== k)
                return merged;
        }
        if (list.size() > 0)
            merged.addAll(list);
        else{
            for (; start < index; start++) {
                merged.add(array[start]);
                if (merged.size()== k)
                    return merged;
            }
        }
        return merged;
    }


    private List<Integer> merge(List<Integer> list,int k, int[][] matrix, int i, int index) {
        int start = 0;
        int listStr =0;
        int[] array = matrix[i];
        boolean reIndex = true;
        while (listStr < list.size() && start<index){
            if (list.get(listStr) >= array[start]){
                list.add(listStr, array[start]);
                listStr++;
                start++;
                reIndex = true;
                if (list.size() == k+1)
                    list.remove(k);
            }else {
                if (list.size() == k && array[start] >= list.get(k-1))
                    return list;
                else {
                    if (reIndex){
                        listStr = start == 0?list.indexOf(matrix[i-1][start]):
                                Math.max(list.indexOf(array[start - 1]), list.indexOf(matrix[i-1][start]));
                        reIndex = false;
                    }
                }
                listStr++;
            }
        }
        if (list.size() < k){
            for (; start < index; start++) {
                list.add(array[start]);
                if (list.size()== k)
                    return list;
            }
        }
        return list;
    }

    public static void main(String[] args){
        Code378 obj = new Code378();
        int[][] matrix = new int[][]{
                new int[]{1,5,9},
                new int[]{10,11,13},
                new int[]{12,13,15}};
        System.out.println(obj.kthSmallest(matrix, 8));
        System.out.println(obj.kthSmallest(matrix, 5));
    }
}
