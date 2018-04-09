package Algorithm.aimAtOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * @author zhanghr
 *
 */
public class Power {
	 public double Power(double base, int exponent) {
	        if (exponent == 0)
	        	return 1;
	        boolean negative = exponent < 0 ? true : false;
	        double result = powerRecursive(base, Math.abs(exponent));
	        if (negative)
	        	return 1/result;
	        else {
				return result;
			}
	  }

	private double powerRecursive(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;
		if (exponent % 2 == 0){
			double temp = powerRecursive(base, exponent/2);
			return temp * temp;
		}else {
			double temp = powerRecursive(base, exponent/2);
			return temp * temp * base;
		}
	}
}
