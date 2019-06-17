package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/8/27.

 Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

 Example:

 Input: 3
 Output: 5
 Explanation:
 Given n = 3, there are a total of 5 unique BST's:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 */

public class UniqueBinarySearchTrees96 {
    // beat 100%
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            int tmp = 0;
            for (int j=1; j<=i;j++){
                tmp += dp[j-1] * dp[i-j];
            }
            dp[i] = tmp;
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args){
        UniqueBinarySearchTrees96 test = new UniqueBinarySearchTrees96();
        System.out.println(test.numTrees(3));
    }
}
