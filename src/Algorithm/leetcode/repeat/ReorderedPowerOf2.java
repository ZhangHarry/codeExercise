package Algorithm.leetcode.repeat;

/**
 * Created by zhanghr on 2018/8/1.
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

 Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 这里的reorder是指10进制下的表示reorder
 */

public class ReorderedPowerOf2 {
    /**
     * 个人的做法是检查所有排序，n!复杂度，但是其实2的pow只有32，所以是o(1)。最好的做法是反过来检查2的pow是否与n是不同的排序。
     * 判断是否不同排序，这里也有trick，因为int位数不超过10位。所以下面使用加法也可以，不会存在两个不同数的res一样。
     public boolean reorderedPowerOf2(int N) {
     long c = counter(N);
     for (int i = 0; i < 32; i++)
     if (counter(1 << i) == c) return true;
     return false;
     }
     public long counter(int N) {
     long res = 0;
     for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
     return res;
     }
     */
    public boolean reorderedPowerOf2(int N) {
        char[] str = (""+N).toCharArray();
        for (int i=0; i< str.length; i++){
            if (str[i] != '0'){
                swap(str, i, 0);
                if (backTrack(str, 1))
                    return true;
                swap(str, i, 0);
            }

        }
        return false;
    }


    public boolean backTrack(char[] str,int n){
        if (n == str.length){
            if (isPowerOf2(Integer.parseInt(new String(str))))
                return true;
            else
                return false;
        }
        for (int i=n;i< str.length; i++){
            swap(str, i, n);
            if (backTrack(str, n+1))
                return true;
            swap(str, i, n);
        }
        return false;
    }

    public boolean isPowerOf2(int n){
        if ((n & (n-1)) == 0)
            return true;
        else
            return false;
    }

    public void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
