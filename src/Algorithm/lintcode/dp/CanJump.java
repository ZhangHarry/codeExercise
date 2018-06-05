package Algorithm.lintcode.dp;

/**
 * Created by zhanghr on 2018/5/31.
 */

public class CanJump {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if (A.length <= 1)
            return true;
        int index = A.length-1;
        while (index >= 0){
            int length = 1;
            boolean bl = false;
            while (length <= index){ //注意小于等于号而不是小于号，第一次写错了
                int tmp = index-length;
                if (A[tmp] >= length){
                    index = tmp;
                    bl = true;
                    break;
                }
                length++;
            }
            if (index == 0 && bl)
                return true;
            if (!bl)
                return false;
        }
        return false;
    }

    public static void main(String[] args){
        CanJump test = new CanJump();
        int[] array = new int[]{4,6,9,5,9,3,0};
        System.out.println(test.canJump(array));
    }
}
