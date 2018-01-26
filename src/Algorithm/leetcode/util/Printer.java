package Algorithm.leetcode.util;

import java.util.Collection;
import java.util.Iterator;

public class Printer {
	public static void print(int[][] array) {
		int length1 = array.length, length2 = array[0].length;
		System.out.println("==================================================");
		for (int i = 0; i < length1; i++) {
			StringBuffer sBuffer = new StringBuffer();
			for (int j = 0; j < length2; j++) {
				sBuffer.append(array[i][j] + "\t");
			}
			System.out.println(sBuffer.toString());
		}
		System.out.println("==================================================");
	}

	public static void print(int[] array) {
		
		int length = array == null ? 0 : array.length;
		System.out.println("==================================================");
		StringBuffer sBuffer = new StringBuffer();
		for (int j = 0; j < length; j++) {
			sBuffer.append(array[j] + "\t");
		}
		System.out.println(sBuffer.toString());
		System.out.println("==================================================");
	}
	
	public static void print(Collection collection) {
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			String value = (String) iterator.next();
			System.out.println(value);				
		}
	}
}
