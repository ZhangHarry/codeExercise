package company.PayPal;

import java.util.*;

public class PayPal2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<int[]> list = new LinkedList<>();
        String s = in.nextLine();
        String[] pairs = s.split(",");
        for (String str:pairs){
        	String[] points = str.split(" ");
        	int a = Integer.parseInt(points[0]);
            int b = Integer.parseInt(points[0]);;
            int[] point = new int[]{a,b};
            list.add(point);
        }
        System.out.println(8);
    }
}
