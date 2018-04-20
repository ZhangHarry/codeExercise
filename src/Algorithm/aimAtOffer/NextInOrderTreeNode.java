package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/4/21.
 */

public class NextInOrderTreeNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        if (pNode.right != null){
            return getLeftest(pNode.right);
        }else {
            return getFirstLeftAncent(pNode);
        }
    }

    public TreeLinkNode getLeftest(TreeLinkNode node){
        TreeLinkNode result = node;
        while (result.left != null){
            result = result.left;
        }
        return result;
    }

    public TreeLinkNode getFirstLeftAncent(TreeLinkNode node){
        if (node.next == null)
            return null;
        if (node.next.left == node)
            return node.next;
        else{
            return getFirstLeftAncent(node.next);
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}