package Algorithm.util.graph;

/**
 * Created by Zhanghr on 2016/5/25.
 */
public class Edge<T> {
    private Node strNode;
    private Node endNode;
    private T symbol;

    public Node getStrNode() {
        return strNode;
    }

    public void setStrNode(Node strNode) {
        this.strNode = strNode;
    }

    public T getSymbol() {
        return symbol;
    }

    public void setSymbol(T symbol) {
        this.symbol = symbol;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public Edge(Node start, Node end, T sym){
        this.strNode = start;
        this.endNode = end;
        this.symbol = sym;
    }

    public String toString(){
        return symbol.toString();
    }

}
