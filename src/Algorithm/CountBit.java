package Algorithm;

/**
 * Created by zhanghr on 2018/4/20.
 */

public class CountBit {
    public long get(int n){
        if (n < 10)
            return n;
        long count = 9;
        int bit = 1;
        int temp = n;
        long mod = 10;
        while (temp > 9){
            temp = temp/10;
            bit++;
            mod *= 10;
        }
        mod /= 10;
        count += bit * (n-mod+1);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(count);
        bit--;
        while (bit >1){
            count += bit * (mod-mod/10);
//            System.out.println(count);
            mod /= 10;
            bit--;
        }
        return count;
    }

    public static void main(String[] args){
        CountBit test = new CountBit();
        System.out.println(test.get(10));
//        System.out.println(test.get(13));
//        System.out.println(test.get(17));
//        System.out.println(test.get(21));
        System.out.println(test.get(100));
//        System.out.println(test.get(121));
        System.out.println(test.get(1000000000));
//        System.out.println(test.get(10000));
    }
}
