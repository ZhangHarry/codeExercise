package Algorithm.ProgrammerInterview.star;

import java.util.*;

/**
 * Created by zhanghr on 2018/7/20.
 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，我们应该让上面的人比下面的人更轻一点。
 现在一个马戏团要表演这个节目，为了视觉效果，我们还要求下面的人的身高比上面的人高。请编写一个算法，计算最多能叠多少人，注意这里所有演员都同时出现。

 给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。同时给定演员总数n，请返回最多能叠的人数。保证总人数小于等于500。

 测试样例：
 [[1,2],[3,4],[5,6],[7,8]],4
 返回：4
 */

public class DieLuoHanII {public int getHeight(int[][] actors, int n) {
    // write code here
    if (actors.length<2)
        return actors.length;
    Arrays.sort(actors, new MyComparator());
    int[][] weights = new int[n][2];
    weights[0][1] = actors[0][1];
    weights[0][0] = actors[0][0];
    int max = 1;
    // 和叠罗汉那题很像，这里虽然需要考虑高度和重量，但是按照高度排序后，需要找的就是最长递增子序列，需要注意的就是更新时不能更新相同高度的项
    // 另一种思路：不需要重排，在findIndex时注意比较高度和重量就行，可以尝试下。
    for (int i=1; i<actors.length; i++){
        int height = actors[i][0];
        int x = actors[i][1];
        int index = findIndex(weights, x, 0, max-1);
        if (index == max){
            if (weights[max-1][0] != height){
                weights[max][1] = x;
                weights[max][0] = height;
                max++;
            }
        }else if (weights[index][1] > x){
            while (index < max && weights[index][1] > x){
                if (weights[index][0] != height){
                    weights[index][1] = x;
                    weights[index][0] = height;
                }
            }
        }
    }
    return max;
}

    public int findIndex(int[][] weights, int x, int start, int end){
        if (weights[start][1] >= x)
            return start;
        if (weights[end][1] < x)
            return end+1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (weights[start][1] == x)
                return start;
            if (weights[mid][1] == x)
                return mid;
            if (weights[end][1] == x)
                return end;
            if (start+1 >= end)
                return end;
            if (weights[mid][1] < x)
                start = mid;
            else
                end=mid;
        }
        return 0;
    }

    public static void main(String[] args){
        DieLuoHanII test = new DieLuoHanII();
        int[][] actors = new int[][]{
                new int[]{1,2},
                new int[]{3,4},
                new int[]{5,6},
                new int[]{7,8}
        };
        System.out.println(test.getHeight(actors,4));
    }

}

class MyComparator implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];
    }
}