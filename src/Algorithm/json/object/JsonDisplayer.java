package Algorithm.json.object;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by zhanghr on 2016/12/5.
 */
public class JsonDisplayer {
    public static void display(JsonBaseObject object){
        if (object instanceof JsonObject)
            displayJsonObj((JsonObject)object);
        else if (object instanceof JsonArray)
            displayJsonArray((JsonArray)object);
    }

    private static void displayJsonObj(JsonObject object) {
        System.out.println("display json object--------");
        Collection<String> keys = object.keys();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.format("%s:%s%n", key, object.getValue(key));
        }
    }

    private static void displayJsonArray(JsonArray array) {
        System.out.println("display json array-------------------");
        int size = array.size();
        for (int i = 0; i < size; i++) {
            System.out.format("JsonBaseObject %d:%n", i);
            JsonBaseObject object = array.get(i);
            display(object);
        }
    }
}
