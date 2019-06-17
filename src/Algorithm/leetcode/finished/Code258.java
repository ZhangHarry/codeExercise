package Algorithm.leetcode.finished;

/**
 *Given a non-negative integer num, repeatedly addNext all its digits until the result has only one digit.
 *  For example:
 *  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 *  * Hint:
 *
 * A naive implementation of the above process is trivial. Could you come up with other methods?
 *
 * What are all the possible results?
 *
 * How do they occur, periodically or randomly?
 *
 * Created by zhanghr on 2016/12/15.
 */
public class Code258 {
    /**
     * 1101 / 1101 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * beats 22%
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10)
            return num;
        else {
            int tenth = num / 10 % 9;
            if (tenth == 0)
                tenth = 9;
            int oneth = num%10;
            if (9-tenth >= oneth)
                return oneth+tenth;
            else
                return oneth+tenth-9;
        }
    }
    
    /**
     * beat 16.37%
     * @param num
     * @return
     */
    public int addDigits2(int num) {
    	if (num < 10) {
			return num;
		}else {
			int rest = num % 9;
			if (rest == 0) {
				return 9;
			}else {
				return rest;
			}
		}
    }

    public static void main(String[] args){
        System.out.println(new Code258().addDigits2(25));
        System.out.println(new Code258().addDigits2(125));
        System.out.println(new Code258().addDigits2(90));
    }
}
