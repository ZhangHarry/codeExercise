package Algorithm.aimAtOffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author zhanghr
 *
 */
public class FindTargetInTwoDimArray {
	public boolean Find(int target, int [][] array) {
        int rows = array.length, columns = array[0].length;
        int row = 0, column = columns-1;
        while (row >=0 && row < rows && column >= 0){
            if (array[row][column]==target)
                return true;
            else if (array[row][column]<target)
                row++;
            else
                column--;
        }
        return false;
    }
}
