package Algorithm.aimAtOffer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author zhanghr
 *
 */
public class FirstAppearingOnce {
	char[] array = new char[256];
	LinkedList<Character> list = new LinkedList<>();
	public void Insert(char ch)
    {
		if (array[ch] == 0) {
			list.add(ch);
		}
		array[ch]++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	Iterator<Character> iterator = list.iterator();
    	while (iterator.hasNext()) {
    		Character character = iterator.next();
			if (array[character] == 1)
				return character;
		}
    	return '#';
    }
}
