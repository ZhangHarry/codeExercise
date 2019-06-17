package company.jd;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/9.
 */

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            items[i] = new Item(a,b,c);
        }
        int res = 0;
        for (int i=0; i<n; i++){
            Item cur = items[i];
            for (int j=0; j<n; j++){
                if (j != i){
                    Item item = items[j];
                    if (cur.a < item.a && cur.b < item.b && cur.c < item.c){
                        res++;
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}

class Item{
    int a,b,c;
    public Item(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
