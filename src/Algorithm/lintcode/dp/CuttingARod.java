package Algorithm.lintcode.dp;

/**
 Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 For example, if length of the rod is 8 and the values of different pieces are given as following,
 then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

 Example
 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 1   5   8   9  10  17  17  20
 Given price = [1, 5, 8, 9, 10, 17, 17, 20], n = 8
 Return 22 // by cutting in two pieces of lengths 2 and 6

 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 3   5   8   9  10  17  17  20
 Given price = [3, 5, 8, 9, 10, 17, 17, 20], n = 8
 Return 24 // by cutting in eight pieces of length 1

 * Created by zhanghr on 2018/6/3.
 */

public class CuttingARod {
    /**
     * beat 95.26%
     * @param prices: the prices
     * @param n: the length of rod
     * @return: the max value
     */
    int[] record;
    public int cutting(int[] prices, int n) {
        // Write your code here
        if (n ==0)
            return 0;
        record = new int[n+1];
        record[1] = prices[0];
        return record(prices, n);
    }

    public int record(int[] prices, int n){
        if (record[n] > 0)
            return record[n];
        int max = prices[n-1];
        for (int i=1; i<=n/2; i++){
            int left = record(prices, i);
            int right = record(prices, n-i);
            max = Math.max(max, left+right);
        }
        record[n] = max;
        return max;
    }
}
