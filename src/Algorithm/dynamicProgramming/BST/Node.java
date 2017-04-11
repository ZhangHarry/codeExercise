package Algorithm.dynamicProgramming.BST;

/**
 * Created by zhanghr on 2016/12/11.
 */
public class Node implements Comparable<Node>{

    int value;
    private int height = 0;
    private Node left , right , parent;
    Node(){
    }
    Node(int value){
        this.value = value;
        this.height = 1;
        this.left = new Node();
        this.right = new Node();
        this.left.parent = this;
        this.right.parent = this;
        this.parent = new Node();
    }

    public void setLeft(Node left) {
        left.parent = this;
        this.left = left;
        int ori_height = this.height;
        this.height = Math.max(left.height, this.right.height)+1;
        if (height != ori_height)
            this.updateHeight();
    }

    public void setRight(Node right) {
        right.parent = this;
        this.right = right;
        int ori_height = this.height;
        this.height = Math.max(this.left.height, right.height)+1;
        if (height != ori_height)
            this.updateHeight();
    }

    private void updateHeight() {
        Node parent = this.parent;
        while (!parent.isEmpty()){
            int ori_height = parent.height;
            parent.height = Math.max(parent.left.height, parent.right.height)+1;
            if (parent.height != ori_height) {
                parent = parent.parent;
            }else {
                break;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }

    public void print(Node node){
        if (node.isEmpty()) {
            System.out.println();
            return;
        }
        print(node.left);
        for (int num = this.height - node.height; num >=0; num--){
            System.out.print("\t");
        }
        System.out.println(node.value);
        print(node.right);
    }

    public boolean isEmpty() {
        if (this.height <= 0)
            return true;
        else
            return false;
    }

    public static void preOrderVisit(Node node){
        Node left = node.getLeft(), right = node.getRight();
        if (!left.isEmpty())
            preOrderVisit(node.getLeft());
        System.out.print("\t" + node.value);
        if (!right.isEmpty())
            preOrderVisit(node.getRight());
    }

    public static void inOrderVisit(Node node){
        Node left = node.getLeft(), right = node.getRight();
        System.out.print("\t" + node.value);
        if (!left.isEmpty())
            inOrderVisit(node.getLeft());
        if (!right.isEmpty())
            inOrderVisit(node.getRight());
    }

    public static void postOrderVisit(Node node){
        Node left = node.getLeft(), right = node.getRight();
        if (!right.isEmpty())
            postOrderVisit(node.getRight());
        System.out.print("\t" + node.value);
        if (!left.isEmpty())
            postOrderVisit(node.getLeft());
    }
}
