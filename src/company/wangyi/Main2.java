package company.wangyi;

/**
 * Created by zhanghr on 2018/8/9.
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        HashSet<Character> specials = new HashSet<>();
        char[] specialSigns = "!@#$%^&*()_-=+{}[],.<>/?".toCharArray();
        for (char ch : specialSigns)
            specials.add(ch);
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        set.add("password");
        set.add("admin");
        set.add("qwerty");
        set.add("hello");
        set.add("iloveyou");
        set.add("112233");

        int N = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< N; i++){
            String str = sc.nextLine();
            if (str.length() < 8 || containsSimple(str, set)){
                sb.append("no\n");
            }else if (ifValid(str, specials)){
                sb.append("yes\n");
            }else
                sb.append("no\n");
        }
        System.out.print(sb.toString().substring(0, sb.length()-1));
    }

    public static boolean containsSimple(String str, HashSet<String> set){
        for (String s : set)
            if (str.indexOf(s)>=0)
                return true;
        return false;
    }

    public static boolean ifValid(String s, HashSet<Character> specials){
        char[] str = s.toCharArray();
        boolean hasUp = false;
        boolean hasLow = false;
        boolean hasSpecial = false;
        boolean hasNumber = false;
        for (int i=0; i<str.length-2; i++){
            if (ifUpChar(str[i])) {
                hasUp = true;
                if (str[i] < 'Y' && str[i+1] == str[i]+1 && str[i+2] == str[i]+2)
                    return false;
            }
            else if (ifNumber(str[i])) {
                hasNumber = true;
                if (str[i+2]-str[i+1] == str[i+1] - str[i] && ifNumber(str[i+1]) && ifNumber(str[i+2]))
                    return false;
            }
            else if (specials.contains(str[i]))
                hasSpecial = true;
            else if (ifLowChar(str[i])) {
                hasLow = true;
                if (str[i]<'y' && str[i+1] == str[i]+1 && str[i+2] == str[i]+2)
                    return false;
            }
        }
        for (int i=str.length-2; i<str.length; i++){
            if (ifUpChar(str[i])) {
                hasUp = true;
            }
            else if (ifNumber(str[i])) {
                hasNumber = true;
            }
            else if (specials.contains(str[i]))
                hasSpecial = true;
            else if (ifLowChar(str[i])) {
                hasLow = true;
            }
        }
        if (!hasLow || !hasSpecial || !hasUp || !hasNumber)
            return false;
        return true;
    }

    public static boolean ifUpChar(char ch){
        return ch>='A' && ch<='Z';
    }

    public static boolean ifLowChar(char ch){
        return ch>='a' && ch<='z';
    }

    public static boolean ifNumber(char ch){
        return ch>='0' && ch<='9';
    }
}
