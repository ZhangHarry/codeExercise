package company.toutiao2;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] relationships = new int[n][n];
        LinkedList<Integer> persons = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            for(int j = 0; j < temp.length; j++) {
                int index = Integer.parseInt(temp[j]) - 1;
                if(index >= 0)
                    relationships[i][index] = 1;
            }
            persons.add(i);
        }
        int res = getSeperatedGraphs(persons, relationships);
        System.out.println(res);
    }

    private static int getSeperatedGraphs(List<Integer> persons, int[][] relationships) {
        int res = 0;
        boolean[] ifVisited = new boolean[persons.size()];
        for(int i = 0; i < persons.size(); i++) {
            if(!ifVisited[i]) {
                travel(i,relationships, ifVisited);
                res++;
            }
        }
        return res;
    }

    private static void travel(int i, int[][] relationships, boolean[] ifVisited) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(i);
        while(!list.isEmpty()){
            int index = list.pop();
            LinkedList<Integer> nexts = getNexts(index, relationships);
            for (Integer next : nexts){
                if (!ifVisited[next]){
                    list.add(next);
                    ifVisited[next] = true;
                }
            }
        }
    }

    private static LinkedList<Integer> getNexts(int index, int[][] relationships) {
        LinkedList<Integer> nexts = new LinkedList<>();
        for(int i = 0; i < relationships.length; i++) {
            if(relationships[i][index] == 1)
                nexts.add(i);
        }
        for(int i = 0; i < relationships.length; i++) {
            if(relationships[index][i] == 1)
                nexts.add(i);
        }
        return nexts;
    }
}