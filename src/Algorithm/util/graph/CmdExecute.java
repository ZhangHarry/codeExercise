package Algorithm.util.graph;

import java.io.InputStream;

/**
 * Created by Zhanghr on 2016/5/31.
 */
public class CmdExecute {
    public static void execute(String cmd){

        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec("cmd.exe /c " + cmd);
            process.waitFor();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
