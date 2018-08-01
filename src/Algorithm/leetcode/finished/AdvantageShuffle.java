package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/8/1.

 Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

 Return any permutation of A that maximizes its advantage with respect to B.



 Example 1:

 Input: A = [2,7,11,15], B = [1,10,4,11]
 Output: [2,11,7,15]
 */
import java.util.*;
public class AdvantageShuffle {
    // beat 80%
    // 思路很简单，把A、B排序后，贪婪算法，需要注意的是将B排序前记录原来的位置。这里是通过HashMap记录B当前值和所在index。
    public int[] advantageCount(int[] A, int[] B) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<B.length; i++){
            int num = B[i];
            if (map.containsKey(num)){
                map.get(num).add(i);
            }else{
                List<Integer> indexes = new LinkedList<>();
                indexes.add(i);
                map.put(num, indexes);
            }
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int[] res = new int[A.length];
        int bi = 0;
        int start = 0;
        int end = A.length-1;
        for (int i=0; i<A.length; i++){
            if (A[i] > B[bi]){
                res[start] = A[i];
                start++;
                bi++;
            }else{
                res[end] = A[i];
                end--;
            }
        }
        int[] tmp = new int[A.length];
        for (int i=0; i<res.length; i++){
            List<Integer> indexes = map.get(B[i]);
            tmp[indexes.get(0)] = res[i];
            indexes.remove(0);
        }
        return tmp;
    }
}
