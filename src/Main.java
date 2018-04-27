import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int k = in.nextInt(); // 目标
            int a = in.nextInt(); // a长度
            int x = in.nextInt(); // 长度a的数目
            int b = in.nextInt(); // b长度
            int y = in.nextInt(); // 长度b的数目
            if (a > b){
            	int temp = b;
            	b = a;
            	a= temp;
            	temp = y;
            	y = x;
            	x = temp;
            }
            int maxCommon = maxCommonDivisor(a,b);
            if (k % maxCommon != 0)
            	System.out.println(0);
            else if(maxCommon == 1){
            	int rest = k % (a+b);
            	if (rest != 0 && rest % a != 0 && rest %b !=0)
            		System.out.println(0);
            }
            else {
            	System.out.println(100);
            	List<int[]> sol = getSolution(k, a, b, x, y);
            	int count = 0;
            	for (int[] solution : sol){
            		int aTimes = solution[0];
            	}
            }
        }
    }
    
    // a,b <= 10
    public static int maxCommonDivisor(int a, int b) {  
    	  
    	if (a == 1)
    		return 1;
    	if (b % a == 0)
    		return a;
    	else if (a % 2 == 0 && b %2 ==0)
    		return 2;
    	else if(a % 3 == 0 && b % 3 ==0)
    		return 3;
    	else 
    		return 1;
    }  
    
    public static List<int[]> getSolution(int k, int a, int b, int aMax, int bMax){
    	List<int[]> list = new LinkedList<>();
    	if (k < 0)
    		return list;
    	List<int[]> sol = getSolution(k-a, a, b, aMax, bMax);
    	for (int[] solution : sol){
        	int[] array = new int[2];
        	array[0] = solution[0]+1;
        	array[1] = solution[1];
        	list.add(array);
    	}
    	sol = (getSolution(k-b, a, b, aMax, bMax));
    	for (int[] solution : sol){
        	int[] array = new int[2];
        	array[0] = solution[0];
        	array[1] = solution[1]+1;
        	list.add(array);
    	}
    	return list;
    }
    
    // c(m,n)
    public static long cmn(int m, int n){
    	long l1 = 1;
    	int count = 0;
    	while (count < n){
    		l1 *= (m-count);
    		count++;
    	}
    	long l2 = 1;
    	count = 1;
    	while (count <= n){
    		l2 *= count;
    		count++;
    	}
    	return l1/l2;
    }
}