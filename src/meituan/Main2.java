package meituan;


/**
 * 题目描述：
给出两个相同长度的由字符 a 和 b 构成的字符串，定义它们的距离为对应位置不同的字符的数量。
如串”aab”与串”aba”的距离为 2；串”ba”与串”aa”的距离为 1；串”baa”和串”baa”的距离为 0。下面给出两个字符串 S 与 T，其中 S 的长度不小于 T 的长度。我们用|S|代表 S 的长度，
|T|代表 T 的长度，那么在 S 中一共有|S|-|T|+1 个与 T 长度相同的子串，现在你需要计算 T 串与这些|S|-|T|+1 个子串的距离的和。

输入

第二行包含一个字符串 T。

S 和 T 均由字符 a 和 b 组成，1 ≤ |T| ≤ |S| ≤105 。
 * @author zhanghr
 *
 */
import java.util.Scanner;
public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int count=0;
        int length1=s.length(), length2=t.length();
        for (int i=0; i<length1-length2;i++){
        	String temp=s.substring(i, i+length2);
        	count += get(temp, t);
        }

        System.out.println(count);
	}
	
	public static int get(String s, String t){
        int count=0;
    	for (int i=0;i<s.length();i++){
            if (s.charAt(i) != t.charAt(i))
                count++;
        }
       return count;
	}
	
}
