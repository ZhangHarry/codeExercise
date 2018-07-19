package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/17.

 Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */
import java.util.*;
public class QueueReconstructionByHeight {
    // beat 50%
    // 思路：观察高度之间的比较，先按高度排序，对于同高度的若干个人来说，在可选的位置里，按照他们的k取出对应的位置，全部取完后从可选位置里去掉，继续看下一个高度
    //       其实从上面的观察我们可以得到两个元素间的顺序关系，按照这个比较关系进行排序、插入。这就是更优解法，见reconstructQueue1()。
    //       相比于这里更新链表的做法，优解巧妙地地方在于先把大数按顺序插入，因为对于大数来说排在它们前面的项其实已经知道了，就是它们自己或者比它们更早插入的值。
    //       而原来的解法这么繁琐，就是因为对于小值来说剩下的数都有可能，这个时候反过来想就是优解。
    public int[][] reconstructQueue(int[][] people) {
        if (people.length<=1)
            return people;
        Pair[] objs = new Pair[people.length];
        List<Integer> indeies = new LinkedList<>();
        for (int i=0;i<objs.length; i++){
            objs[i] = new Pair(people[i][0], people[i][1]);
            indeies.add(i);
        }
        Arrays.sort(objs);
        int preH = objs[0].h;

        List<Integer> removed = new LinkedList<>();
        for (int i=0;i<objs.length; ){
            Pair p = null;
            while (i<objs.length && (p = objs[i]).h == preH){
                Integer index = indeies.get(p.k);
                people[index][0] = p.h;
                people[index][1] = p.k;
                i++;
                removed.add(index);
            }
            if (i<objs.length) {
                preH = p.h;
            }
            for (Integer r : removed){
                indeies.remove(r);
            }
            removed = new LinkedList<>();
        }
        return people;
    }

    class Pair implements Comparable<Pair>{
        public int h,k;
        Pair(int h, int k){
            this.h = h;
            this.k = k;
        }

        public int compareTo(Pair o){
            if (o.h != this.h)
                return this.h-o.h;
            return this.k-o.k;
        }
    }

    // 推荐解答
    public int[][] reconstructQueue1(int[][] people) {
        // sort by either priority queue or array
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return (p1[0] != p2[0])? p2[0] - p1[0]: p1[1] - p2[1];
            }
        });

        // insert into correct location
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] p: people){
            res.add(p[1], p);
        }

        return res.toArray(people);
    }

    public static void main(String[] args){
        QueueReconstructionByHeight test = new QueueReconstructionByHeight();
        int[][] people = new int[][]{
                new int[]{7,0}, new int[]{4,4}, new int[]{7,1}, new int[]{5,0}, new int[]{6,1}, new int[]{5,2}
        };
        test.reconstructQueue1(people);
    }
}


