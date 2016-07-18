package Algorithm.util.graph;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Zhanghr on 2016/5/25.
 */
public class Node<S> {
    private Collection<Edge> edges = new ArrayList<>();

    private S symbol;

    public Node(S sym){
        this.symbol = sym;
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    public S getSymbol() {
        return symbol;
    }

    public void setSymbol(S symbol) {
        this.symbol = symbol;
    }

    public void addEdge(Edge edge){
        this.edges.add(edge);
    }

    public void removeEdge(Edge edge){
        edges.remove(edge);
    }

    public String toString(){
        return symbol.toString();
    }
}
