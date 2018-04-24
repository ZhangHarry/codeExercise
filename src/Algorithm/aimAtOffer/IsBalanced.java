package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/4/24.
 */

public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        if (root.left == null && root.right != null)
            return false;
        else if (root.right == null && root.left != null)
            return false;
        if (getHeight(root) == -1)
            return false;
        return true;
    }

    public int getHeight(TreeNode node){
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        if (left == -1)
            return -1;
        int right = getHeight(node.right);
        if (right == -1)
            return -1;
        if (left > right+1 || right > left + 1)
            return -1;
        return (left > right ? left : right)+1;
    }
}
