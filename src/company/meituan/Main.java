package company.meituan;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        while (true) {
            String line = s.nextLine();
            int[] bitArray= new int[10];
            for (int i = 0; i < line.length(); i++) {
				bitArray[line.charAt(i)-'0']++;
			}
            check(bitArray);            	
//        }
	}

	private static void check(int[] bitArray) {
        for (int i =1; i < 10;i++){
        	if (bitArray[i]==0) {
        		System.out.println(i);
        		return;
        	}
        }   
        
        int min=bitArray[1];
        boolean flag=false;
        for (int i =1; i < 10;i++){
        	if (bitArray[i]<min) {
        		min=bitArray[i];
        		flag=true;
        	}
        }
        int lackNum=0;
        for (int i =1; i < 10;i++){ // get lack number
        	if (bitArray[i]==min) {
        		lackNum=i;
        		break;
        	}
        }
        if (bitArray[0] < min || bitArray[0]==0){
        	String s="1";
        	for (int i =0;i<bitArray[0]+1;i++){
        		s+="0";
        	}
        	System.out.println(s);
        	return;
        }
        if (lackNum>0 && flag) {
        	String s=lackNum+"";
        	for (int i=0;i<min;i++){
        		s += lackNum;
        	}
        	System.out.println(s);
        	return;
        }else {
        	String s="1";
        	for (int i=0;i<min;i++){
        		s += "1";
        	}
        	System.out.println(s);
        	return;
        }
	}
}
