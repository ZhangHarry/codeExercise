package wangyi;

/**
 * Created by zhanghr on 2018/8/3.

 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，
 但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
 输入描述:
 每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），接下来的 1 行，
 包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
 输出描述:
 输出一行表示合法的排列数目。
 示例1
 输入
 复制
 5 5
 4 0 0 2 0
 输出
 复制
 2
 */
import java.util.*;
public class ListRecovery {
    int result = 0;
    int k;
    int[] nums;
    int[] tmp;
    public static void main(String[] args){
        System.out.println(new ListRecovery().solution());
    }

    // 全排序遍历
    public int solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        tmp = new int[n];
        boolean[] has = new boolean[n];
        int zeros = 0;
        for (int i=0; i<n;i++){
            nums[i] = sc.nextInt();
            tmp[i] = nums[i];
            if (nums[i] == 0){
                zeros++;
            } else
                has[nums[i]-1] = true;
        }
        if (getPair(nums) > k)
            return 0;
        int[] restNums = new int[zeros];
        int i=0;
        for (int j=0; j<n; j++){
            if (!has[j])
                restNums[i++] = j+1;
        }
        permutate(restNums, 0, restNums.length-1);
        return result;
    }

    public int getPair(int[] nums){
        int res = 0;
        for (int i=1; i<nums.length; i++){
            for (int j=i-1; j>=0; j--){
                if (nums[i] > nums[j])
                    res++;
            }
            if (res > k)
                return res;
        }
        return res;
    }

    public void permutate(int[] restNum, int start, int end){
        if (start == end){
            int i = 0;
            for (int j=0; j<nums.length; j++){
                if (nums[j] == 0)
                    tmp[j] = restNum[i++];
            }
            if (getPair(tmp) == k)
                result++;
            return;
        }
        for (int i=start; i<=end; i++){
            swap(restNum, i, start);
            permutate(restNum, start+1, end);
            swap(restNum, i, start);
        }
    }

    public void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
