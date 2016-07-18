import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Zhanghr on 2016/4/19.
 */
public class Test {
    public static void main(String[] args){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i=0;i<200;i++){
            String s = ""+i;
            map.put(s, s);
        }
        map.put("3","3");
        map.remove("3");
        System.out.print("/t");
    }
}
