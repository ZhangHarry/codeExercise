package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/24.
 有一堆箱子，每个箱子宽为wi，长为di，高为hi，现在需要将箱子都堆起来，而且为了使堆起来的箱子不倒，
 上面的箱子的宽度和长度必须小于下面的箱子。请实现一个方法，求出能堆出的最高的高度，
 这里的高度即堆起来的所有箱子的高度之和。

 给定三个int数组w,l,h，分别表示每个箱子宽、长和高，同时给定箱子的数目n。
 请返回能堆成的最高的高度。保证n小于等于500。
 */

import java.util.*;

public class Box {
    public int getHeight(int[] w, int[] l, int[] h, int n) {
        // write code here
        Box0[] boxes = new Box0[n];
        for(int i=0; i<n; i++){
            Box0 box = new Box0(w[i], l[i], h[i]);
            boxes[i] = (box);
        }
        Arrays.sort(boxes);
        int size = boxes.length;
        int[] heights = new int[size];
        int maxH = 0;
        for (int i=0; i<size; i++){
            Box0 box = boxes[i];
            int tmp= 0;
            for (int j=i-1;j>=0; j--){
                Box0 pre = boxes[j];
                if (pre.w < box.w && pre.l < box.l)
                    tmp = Math.max(tmp, heights[j]);
            }
            heights[i] = tmp+box.h;
            maxH = Math.max(maxH, heights[i]);
        }
        return maxH;
    }
}

class Box0 implements Comparable<Box0>{
    int w,l,h;
    Box0(int w, int l, int h){
        this.w = w;
        this.l = l;
        this.h = h;
    }
    public int compareTo(Box0 o){
        if (w != o.w)
            return w-o.w;
        if (l != o.l)
            return l-o.l;
        return h-o.h;
    }
}
