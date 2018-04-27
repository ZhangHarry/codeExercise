package Algorithm.leetcode.finished;
import java.util.*;

/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].

 * @author zhanghr
 *
 */
public class MonotoneIncreasingDigits {
	// beat 49%
	public int monotoneIncreasingDigits0(int N) {
        List<Integer> list = new LinkedList<>();
        while (true){
        	if (N< 10) {
                list.add(0, N);
                break;
        	}else {
                list.add(0, N%10);
                N = N/10;        		
        	}
        }
        int[] array = new int[list.size()];
        boolean minor1 = false;
        for (int i =0; i<list.size()-1; i++){
            array[i] = list.get(i);
            if (!minor1 && list.get(i) > list.get(i+1)){
                array[i] = array[i]-1;
                update(array, i-1, array[i]);
                minor1 = true;
                break;
            }
        } 
        array[array.length-1] = list.get(array.length-1);
        boolean set9 = false;
        int sum = 0;
        for (int i=0; i<array.length; i++){
            if (set9)
                sum = sum * 10 + 9;
            else {
                if (array[i] < list.get(i)){
                    set9 = true;
                }
                sum = sum * 10 + array[i];
            }
        }
        return sum;
    }
    
    public void update(int[] array, int index, int value){
        while (index>=0 && array[index]>value) {
            array[index--]=value;
        }        
    }
    
    // beat 49%
    public int monotoneIncreasingDigits(int N) {
        List<Integer> list = new LinkedList<>();
        while (true){
        	if (N< 10) {
                list.add(0, N);
                break;
        	}else {
                list.add(0, N%10);
                N = N/10;        		
        	}
        }
        int[] array = new int[list.size()];
        int index =0;
        for (; index<list.size()-1; index++){
            array[index] = list.get(index);
            if (list.get(index) > list.get(index+1)){
                array[index] = array[index]-1; // 因为该位减1，所以后面接着补9就是最大，可以跳出循环
                int value = array[index];
                index--;
                while (index>=0 && array[index]>value) {
                    array[index--]=value;
                }        
                index++;
                break;
            }
        } 
        array[array.length-1] = list.get(array.length-1);
        int sum = 0;
        for (int i=0; i<=index; i++){
            sum = sum * 10 + array[i];
        }
        for (int i=index+1; i<array.length; i++){
        	sum = sum*10 + 9;
        }
        return sum;
    }
    
    
    public static void main(String[] args) {
	MonotoneIncreasingDigits test = new MonotoneIncreasingDigits();
	System.out.println(test.monotoneIncreasingDigits(31));
	System.out.println(test.monotoneIncreasingDigits(20));
	System.out.println(test.monotoneIncreasingDigits(10));
	System.out.println(test.monotoneIncreasingDigits(1234));
	System.out.println(test.monotoneIncreasingDigits(3323));
	System.out.println(test.monotoneIncreasingDigits(345676));
	System.out.println(test.monotoneIncreasingDigits(984443));
	}
}
