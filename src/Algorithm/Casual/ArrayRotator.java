package Algorithm.casual;

/**
 * Created by Zhanghr on 2016/4/11.
 */
public class ArrayRotator
{

    public static void rotateL(int[] array, int shift){
        rotate(array, 0, array.length-1, shift, true);
    }

    public static void rotateR(int[] array, int shift){
        rotate(array, 0, array.length-1, shift, false);
    }

    public static void rotate(int[] array, int start, int end, int shift, boolean isLeft){
        if (!isLeft){
            shift = shift%(end-start+1);
            shift = end-start+1-shift;
        }
        rotate(array, start, end, shift);
    }

    private static void rotate(int[] array, int start, int end, int shift){
        if (start >= end || shift<=0)
            return;
        shift = shift%(end-start+1);
        int index = start+shift;
        int i =0;
        while (i<shift && index+i<=end){
            swap(array, start+i, index + i);
            i++;
        }
        if (i == shift)
            rotate(array, index, end, shift);
        else
            rotate(array, start+i, end, shift-i);
    }

    private static void swap(int[] array, int start, int i) {
        int temp = array[start];
        array[start] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6,7};
        rotateL(array, 2);
        rotateR(array, 2);
        rotateL(array, 4);
        rotateR(array, 4);
        System.out.print(array);
    }
}
