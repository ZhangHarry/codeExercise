package Algorithm.rotateDice;

import java.util.*;

/**
 * Created by Zhanghr on 2016/4/27.
 */
public class TreeTransformDice {
    Dice dice;
    Dictionary<String, String> dictory = new Hashtable<>();
    public TreeTransformDice(Dice dice){
        this.dice = dice;
    }

    public void rotate(){
        Queue<MyNode> leaves = new ArrayDeque<>();
        MyNode root = new MyNode(this.dice);
        leaves.add(root);
        while (!leaves.isEmpty()){
            MyNode node = leaves.poll();
            if (dictory.get(node.toString())==null){
                dictory.put(node.value.toString(), node.value.transList);
                for (Transformation t : node.value.transformations()){
                    Dice transformedDice = t.transform(node.value);
                    if (dictory.get(transformedDice.toString())==null){
                        MyNode newNode = new MyNode(transformedDice);
                        leaves.add(newNode);
                        node.addChild(newNode);
                    }
                }
            }
        }
        System.out.print(root);
    }

    public static void main(String[] args){
        String[] symbols = new String[]{"r","g","b","b","g","r"};
        TreeTransformDice test = new TreeTransformDice(new Dice(symbols));
        test.rotate();
    }

}

class MyNode{
    Dice value;
    List<MyNode> children = new ArrayList<>();
    public MyNode(Dice d){
        this.value = d;
    }
    public void addChild(MyNode n){
        children.add(n);
    }
    public String toString(){
        return value.toString();
    }
}
