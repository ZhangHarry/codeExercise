package Algorithm.RotateDice;

import util.grapic.Edge;
import util.grapic.Graph;
import util.grapic.GraphWriter;
import util.grapic.Node;

import java.util.*;

/**
 * Created by Zhanghr on 2016/4/27.
 */
public class GraphicTreeTransformDice {
    Dice dice;
    Dictionary<String, Node> finishedTable = new Hashtable<>();
    Dictionary<String, Node> nodeTable = new Hashtable<>();
    public GraphicTreeTransformDice(Dice dice){
        this.dice = dice;
    }

    /**
     * finishedTable保证不会重复检查同一个状态以避免无限循环
     * nodeTable保证不会存在两个相同特征的dice
     */
    public void rotate(){
        Graph graph = new Graph();
        Queue<Node> leaves = new ArrayDeque<>();
        Node<Dice> root = new Node(this.dice);
        leaves.add(root);
        nodeTable.put(root.getSymbol().symbols(), root);
        while (!leaves.isEmpty()){
            Node<Dice> node = leaves.poll();
            graph.addNode(node);
            Dice dice = node.getSymbol();
            if (finishedTable.get(dice.symbols())==null){
                finishedTable.put(dice.symbols(), node);
                for (Transformation t : dice.transformations()){
                    Dice transformedDice = t.transform(dice);
                    Node n = finishedTable.get(transformedDice.symbols());
                    if (n ==null){
                        Node target = nodeTable.get(transformedDice.symbols());
                        if (target == null) {
                            target = new Node(transformedDice);
                            nodeTable.put(transformedDice.symbols(), target);
                        }
                        leaves.add(target);
                        Edge<String> edge = new Edge<>(node, target, t.discription());
                        node.addEdge(edge);
                    }else {
                        Edge<String> edge = new Edge<>(node, n, t.discription());
                        node.addEdge(edge);
                    }
                }
            }
        }
        GraphWriter.print(graph, "test.dot");
    }

    public static void main(String[] args){
        String[] symbols = new String[]{"r","g","b","b","g","r"};
        GraphicTreeTransformDice test = new GraphicTreeTransformDice(new Dice(symbols));
        test.rotate();
    }

}

