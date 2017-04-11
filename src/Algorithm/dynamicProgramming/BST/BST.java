package Algorithm.dynamicProgramming.BST;

import java.util.HashMap;

/**
 * Created by Zhanghr on 2016/3/14.
 */
public class BST {
    Node root;
    BST(int value){
        this.root = new Node(value);
    }

    BST(Node node){
        this.root = node;
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
                System.err.println("this value has existed : " + v);
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
        if (isLeft)
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

