package Algorithm.lintcode;

/**
 Given an unsorted integer array, find the first missing positive integer.

 Example
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Challenge
 Your algorithm should run in O(n) time and uses constant space.

 * Created by zhanghr on 2018/6/4.
 */

public class FirstMissingPositive {
    /**
     * beat 99.8%
     * 思路：第一次遍历数组，将每个元素放到它应该在的地方；第二次遍历数组，遇到的第一个位置不正确的元素，index+1就是所求
     * @param A: An array of integers
     * @return: An integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        int index = 0;
        while (index < A.length){
            if (A[index] != index+1 && A[index] >=1 && A[index]<=A.length && A[index] != A[A[index]-1]){
                swap(A, index, A[index]-1);
            }
            else
                index++;
        }
        for (int i=0; i<A.length;i++){
            if (A[i] != i+1)
                return i+1;
        }
        return A.length+1;
    }

    public void swap(int[] A, int i1, int i2){
        int tmp = A[i1];
        A[i1] = A[i2];
        A[i2] = tmp;
    }
}
