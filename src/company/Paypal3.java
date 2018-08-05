package company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Paypal3 {
	/**
	 * a=LOAD()|1 
	 * DUMP(c)|1 c=CALCULATE(a,b)|3 b=LOAD()|2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] array = new int[26]; // store cost of get this value
		boolean[] direct = new boolean[26]; // store whether loaded
		HashMap<Character, List<Character>> map = new HashMap<>();
		Character target = null;
		while (in.hasNextLine()) {// 注意while处理多个case
			String s = in.nextLine();
			if (s.length() == 0)
				break;
			int splitor = s.indexOf("|");
			int cost = Integer.parseInt(s.substring(splitor + 1));
			String cmd = s.substring(0, splitor);
			if (cmd.indexOf('=') < 0) { // dump cmd
				target = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')')).charAt(0);
				array[target - 'a'] = array[target - 'a'] + cost;
			} else if (cmd.indexOf("LOAD") > 0) { // load cmd
				char element = cmd.charAt(0);
				array[element - 'a'] = cost;
				direct[element - 'a'] = true;
			} else { // calculate cmd
				Character ch = cmd.charAt(0);
				array[ch - 'a'] = array[ch - 'a'] + cost;
				String dd = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')'));
				String[] dependency = dd.split(",");
				List<Character> list = new LinkedList<>();
				for (String str : dependency) {
					list.add(str.charAt(0));
				}
				map.put(ch, list);
			}
		}

		if (!map.containsKey(target) || map.get(target).size() == 0)
			System.out.println(array[target]);
		else {
			int cost = getCost(target, direct, array, map);
			System.out.println(cost);
		}
	}

	public static int getCost(Character ch, boolean[] direct, int[] array, HashMap<Character, List<Character>> map) {
		if (direct[ch - 'a'])
			return array[ch - 'a'];
		List<Character> list = map.get(ch);
		int count = 0;
		for (Character c : list) {
			int cost = getCost(c, direct, array, map);
			if (cost > count)
				count = cost;
		}
		array[ch - 'a'] = array[ch - 'a'] + count;
		direct[ch - 'a'] = true;
		return array[ch - 'a'];
	}
}