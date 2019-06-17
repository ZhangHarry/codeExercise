package company.wangyi.test;

import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/8.
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int X = in.nextInt(), Y = in.nextInt();
            String str = in.next();
            int index = str.length()/2;
            if (X == Y)
                System.out.println(baseTo10(str.substring(0, index), X));
            else {
                boolean left = X > Y ? true : false;
                while (true) {
                    int numX = baseTo10(str.substring(0, index), X);
                    int numY = baseTo10(str.substring(index), Y);
                    if (numX == numY) {
                        System.out.println(numX);
                        break;
                    } else {
                        index = left ? index - 1 : index + 1;
                    }
                }
            }
        }
    }

    public static int baseTo10(String str, int base) {
        int number = 0;
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int c=0;
            if (chars[i] >= '0' && chars[i] <= '9')
                c = chars[i] - '0';
            else if (chars[i] >= 'A' && chars[i] <= 'F')
                c = chars[i] - 'A' + 10;
            number += (int) Math.pow(base, chars.length - 1 - i) * c;
        }
        return number;
    }
}
