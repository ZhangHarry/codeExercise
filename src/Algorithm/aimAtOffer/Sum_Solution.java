package Algorithm.aimAtOffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @author zhanghr
 *
 */
public class Sum_Solution {
	// 递归
	public int Sum_Solution(int n) {
        if (n<=1)
            return n;
        int sum = n + Sum_Solution(n-1);
        return sum;
    }
}
