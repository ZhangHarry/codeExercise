import Algorithm.dynamicProgramming.LCS.LCS_A;
import Algorithm.dynamicProgramming.LCS.NormalLCSDisplayer;
import util.CmdExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhanghr on 2016/4/19.
 */
public class Test {
    public static void main(String[] args){
        CmdExecutor.exec("java -version");

    }

    public static void compareFileBytes(String fileName1, String fileName2) {
        File file1 = new File(fileName1), file2 = new File(fileName2);
        InputStream in1 = null, in2 = null;
        int sum1 = 0, count1 = 0, sum2 = 0, count2 = 0;
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        try {
            in1 = new FileInputStream(file1);
            in2 = new FileInputStream(file2);
            int tempbyte1, tempbyte2 = -1;
            while ((tempbyte1 = in1.read()) != -1) {
                sum1++;
                if (tempbyte1 != 0) {
                    count1++;
                    list1.add(tempbyte1);
                }
            }
            while ((tempbyte2 = in2.read()) != -1) {
                sum2++;
                if (tempbyte2 != 0) {
                    count2++;
                    list2.add(tempbyte2);
                }
            }
            System.out.format("%ncount1 : %d sum1 : %d ", count1, sum1);
            System.out.format("%ncount2 : %d sum2 : %d %n", count2, sum2);
            in1.close();
            in2.close();
            LCS_A<Integer> lcs = new LCS_A<>(list1, list2, new NormalLCSDisplayer());
            lcs.showlcs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
