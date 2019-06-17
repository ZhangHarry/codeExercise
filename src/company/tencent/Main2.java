package company.tencent;

/**
 * Created by zhanghr on 2018/9/16.
 */

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<Integer, Node> map = new HashMap<>(); // 存储城市节点，保证节点唯一
        for (int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            Node n1 = map.get(start), n2 = map.get(end);
            if (n1 == null){
                n1 = new Node(start);
                map.put(start, n1);
            }
            if (n2 == null){
                n2 = new Node(end);
                map.put(end, n2);
            }
            n1.addNext(n2);
        }
        Collection<Node> nodes = map.values();
        HashSet<Node> noNeed = new HashSet<>();
        // 有向有环图搜索
        for (Node n : nodes){
            if (!noNeed.contains(n)){
                visit(n);
                noNeed.add(n);
                noNeed.addAll(n.reachables);
            }
        }
        int res = 0;
        HashMap<Node, HashSet<Node>> toNode = new HashMap<>();
        for (Node n : nodes){
            for (Node reached : n.reachables){
                HashSet<Node> reachables = toNode.get(reached);
                if (reachables == null){
                    reachables = new HashSet<>();
                    toNode.put(reached, reachables);
                }
                reachables.add(n);
            }
        }
        for (Node n : nodes){
            HashSet<Node> reachables = toNode.getOrDefault(n, new HashSet<>());
            reachables.remove(n);
            if (reachables.size() > n.getSize())
                res++;
        }
        System.out.println(res);
    }

    public static void visit(Node node){
        boolean retry = true;
        while (retry){
            retry = false;
            LinkedList<Node> list = new LinkedList<>();
            list.add(node);
            HashSet<Node> visited = new HashSet<>();
            while (!list.isEmpty()){
                Node cur = list.poll();
                visited.add(cur);
                for (Node n : cur.nexts){
                    if (cur.add(n.reachables))
                        retry = true;
                    if (!visited.contains(n)){
                        visited.add(n);
                        list.add(n);
                    }
                }
            }
        }
    }
}

class Node{
    int val;
    HashSet<Node> reachables = new HashSet<>();
    HashSet<Node> nexts = new HashSet<>();
    Node(int val){
        this.val = val;
    }
    public void addNext(Node node){
        nexts.add(node);
        reachables.add(node);
    }
    public boolean add(Collection node){
        int s = reachables.size();
        reachables.addAll(node);
        if (s < reachables.size())
            return true;
        else
            return false;
    }

    public int getSize(){
        reachables.remove(this);
        return reachables.size();
    }
}
