package Algorithm.lintcode;
import java.util.*;
/**
 * beats 96.60% Submissions!
 * Created by zhanghr on 2018/5/26.
 */

public class CountOfSmallerNumberBefore {
    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        if (A.length == 0)
            return new LinkedList<>();
        Entity[] entities = new Entity[A.length];
        Entity[] origin =new Entity[A.length];
        for (int i=0;i<A.length; i++){
            Entity e = new Entity();
            e.val = A[i];
            e.index = i;
            entities[i] = e;
            origin[i] = e;
        }
        Entity[] temp = new Entity[A.length];
        mergeSort(entities, temp, 0, A.length-1);
        List<Integer> l = new ArrayList<>(A.length);
        for (Entity e : origin)
            l.add(e.count);
        return l;
    }

    public void mergeSort(Entity[] A, Entity[] temp, int start, int end){
        if (start == end)
            return;
        int median = (start+end)/2;
        mergeSort(A, temp, start, median);
        mergeSort(A, temp, median+1, end);
        merge(A, temp, start, median, median+1, end);
    }

    public void merge(Entity[] A, Entity[] temp, int s1, int e1, int s2, int e2){
        int start = s1;
        int index = s1;
        while (s1<=e1 && s2 <= e2){
            if (A[s1].val < A[s2].val){
                temp[index++] = A[s1++];
            }else if (A[s2].val <= A[s1].val){
                Entity e = A[s2];
                e.count += s1-start;
                temp[index++] = A[s2++];
            }
        }

        while (s1 <= e1){
            temp[index++] = A[s1++];
        }

        while (s2 <= e2){
            Entity e = A[s2];
            e.count += s1-start;
            temp[index++] = A[s2++];
        }
        while (start <= e2){
            A[start] = temp[start];
            start++;
        }
    }

    public static void main(String[] args){
        CountOfSmallerNumberBefore test = new CountOfSmallerNumberBefore();
        test.countOfSmallerNumberII(new int[]{1,2,7,8,5});
        test.countOfSmallerNumberII(new int[]{1});
    }
}
class Entity{
    int val;
    int count;
    int index;
    public String toString(){
        return ""+val+","+count;
    }
}
