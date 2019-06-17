package company.iqiyi;

import com.sun.xml.internal.ws.util.UtilException;


/**
 * Created by zhanghr on 2018/9/15.
 */

import java.util.Arrays;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int p = sc.nextInt();
        Item[] items = new Item[N];
        for (int i=0; i<N; i++){
            Item item = new Item(i+1, sc.nextInt());
            items[i] = item;
        }
        sc.nextLine();
        for (int i=0; i<M; i++){
            String[] s = sc.nextLine().split(" ");
            int item = Integer.parseInt(s[1]);
            if (s[0].equals("A")){
                items[item-1].count++;
            }else{
                items[item-1].count--;
            }
        }
        Arrays.sort(items);
        int res = 1;
        int cur = items[0].count;
        if (items[0].id != p) {
            for (int i = 1; i < N; i++) {
                if (items[i].count < cur) {
                    res = i + 1;
                    cur = items[i].count;
                }
                if (items[i].id == p)
                    break;
            }
        }
        System.out.println(res);
    }
}

class Item implements Comparable<Item>{
    int id;
    int count;
    Item(int id, int count){
        this.id = id;
        this.count = count;
    }

    @Override
    public int compareTo(Item o) {
        return o.count-this.count;
    }
}
