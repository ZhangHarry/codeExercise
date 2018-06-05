package Algorithm.aimAtOffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字

 数据范围：

 对于%50的数据,size<=10^4

 对于%75的数据,size<=10^5

 对于%100的数据,size<=2*10^5

 * Created by zhanghr on 2018/4/30.
 * 注意溢出，要采用long类型存储中间变量，或者中间增加时进行mod操作
 */

public class InversePairs {
    long count = 0;
    public int InversePairs(int [] array) {
        if (array.length <= 1)
            return 0;
        int[]temp = new int[array.length];
        mergeSort(array, temp, 0, array.length-1);
        return (int)(count%1000000007L);
    }

    public void mergeSort(int[] array, int[] temp, int start, int end){
        if (start >= end) {
            return ;
        }
        int median = (start + end)/2;
        mergeSort(array, temp, start, median);
        mergeSort(array, temp, median+1, end);
        merge(array,temp, start, median, median+1, end);
    }

    public void merge(int[] array, int[] temp, int s1, int e1, int s2, int e2){
        int i1 = s1, i2 = s2;
        int i = s1;
        while (i1 <= e1 && i2 <= e2){
            if (array[i1] > array[i2]){
                count += e2-i2+1;
                temp[i++] = array[i1++];
            }else{
                temp[i++] = array[i2++];
            }
        }
        while (i1 <= e1){
            temp[i++] = array[i1++];
        }
        while (i2 <= e2){
            temp[i++] = array[i2++];
        }

        i = s1;
        while (i<=e2) {
            array[i] = temp[i];
            i++;
        }
    }
}
