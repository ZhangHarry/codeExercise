package Algorithm.ProgrammerInterview;

import Algorithm.leetcode.util.TreeNode;

/**
 * Created by zhanghr on 2018/7/24.
 */

public class Successor {

    public int findSucc(TreeNode root, int p) {
        // write code here
        if (root == null)
            return -1;
        TreeNode node = search(root, p);
        if (node == null || node.right==null)
            return -1;
        node = node.right;
        while (node.left!=null){
            node = node.left;
        }
        return node.val;
    }

    public TreeNode search(TreeNode root, int p) {
        // write code here
        if (root.val == p)
            return root;
        if (root.left != null){
            TreeNode node = search(root.left, p);
            if (node != null)
                return node;
        }
        if (root.right != null){
            TreeNode node = search(root.right, p);
            if (node != null)
                return node;
        }
        return null;
    }

    public static void main(String[] args){
        Successor test = new Successor();
        TreeNode r =new TreeNode(0);
        r.left = new TreeNode(1);
        r.right = new TreeNode(2);
        r.right.left = new TreeNode(3);
        r.right.right = new TreeNode(4);
        r.right.right.right = new TreeNode(7);
        r.right.left.left = new TreeNode(5);
        r.right.left.right = new TreeNode(6);
        System.out.println(test.findSucc(r, 4));
    }

}
