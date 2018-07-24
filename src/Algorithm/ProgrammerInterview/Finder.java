package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/20.
 有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，例如，原数组为[1,2,3,4,5,6]，向左移位5个位置即变成了[6,1,2,3,4,5],现在对于移位后的数组，需要查找某个元素的位置。
 请设计一个复杂度为log级别的算法完成这个任务。

 给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。保证数组中元素互异。

 测试样例：
 [6,1,2,3,4,5],6,6
 返回：0
 */

public class Finder {
    public int findElement(int[] A, int n, int x) {
        // write code here
        return findElement(A, x,0, n-1);
    }

    public int findElement(int[] A, int x,int start,int end) {
        // write code here
        while (start <= end){
            int mid = start+(end-start)/2;
            if (A[start] == x)
                return start;
            if (A[end] == x)
                return end;
            if (A[mid] == x)
                return mid;
            if (start+1>=end)
                return -1;
            if (A[start] < A[end]){
                if (A[mid] > x)
                    end = mid;
                else
                    start = mid;
            }else{
                if (A[start] < x){
                    if (A[mid] > x)
                        end = mid;
                    else
                        end--;
                }else{
                    start++;
                }
            }
        }
        return -1;
    }
}
