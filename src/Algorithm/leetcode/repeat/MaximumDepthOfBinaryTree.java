package Algorithm.leetcode.repeat;

import Algorithm.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * Created by zhanghr on 2018/8/2.
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Note: A leaf is a node with no children.

 Example:

 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 return its depth = 3.
 */

public class MaximumDepthOfBinaryTree {
    // 广搜，实际上递归最简单，最快
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int height = 0;
        int count = 1;
        while(!list.isEmpty()){
            height++;
            int nextCount =0 ;
            while (count >0){
                TreeNode node = list.getFirst();
                list.removeFirst();
                if (node.left != null){
                    list.add(node.left);
                    nextCount++;
                }
                if (node.right != null){
                    list.add(node.right);
                    nextCount++;
                }
                count--;
            }
            count = nextCount;
        }
        return height;
    }
}
