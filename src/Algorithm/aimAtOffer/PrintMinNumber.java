package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/4/24.
 */
import java.util.*;
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0)
            return "";
        if (numbers.length == 1)
            return ""+numbers[0];
        List<Integer> list = new ArrayList<>(numbers.length);
        for (int num : numbers)
            list.add(num);
        Collections.sort(list, new MyComparator());
        String s = "";
        for (Integer num : list)
            s = s + num;
        return s;
    }
}
class MyComparator implements Comparator<Integer>{
    public int compare(Integer i1, Integer i2){
        String s1 = i2+""+i1, s2 = i1+""+i2;
        for (int i=0; i<s1.length(); i++){
            if (s1.charAt(i) > s2.charAt(i))
                return -1;
            else if (s1.charAt(i) < s2.charAt(i))
                return 1;
        }
        return 0;
    }
}
