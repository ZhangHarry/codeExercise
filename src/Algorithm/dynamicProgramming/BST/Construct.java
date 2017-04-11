package Algorithm.dynamicProgramming.BST;

/**
 * Created by zhanghr on 2016/12/11.
 * 根据前序排列和中序排列重建BST，实际上前序排列并没有带来更多的信息量，因为前序排列就是从小到大排列，将中序排列中所有元素按大小排列就是
 */
public class Construct {
    public static BST construct(int[] preorder, int[] inorder){
        Node root = construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        BST bst = new BST(root);
        return bst;
    }
    private static Node construct(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2){
        int root = inorder[s2];
        Node node = new Node(root);
        if (s1 == e1)
            return node;
        int i;
        for (i = s1; i <= e1 ; i++) {
            if (preorder[i] == root)
                break;
        }
        node.setLeft(construct(preorder, s1, i-1, inorder, s2+1, e2));
        node.setRight(construct(preorder, i+1, e1, inorder, s2+1, e2));
        return node;
    }

    /**
     * 注意到对于>、<node两种类型的值，只要保证每一类中值的插入顺序不变，两类间值的插入顺序变化也不会影响树的最终结构
     * 按中序排列的顺序插入得到的BST对应的中序排列相同，因为按照这样的插入顺序保证了node早于node.left、node.right，因此树的结构不会发生变化
     * 总的复杂度恰好是nlogn，与将中序排列变成前序排列的复杂度一样，前序排列能否将总的复杂度降低？
     * @param inorder
     * @return
     */
    private static BST construct(int[] inorder){
        int s = 0;
        BST bst = new BST(new Node(inorder[s]));
        while ((s = s+1) < inorder.length) {
            bst.insertNode(inorder[s]);
        }
        return bst;
    }

    public static void main(String[] args){
        BST bst = new BST(10);
        bst.insertNode(2);
        bst.insertNode(12);
        bst.insertNode(22);
        bst.insertNode(5);
        bst.insertNode(3);
        bst.insertNode(33);
        Node.inOrderVisit(bst.root);
        int[] inorder = new int[]{10,2,5,3,12,22,33};
        System.out.println("\n=================================");
        BST newBst = Construct.construct(inorder);
        Node.inOrderVisit(newBst.root);
        System.out.println();
        Node.preOrderVisit(newBst.root);
        System.out.println();
        Node.postOrderVisit(newBst.root);
    }
}
