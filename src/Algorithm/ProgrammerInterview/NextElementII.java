package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/27.
 */

import java.util.*;

public class NextElementII {
    public int[] findNext(int[] A, int n) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>((int)(n/0.75)+1);
        int[] res = new int[n];
        for (int i=n-1; i>=0; i--){
            int start = 0, end = list.size()-1;
            int index = -1;
            while(start <= end){
                if (list.get(start) > A[i]){
                    index = start;
                    break;
                }else if (list.get(end) <= A[i]){
                    index = end+1;
                    break;
                }else if (list.get(start) == A[i]){
                    index = start+1;
                    break;
                }else{
                    int mid = start + (end-start)/2;
                    if (start == mid){
                        index = end;
                        break;
                    }
                    if (list.get(mid) < A[i])
                        start = mid;
                    else if (list.get(mid) > A[i])
                        end = mid;
                    else{
                        index = mid+1;
                        break;
                    }
                }
            }
            if (index < 0 || index >= list.size()){
                list.add(A[i]);
                res[i] = -1;
            }else{
                res[i] = list.get(index);
                if (index==0 || list.get(index-1) != res[i])
                    list.add(index, A[i]);
            }
        }
        return res;

    }
}