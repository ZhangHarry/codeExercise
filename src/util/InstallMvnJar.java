package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhr on 2016/7/18.
 */
public class InstallMvnJar {

    /**
     * mvn install:install-file -Dfile=D:\mvn\spring-context-support-3.1.0.RELEASE.jar -DgroupId=org.springframework -DartifactId=spring-context-support -Dversion=3.1.0.RELEASE -Dpackaging=jar
     * @return
     */
    public static String constrcutCMD(){
        String cmdHeader = "vn install:install-file ";
        String Dfile = " -Dfile=";
        String DgroupId = " -DgroupId=";
        String DartifactId = " -DartifactId=";
        String Dpackaging = " -Dpackaging=jar";
        return null;
    }

    /**
     *
     * @param info ��ϸ��Ϣ����ʽ����
     *            <dependency>
     *                <groupId>org.eclipse.core</groupId>
     *                <artifactId>runtime</artifactId>
     *                <version>3.10.0-v20140318-2214</version>
     *            </dependency>
     */
    public static void install(String info){
        info = info.replaceAll("\\n","");
        info = info.replaceAll("\\r","");
        info = info.replaceAll("\\t","");
        info = info.replaceAll(" ","");
//        Pattern p= Pattern.compile("(<dependency>)(.*)(</dependency>)");
        Pattern p=Pattern.compile("(<dependency>)(.*)(</dependency>)");
        p = Pattern.compile("(<[a-zA-Z]+>)\\w+(<//.*>)");
        Matcher m=p.matcher(info);
        System.out.print(m.matches());
        while(m.find()) {
            String content = m.group();
            System.out.print(content+"\t");
            Pattern pa = Pattern.compile("(<)(\\w+)(>)(</)(\\w+)(>)");
            Matcher attributes = pa.matcher(content);
            System.out.println(attributes.matches());
            while (attributes.find()){
                String attribute = attributes.group();
                System.out.print(attribute+"\t");
            }
        }
    }

    public static void main(String[] args){
        String s = "<dependency>\n" +
                "    <groupId>org.eclipse.core</groupId>\n" +
                "    <artifactId>runtime</artifactId>\n" +
                "    <version>3.10.0-v20140318-2214</version>\n" +
                "</dependency>";
//        s = "<day>jj</day>";
        InstallMvnJar.remove(s);
    }

    public static void remove(String s){
        s = s.replaceAll("\\n","");
        Pattern p = Pattern.compile("(<)[a-z]+(>)");
        Matcher m=p.matcher(s);
        System.out.print(m.matches());
    }

}
