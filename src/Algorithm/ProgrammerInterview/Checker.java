package Algorithm.ProgrammerInterview;

import Algorithm.leetcode.util.TreeNode;

/**
 * Created by zhanghr on 2018/7/25.
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。

 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */

public class Checker {
    TreeNode pre;
    public boolean checkBST(TreeNode root) {
        // write code here
        return inorder(root);
    }

    public boolean inorder(TreeNode root){
        if (root==null)
            return true;
        if (!inorder(root.left))
            return false;
        if (pre != null && root.val <= pre.val)
            return false;
        pre = root;
        if (!inorder(root.right))
            return false;
        return true;
    }
}
