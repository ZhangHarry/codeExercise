package Algorithm.aimAtOffer;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * Created by zhanghr on 2018/4/21.
 */
import java.util.*;
public class ZPrintTree {
    public static void main(String[] args){
        ZPrintTree p = new ZPrintTree();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        p.Print(root);
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        if (pRoot == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeft = true;
        queue.add(pRoot);
        int sameLevel = 1;
        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int nextLevel = 0;
            while (sameLevel > 0){
                TreeNode node = queue.poll();
                if (isLeft) {
                    level.add(node.val);
                }else {
                    level.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                    nextLevel++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    nextLevel++;
                }
                sameLevel--;
            }
            isLeft = !isLeft;
            sameLevel = nextLevel;
            list.add(level);
        }
        return list;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}