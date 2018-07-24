package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/21.
 有一个正整数，请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小)

 给定正整数int x，请返回一个vector，代表所求的两个数（小的在前）。保证答案存在。

 测试样例：
 2
 返回：[1,4]
 */

public class CloseNumber {
    // 问题不难，但是需要注意对于求更大数时要在前面加一位0以保证循环（也可以不加，这里加了）；将二进制表示反转后好算一点，虽然倒着也可以算，但是正着算更直观点。
    // 就是求更大值时找到第一个01的地方，把1提前后，后面的0、1排成最小值。求更小值时找到10，将0提前，后面0、1排成最大值。所以算法其实可以合并下。
    public int[] getCloseNumber(int x) {
        // write code here
        int[] result = new int[2];
        String s = Integer.toBinaryString(x);
        char[] bits = reverse(s).toCharArray();
        String val = reverse(getSmaller(bits));
        result[0] = Integer.parseInt(val, 2);
        s= '0'+s;
        bits = reverse(s).toCharArray();
        val = reverse(getLarger(bits));
        result[1] = Integer.parseInt(val,2);
        return result;
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }

    public String getLarger(char[] bits){
        char[] tmp = new char[bits.length];
        System.arraycopy(bits,0, tmp, 0, bits.length);
        int zeros = 0, ones = 0;
        for (int i=0; i<bits.length; i++){
            if (bits[i]=='1')
                ones++;
            else if (bits[i] == '0'){
                if (ones>0)
                    break;
                else
                    zeros++;
            }
        }
        tmp[zeros+ones]='1';
        ones--;
        zeros++;
        int i=0;
        while (i<ones)
            tmp[i++] = '1';
        while (i<zeros+ones)
            tmp[i++] = '0';
        return new String(tmp);
    }

    public String getSmaller(char[] bits){
        char[] tmp = new char[bits.length];
        System.arraycopy(bits,0, tmp, 0, bits.length);
        int zeros = 0, ones = 0;
        for (int i=0; i<bits.length; i++){
            if (bits[i]=='0')
                zeros++;
            else if (bits[i] == '1'){
                if (zeros>0)
                    break;
                else
                    ones++;
            }
        }
        tmp[zeros+ones]='0';
        int i=0;
        while (i<zeros-1)
            tmp[i++] = '0';
        while (i<zeros+ones)
            tmp[i++] = '1';
        return new String(tmp);
    }

    public static void main(String[] args){
        CloseNumber test = new CloseNumber();
        test.getCloseNumber(76351);
    }
}
