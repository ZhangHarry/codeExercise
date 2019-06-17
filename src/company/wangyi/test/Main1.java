package company.wangyi.test;

/**
 * Created by zhanghr on 2018/9/8.
 */
import java.util.*;
public class Main1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            String[] inputs = new String[m];
            scanner.nextLine();
            for (int i = 0; i < m; i++) {
                inputs[i] = scanner.nextLine();
                System.out.println(shorten(inputs[i]));
            }
        }

        public static String shorten(String input) {
            int start = 0;
            int end = 0;
            StringBuilder sb = new StringBuilder();
            int length = input.length();
            while (start < length - 1) {
                char last = input.charAt(start);
                for (int i = start + 1; i < length; i++) {
                    if (input.charAt(i) - last == 1) {
                        last = input.charAt(i);
                        if (i == length - 1) {
                            end = i;
                            break;
                        }
                        continue;
                    }
                    end = i - 1;
                    break;
                }
                if (end - start + 1 >= 4) {
                    sb.append(input.charAt(start));
                    sb.append("-");
                    sb.append(input.charAt(end));
                } else {
                    sb.append(input, start, end + 1);
                }
                start = end + 1;
                if (start == length - 1) {
                    sb.append(input.charAt(start));
                }
            }
            return sb.toString();
    }
}
