package Algorithm.aimAtOffer;

/**
 * //num1,num2分别为长度为1的数组。传出参数
 *  //将num1[0],num2[0]设置为返回结果
 * 
 * @author zhanghr
 *
 */
public class FindNumsAppearOnce {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum ^= array[i];
		}
		int mask = ((sum ^ (sum - 1)) + 1) >>> 1;
		System.out.println(mask);
		int xor1 = 0, xor2 = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & mask) == 0)
				xor1 ^= array[i];
			else
				xor2 ^= array[i];
		}
		num1[0] = xor1;
		num2[0] = xor2;
	}

	public static void main(String[] args) {
		FindNumsAppearOnce test = new FindNumsAppearOnce();
		int[] array = new int[] { 2, 4, 3, 6, 3, 2, 5, 5 };
		test.FindNumsAppearOnce(array, new int[1], new int[1]);
	}
}
