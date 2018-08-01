package Algorithm.leetcode.util;

import java.util.Collection;
import java.util.Iterator;

public class Tool {
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


	public static int[][] toIntAA(String s){
		s = s.substring(1);
		s = s.substring(0, s.length()-2);
		String[] a = s.split("],");
		int[][] res = new int[a.length][];
		for (int i=0;i< a.length; i++){
			String str = a[i];
			str = str.substring(1);
			String[] elements = str.split(",");
			res[i] = new int[elements.length];
			for (int j=0;j<elements.length; j++){
				res[i][j] = Integer.parseInt(elements[j]);
			}
		}
		return res;
	}
}
