package util;

import java.io.InputStream;

/**
 * Created by zhr on 2016/7/18.
 */
public class CMDExector {
    /**
     *
     * @param cmd ��Ҫִ�е�ָ��
     */
    public static void exect(String cmd){
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec("cmd.exe /c start " + cmd);

            //�����ý����ӡ������̨��
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
