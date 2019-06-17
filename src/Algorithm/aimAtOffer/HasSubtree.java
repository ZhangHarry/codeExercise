package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/8/7.
 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
            return false;
        return reHasSubtree(root1, root2);
    }

    public boolean reHasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
            return true;
        if(root1==null && root2!=null)
            return false;
        if (root1.val == root2.val){
            if (reHasSubtree(root1.left, root2.left) && reHasSubtree(root1.right, root2.right))
                return true;
        }
        return reHasSubtree(root1.left, root2) || reHasSubtree(root1.right, root2);
    }
}
