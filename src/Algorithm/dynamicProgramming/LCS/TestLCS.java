package Algorithm.dynamicProgramming.LCS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghr on 2016/11/20.
 */
public class TestLCS {
    public static void main(String[] args) throws IOException {
//        compareFileBytes("E:\\eeWorkspace\\zhonghui\\UnknownEncode\\test\\FileManager0.cs",
//                "E:\\eeWorkspace\\zhonghui\\UnknownEncode\\test\\FileManager1.cs");
        transferFile("E:\\eeWorkspace\\zhonghui\\UnknownEncode\\t\\FileManager.cs.rm",
                "E:\\eeWorkspace\\zhonghui\\UnknownEncode\\t\\FileManager0.cs.cs");
    }

    public static void testCase1(){
        List<String> list3 = new ArrayList<>();
        list3.add("A");
        list3.add("B");
        list3.add("C");
        list3.add("B");
        list3.add("D");
        list3.add("A");
        list3.add("B");
        List<String> list4 = new ArrayList<>();
        list4.add("B");
        list4.add("D");
        list4.add("C");
        list4.add("A");
        list4.add("B");
        list4.add("A");
        LCS_A<String> lcs = new LCS_A<>(list3, list4, new NormalLCSDisplayer());
        lcs.showlcsArray();
        lcs.showlcs();
    }



    public static void transferFile(String srcFileName, String destFileName) throws IOException {
        String line_separator = System.getProperty("line.separator");
        FileInputStream fis = new FileInputStream(srcFileName);
        StringBuffer content = new StringBuffer();
        DataInputStream in = new DataInputStream(fis);
        BufferedReader d = new BufferedReader(new InputStreamReader(in, "utf-16"));// , "UTF-8"
        String line = null;
        while ((line = d.readLine()) != null) {
            content.append(line + line_separator);
            System.out.println(new String(line.getBytes(),"gbk"));
        }
        d.close();
        in.close();
        fis.close();

        Writer ow = new OutputStreamWriter(new FileOutputStream(destFileName), "utf-8");
        ow.write(content.toString());
        ow.close();
    }


}
