package Algorithm.ProgrammerInterview;

import Algorithm.leetcode.util.TreeNode;

/**
 * Created by zhanghr on 2018/7/19.
 *
 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。

 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。

 */

public class Balance {
    // 使用一个全局变量存储树的高度
    int height = 0;
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null){
            height = 0;
            return true;
        }
        if (!isBalance(root.left)){
            return false;
        }
        int leftH = height;
        if (!isBalance(root.right)){
            return false;
        }
        int rightH = height;
        if(leftH-rightH > 1 || leftH-rightH<-1){
            return false;
        }
        height = Math.max(leftH, rightH)+1;
        return true;
    }
}
