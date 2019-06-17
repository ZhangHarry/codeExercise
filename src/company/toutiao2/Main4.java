package company.toutiao2;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/8/25.
 */

public class Main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        boolean equal = true;
        for (int i=1; i<n; i++){
            if (array[i-1] != array[i]){
                equal = false;
                break;
            }
        }
        if (equal)
            System.out.println(n*t);
        else{
            int length = lengthOfLIS(array);
            System.out.println(length+t-1);
        }
    }

    public static int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;
        for (int i=0;i<nums.length;i++){
            int index = binarySearch(tail, 0, size-1, nums[i]);
            if (index == size)
                size++;
        }
        return size;
    }

    public static int binarySearch(int[]tail, int start, int end, int value){
        if (end<0 || value > tail[end]){
            end++;
            tail[end] = value;
            return end;
        }
        if (value < tail[start]){
            tail[start] = value;
            return start;
        }else if(value == tail[start]){
            while(value == tail[start] && start<= end)
                start++;
            if(start >end){
                tail[end] = value;
            }else
                tail[start] = value;
            return start;
        }
        while (start < end-1){
            int median = (start+end)/2;
            if (tail[median] ==  value)
                return median;
            if (tail[median] < value)
                start = median;
            else
                end = median;
        }
        if (tail[end] >= value){
            tail[end] = value;
        }
        return end;

    }
}
