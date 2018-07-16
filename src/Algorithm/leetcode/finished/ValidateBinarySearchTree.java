package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/12.

 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:

 Input:
 2
 / \
 1   3
 Output: true
 Example 2:

 5
 / \
 1   4
 / \
 3   6
 Output: false
 Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 is 5 but its right child's value is 4.

 */

public class ValidateBinarySearchTree {
    // beat 100%
    // 思路：问题的难点在于要求左右子树全部元素都满足大小关系，所以isValidBST(root.left) && isValidBST(root.right)不是这么容易实现，因为我们需要存储祖先
    //       这里的做法是注意到对于二叉平衡树，中序遍历我们将得到一个排序好的数组。
    //       一个最简单的做法是按照中序遍历得到所有元素，然后检查是否符合从小到大顺序。实际上我们只需要相邻两个元素，所以只需要保存上一个元素，不需要保存所有元素。
    public boolean isValidBST(TreeNode root) {
        return recur(root);
    }
    Integer cur = null;
    public boolean recur(TreeNode root) {
        if (root == null)
            return true;
        if (!recur(root.left))
            return false;
        if (cur != null && cur >= root.val)
            return false;
        cur = root.val;
        if (!recur(root.right))
            return false;
        return true;
    }
}
