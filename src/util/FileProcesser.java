package util;

import java.io.*;

/**
 * Created by zhanghr on 2016/8/6.
 */
public class FileProcesser {
    /**
     *
     * @param fileName
     * @return content string of file
     */
    public static String getContent(String fileName)
    {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }

    /**
     * ×ª»»ÎÄ¼þ±àÂë
     * @param srcFileName
     * @param destFileName
     * @param srcEncoding
     * @param destEncoding
     * @throws IOException
     */
    public static void transformFileEncoding(String srcFileName, String destFileName, String srcEncoding, String destEncoding) throws IOException {
        String line_separator = System.getProperty("line.separator");
        FileInputStream fis = new FileInputStream(srcFileName);
        StringBuffer content = new StringBuffer();
        DataInputStream in = new DataInputStream(fis);
        BufferedReader d = new BufferedReader(new InputStreamReader(in, srcEncoding));
        String line = null;
        while ((line = d.readLine()) != null)
            content.append(line + line_separator);
        d.close();
        in.close();
        fis.close();

        Writer ow = new OutputStreamWriter(new FileOutputStream(destFileName), destEncoding);
        ow.write(content.toString());
        ow.close();
    }
}
