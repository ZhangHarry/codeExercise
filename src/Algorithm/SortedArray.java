package Algorithm;

/**
 * Created by zhanghr on 2018/4/25.
 */
import java.util.*;
public class SortedArray {
    /**
     *
     * @param array array[i] >= array[i+k]
     * @param k
     * @return sorted array
     */
    public int[] sortWithKSortedArray(int[] array, int k){
        int[] sorted = new int[array.length];
        Queue<Pair> queue = new PriorityQueue<>(k, new PairComparator());
        for (int i=0; i<k;i++){
            queue.add(new Pair(array[i], i));
        }
        int i=0;
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            sorted[i] = p.val;
            i++;
            int index = p.index+k;
            if (index < array.length)
                queue.add(new Pair(array[index], index));
        }
        return sorted;
    }
}
class Pair{
    int val;
    int index;
    Pair(int v, int index){
        this.val = v;
        this.index = index;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if (p1.val != p2.val)
            return p1.val -p2.val;
        else
            return p1.index -p2.index;
    }
}
