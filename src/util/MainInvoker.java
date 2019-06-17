package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhanghr on 2018/8/6.
 */

public class MainInvoker {
    public static void main(String[] args){
        try {
            Class cl = Class.forName("company.wangyi.Main2");
            Method method = cl.getDeclaredMethod("main", String[].class);
            // 1、把String[]数组包装成一个Object对象来传参。
            // 2、为了兼容1.4版本JDK，main方法反射调用需要在对象数组里面再封装一个String[]的数组来匹配main方法的String[] args 参数
            // 为什么只传入一个String[]数组调用main方法会失败呢？
            // 因为JDK1.4里面参数传递会默认把你的String[]内所含的对象拆出来作为多个参数进行传递。 
            method.invoke(cl, (Object) new String[]{});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
