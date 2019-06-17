package company.huawei;

/**
 * Created by zhanghr on 2018/9/5.
 */
import java.util.*;
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] str = input.toCharArray();
        String[] items = input.split("\\d+");
        Pair[] pairs = new Pair[items.length];
        int start = 0;
        for (int i=0; i<items.length; i++){
            start += items[i].length();
            int end = start+1;
            while (end<str.length && str[end]<='9' && str[end]>='0'){
                end++;
            }
            int count = Integer.parseInt(input.substring(start, end));
            start = end;
            Pair p = new Pair(count, items[i]);
            pairs[i] = p;
        }
        Arrays.sort(pairs);
        StringBuilder sb = new StringBuilder();
        for (Pair p : pairs)
            sb.append(p.toString());
        System.out.println(sb.toString());
    }
}

class Pair implements Comparable<Pair>{
    int count;
    String value;

    public Pair(int count, String value){
        this.count = count;
        this.value = value;
    }
    @Override
    public int compareTo(Pair o) {
        if (this.count != o.count)
            return this.count-o.count;
        else
            return value.compareTo(o.value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<count; i++)
            sb.append(value);
        return sb.toString();
    }
}
