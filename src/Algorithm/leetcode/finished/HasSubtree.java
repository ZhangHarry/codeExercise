package Algorithm.leetcode.finished;

public class HasSubtree {
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 != null && root2 == null)
            return false;
        if (root2 != null && root1 == null)
            return false;
        if (root1 == null && root2 == null)
            return true;
        
        if (root1.val == root2.val){
            return equal(root1, root2);
        }else
            return HasSubtree(root1.left, root2) && HasSubtree(root1.right, root2);
    }
    
    public boolean equal(TreeNode node1,TreeNode node2){
        if (node1 == node2)
            return true;
        if (node1 != null && node2 != null && node1.val == node2.val)
            return equal(node1.left, node2.left) && equal(node1.right, node2.right);
        
        return false;
    }
    
    public static void main(String[] args) {
    	TreeNode root1 = new TreeNode(8);
    	TreeNode n1 = new TreeNode(9);
    	TreeNode n2 = new TreeNode(2);
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