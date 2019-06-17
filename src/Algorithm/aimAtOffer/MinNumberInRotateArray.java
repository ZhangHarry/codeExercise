package Algorithm.aimAtOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author zhanghr
 *
 */
public class MinNumberInRotateArray {
	public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length-1;
        while (array[left] >= array[right]) {
            int mid = (left+right)/2;
            if (array[mid] >= array[right]){
                left = mid;
            }else {
                right = mid;
            }
            if (right-left==1)
                return array[right];
        }
        return array[right];
    }

    public int minNumberInRotateArray1(int [] array) {
        if (array.length==0)
            return 0;
        int start =0, end = array.length-1;
        while (start < end){
            if (array[start] <array[end])
                return array[start];
            else if (array[start] > array[end]){
                int mid = start+(end-start)/2;
                if (mid == start)
                    return Math.min(array[start], array[end]);
                else if (array[mid] > array[start])
                    start = mid;
                else if (array[mid] < array[start])
                    end = mid;
                else
                    start = mid;
            }else
                end = end-1;
        }
        return array[start];
    }

    public static void main(String[] args){
        MinNumberInRotateArray test = new MinNumberInRotateArray();
        int[] array = new int[]{6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(test.minNumberInRotateArray1(array));
    }
}
