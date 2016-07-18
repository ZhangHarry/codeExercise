package Algorithm.Casual;

/**
 * Created by Zhanghr on 2016/3/14.
 */
public class BST {
    Node root;
    BST(int value){
        this.root = new Node(value);
    }
    public static void main(String[] args){
        BST bst = new BST(10);
        bst.insertNode(2);
        bst.insertNode(22);
        bst.insertNode(5);
        bst.insertNode(12);
        bst.insertNode(3);
        bst.insertNode(2);
        bst.insertNode(33);
        bst.root.print(bst.root);
    }
    public void insertNode(int v){
        Node curNode = root;
        Node newNode = new Node(v);
        boolean isLeft = false;
        while (!curNode.isEmpty() ){
            if (curNode.compareTo(newNode) == 0){
                System.out.println("this value has existed : " + v);
                return;
            }else if (curNode.compareTo(newNode) > 0){
                curNode = curNode.getLeft();
                isLeft = true;
            }else if (curNode.compareTo(newNode) < 0){
                curNode = curNode.getRight();
                isLeft = false;
            }
        }
        Node parentNode = curNode.getParent();
        if (parentNode.compareTo(newNode) > 0)
            parentNode.setLeft(newNode);
        else
            parentNode.setRight(newNode);
    }

    public void deleteNode(int v){
        Node curNode = root;
        Node target = new Node(v);
        while (!curNode.isEmpty()){
            if (curNode.compareTo(target) == 0){
                if (!curNode.getLeft().isEmpty()){
                    replaceWithLt(curNode);
                }else {
                    replaceWithRt(curNode);
                }
                break;
            }else if (curNode.compareTo(target) > 0){
                curNode = curNode.getLeft();
            }else if (curNode.compareTo(target) < 0){
                curNode = curNode.getRight();
            }
        }
        System.out.println("this value has not existed : "+v);
    }

    private void replaceWithRt(Node curNode) {
        Node parent = curNode.getParent();
        Node rt = curNode.getRight();
        if (parent.compareTo(curNode) > 0){
            parent.setLeft(rt);
        }else {
            parent.setRight(rt);
        }
    }

    private void replaceWithLt(Node curNode) {
        Node replaceNode = findLessMax(curNode);
        curNode.value = replaceNode.value;
        replaceNode.getParent().setRight(replaceNode.getLeft());
    }

    private Node findLessMax(Node curNode) {
        curNode = curNode.getLeft();
        while (!curNode.getRight().isEmpty()){
            curNode = curNode.getRight();
        }
        return curNode;
    }
}

class Node implements Comparable<Node>{

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
}