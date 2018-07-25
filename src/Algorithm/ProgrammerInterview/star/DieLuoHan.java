package Algorithm.ProgrammerInterview.star;

import java.util.Arrays;

/**
 * Created by zhanghr on 2018/7/20.
 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。同时我们应该让下面的人比上面的人更高一点。已知参加游戏的每个人的身高，
 请编写代码计算通过选择参与游戏的人，我们最多能叠多少个人。注意这里的人都是先后到的，意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。

 给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回最多能叠的人数。保证n小于等于500。

 测试样例：
 [1,6,2,5,3,4],6
 返回：4

 实际上就是找最长递增子序列
 */

public class DieLuoHan {
    public int getHeight(int[] men, int n) {
        // write code here
        if (men.length<=1)
            return men.length;
        int[] heights = new int[n];
        Arrays.fill(heights, Integer.MAX_VALUE);
        int max = 1;
        heights[0] = men[0];
        for (int i=1; i<men.length; i++){
            int h = men[i];
            int index = findIndex(heights,h, 0, max-1);
            if (index==max){
                heights[index] = h;
                max++;
            }else if (heights[index] > h){
                while (index < max && h < heights[index]){
                    heights[index] = h;
                }
            }
        }
        return max;
    }

    public int findIndex(int[] heights,int target, int start,int end){
        if (target < heights[start])
            return start;
        if (target > heights[end])
            return end+1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (heights[start] == target)
                return start;
            if (heights[end] == target)
                return end;
            if (end == start+1)
                return end;
            if (heights[mid] == target)
                return mid;
            else if (heights[mid] < target)
                start = mid;
            else
                end = mid;
        }
        return 0;
    }
}
