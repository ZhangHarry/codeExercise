package Algorithm.aimAtOffer;

import java.util.ArrayList;

/**
 * Created by zhanghr on 2018/4/23.
 */

public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // handle special
        if (matrix == null || matrix.length==0 || matrix[0].length == 0)
            return list;

        // handle normal situation
        int[][] directions =new int[][]{new int[]{0,1}, new int[]{1,0},
                new int[]{0,-1}, new int[]{-1, 0}};
        int direction = 0;
        int lowBound = 0, upperBound = matrix.length-1, leftBound =0,rightBound = matrix[0].length-1;
        int i=0, j=0;
        while (true){
            if (lowBound > upperBound || leftBound > rightBound)
                break;
            list.add(matrix[i][j]);

            int ti =i + directions[direction%4][0];
            int tj =j + directions[direction%4][1];

            if (ti < lowBound){
                direction++;
                leftBound++;
            }else if (ti > upperBound){
                direction++;
                rightBound--;
            }else if (tj < leftBound){
                direction++;
                upperBound--;
            }else if (tj > rightBound){
                direction++;
                lowBound++;
            }
            i += directions[direction%4][0];
            j += directions[direction%4][1];
        }

        return list;
    }

    public static void main(String[] args){
        PrintMatrix test = new PrintMatrix();
        test.printMatrix(new int[][]{new int[]{1}, new int[]{2}, new int[]{3}, new int[]{4}, new int[]{5}});
    }
}
