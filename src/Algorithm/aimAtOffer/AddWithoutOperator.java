package Algorithm.aimAtOffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author zhanghr
 *
 */
public class AddWithoutOperator {
	public int Add(int num1,int num2) {
        int n1 = num1 ^ num2;
        int n2 = num1 & num2;
        while (n2 != 0){
            n2 = n2<<1;
            int temp = n1 & n2;
            n1 = n1 ^ n2;
            n2 = temp;
        }
        return n1;
    }
}
