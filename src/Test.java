import Algorithm.dynamicProgramming.LCS.LCS_A;
import Algorithm.dynamicProgramming.LCS.NormalLCSDisplayer;
import util.CmdExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.org.apache.bcel.internal.generic.IFNE;

/**
 * Created by Zhanghr on 2016/4/19.
 */
public class Test {
    public static void main(String[] args){
//        CmdExecutor.exec("java -version");
//    	int[] array = new int[]{1,2,3};
//    	int[] temp = Arrays.copyOf(array, array.length+1);
//    	temp[array.length] = -1;
//    	for (int i = 0; i < temp.length; i++) {
//			System.out.println(temp[i]);
//		}
    	
    	Test test = new Test();
    	Map<String, int[]> map = new HashMap<>();
    	test.addElement("hh", "123", map);
    	for (Entry<String, int[]> entry : map.entrySet()){
    		System.out.println(entry.getKey() + " " + entry.getValue());
    	}
    	test.addElement("hhg", "123", map);
    	for (Entry<String, int[]> entry : map.entrySet()){
    		System.out.println(entry.getKey() + " " + entry.getValue());
    	}
    	test.addElement("hh", "234", map);
    	for (Entry<String, int[]> entry : map.entrySet()){
    		System.out.println(entry.getKey() + " " + entry.getValue());
    	}
    }

    public static void compareFileBytes(String fileName1, String fileName2) {
        File file1 = new File(fileName1), file2 = new File(fileName2);
        InputStream in1 = null, in2 = null;
        int sum1 = 0, count1 = 0, sum2 = 0, count2 = 0;
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        try {
            in1 = new FileInputStream(file1);
            in2 = new FileInputStream(file2);
            int tempbyte1, tempbyte2 = -1;
            while ((tempbyte1 = in1.read()) != -1) {
                sum1++;
                if (tempbyte1 != 0) {
                    count1++;
                    list1.add(tempbyte1);
                }
            }
            while ((tempbyte2 = in2.read()) != -1) {
                sum2++;
                if (tempbyte2 != 0) {
                    count2++;
                    list2.add(tempbyte2);
                }
            }
            System.out.format("%ncount1 : %d sum1 : %d ", count1, sum1);
            System.out.format("%ncount2 : %d sum2 : %d %n", count2, sum2);
            in1.close();
            in2.close();
            LCS_A<Integer> lcs = new LCS_A<>(list1, list2, new NormalLCSDisplayer());
            lcs.showlcs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   public boolean addElement(String label, String element, Map<String, int[]> map){
	   int[] array = map.get(label);
	   if (array == null){
		   array = new int[]{Integer.valueOf(element)};
		   map.put(label, array);
		   return true;
	   }
	   for (int i=0; i<array.length; i++) {
		   if (Integer.valueOf(element) == array[i])
			   return true;
	   }
	   int size = array.length;
	   int[] newArray = Arrays.copyOf(array, size+1);
	   newArray[array.length] = Integer.valueOf(element);
	   map.put(label, newArray);
	   return true;
   }
}
