package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Zhanghr on 2016/5/31.
 */
public class CmdExecutor {
    public static void exec(String cmd){

        System.out.format("cmd : %s%n",cmd);
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec("cmd.exe /c " + cmd);
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            InputStream iserr = process.getErrorStream();
            InputStreamReader isrerr = new InputStreamReader(iserr, "utf-8");
            BufferedReader brerr = new BufferedReader(isrerr);
            String s = "";
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            while ((s = brerr.readLine()) != null) {
                System.out.println(s);
            }
            process.waitFor();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
