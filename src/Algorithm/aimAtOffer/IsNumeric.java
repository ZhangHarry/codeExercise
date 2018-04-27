package Algorithm.aimAtOffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * Created by zhanghr on 2018/4/27.
 */

public class IsNumeric {
    public boolean isNumeric(char[] str) {
        boolean signal = false;
        boolean point = false;
        boolean e = false;
        int index = 0;
        for (;index<str.length; index++){
            char c = str[index];
            if (isDigit(c))
                ;
            else if (c == 'E' || c == 'e'){
                if (e) // two es are invalid
                    return false;
                signal = false;
                e = true;
            }else if (c == '-' || c == '+'){
                if (index != 0 && (str[index-1] != 'e' && str[index-1] != 'E'))
                    return false;
                if (signal) // two signals are invalid
                    return false;
                signal = true;
            }else if (c == '.'){ // two points are invalid
                if (point || e) // e doesn't allow point
                    return false;
                point = true;
            }
            else
                return false;
        }
        if (!isDigit(str[index-1]))
            return false;
        return true;
    }

    public boolean isDigit(char c){
        if (c <= '9' && c >= '0')
            return true;
        return false;
    }
}
