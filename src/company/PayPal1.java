package company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PayPal1 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        HashSet<String> set = new HashSet<>();
        
        for (int i =0; i<m; i++){
        	String cmd = in.nextLine();
        	String[] options = cmd.split(" ");
        	if (options[0].equals("mkdir")){
        		mkdir(set, options);
        	}else if (options[0].equals("touch")){
        		set.add("/" + options[1]);
        	}else if (options[0].equals("rm")){
        		rm(options, set);
        	}
        }
        
        for (int i =0; i<n; i++){
        	String question = in.nextLine();
        	String[] options = question.split(" ");
        	if (set.contains(options[1]))
        		System.out.println(true);
        	else
        		System.out.println(false);
        }
    }

	private static void rm(String[] options, HashSet<String> set) {
		if (options[1].equals("-r")){
			Iterator<String> it=set.iterator();
			String path = options[2];
			path = strim(path);
			while (it.hasNext()){
				String key = it.next();
				if (key.startsWith("/"+path))
					it.remove();
			}
		}else {
			set.remove(options[2]);
		}
		
	}

	private static void mkdir(HashSet<String> set, String[] options) {
		if (options[1].equals("-p")){
			String path = options[options.length-1];
			path = strim(path);
			String prefix = "/";
			for (int i=0;i<path.length();i++){
				if (path.charAt(i) == '/')
					set.add(prefix+path.substring(0, i));
			}
		}else {
			set.add(options[options.length-1]);
		}		
	}
	
	private static String strim(String s){
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("/");
		boolean before = true;
		for (int i =0; i<s.length(); i++){
			char c = s.charAt(i);
			if (c != '/'){
				sBuilder.append(c);
				before = false;
			}else {
				if (before == false) {
					sBuilder.append("/");
					before = true;
				}
					
			}
		}
		return sBuilder.toString();
				
	}
}
