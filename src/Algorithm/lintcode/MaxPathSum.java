package Algorithm.lintcode;

/**
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 Example
 Given the below binary tree:

 1
 / \
 2   3
 return 6.
 * Created by zhanghr on 2018/6/1.
 */

public class MaxPathSum {
    /**
     * 注意node的值可能是负数。
     * 思路很简单：按顺序遍历每个node，计算每个node的最大值，父亲节点的值由孩子节点的值决定。最值在遍历过程中存储。
     * @param root: The root of binary tree.
     * @return: An integer
     */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        visit(root);
        return max;
    }

    public int visit(TreeNode root) {
        if (root == null)
            return 0;
        int left = visit(root.left);
        int right = visit(root.right);
        int sum = root.val + (left>0?left:0) + (right>0?right:0);
        max = Math.max(sum, max);
        return root.val + Math.max(left, right);
    }
}
class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
         this.left = this.right = null;
     }
}
