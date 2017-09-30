package Algorithm.casual;

/**
 * Created by Zhanghr on 2016/4/7.
 */
public class TestRandom {
    public static void main(String[] args) {
        double[] random = new double[10];
        for (int i = 0; i < random.length; i++) {
            random[i] = Math.random();
        }

        for (int i = 0; i < random.length; i++) {
            System.out.println(i + " : " + random[i]);
            new Thread() {
                public void run() {
                    System.out.println("------------------------------"+Math.random());
                }
            }.run();
        }
    }
}
