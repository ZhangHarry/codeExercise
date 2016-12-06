package Algorithm.json;

import Algorithm.json.core.linear.JsonParser;
import Algorithm.json.exception.WrongFormatException;
import Algorithm.json.object.JsonBaseObject;
import Algorithm.json.displayer.JsonDisplayer;

/**
 * Created by zhanghr on 2016/12/5.
 */
public class TestJsonParser {
    public static void main(String[] args){
        JsonParser parser = new JsonParser();
        String input = "[{\"钥匙\":\"值\",\"k3\":v3, \"2k4\": \"242\"},{k2 :  \n" +
                "-2e34},[{k3:4}]]";
        try {
            JsonBaseObject json = parser.parse(input.getBytes());
            JsonDisplayer.display(json);
//            int num = (int)((JsonObject)json).getValue("2k4");
        } catch (WrongFormatException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private String oneObject(){
        return "{k:v,k2:2,\"k3\":v3, \"2k4\": \"242\" }";
    }



}
