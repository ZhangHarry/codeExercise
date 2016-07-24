package util;

import java.io.InputStream;

/**
 * Created by zhr on 2016/7/18.
 */
public class CMDExector {
    /**
     *
     * @param cmd 需要执行的指令
     */
    public static void exect(String cmd){
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec("cmd.exe /c start " + cmd);

            //将调用结果打印到控制台上
            InputStream in = process.getInputStream();
            while (in.read() != -1) {
                System.out.println(in.read());
            }
            in.close();
            process.waitFor();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
