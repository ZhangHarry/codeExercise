/**
 * Created by zhanghr on 2018/9/17.
 */

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        Object obj = new Object();
//        new Thread(new ThreadAlterate(obj, 0)).start();
//        new Thread(new ThreadAlterate(obj, 1)).start();
        PrintSD p = new PrintSD();
        PrintSD.A a = p.new A();
        PrintSD.B b = p.new B();
        new Thread(a).start();
        new Thread(b).start();
    }
}
class ThreadAlterate implements Runnable{
    Object obj;
    int i;
    ThreadAlterate(Object obj, int i){
        this.obj = obj;
        this.i=i;
    }
    @Override
    public void run() {
        while(i<=100) {
            synchronized (obj) {
                System.out.println(i);
                i += 2;
                try {
                    obj.notify();
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // 保证程序结束，如果没有以下这段代码，程序不会结束，因为会有一个程序一直等待锁
        synchronized (obj) {
            obj.notify();
        }
    }
}

class PrintSD {

    //定义打印的方法
    public synchronized void print(String str) {
        notify();
        System.out.println(str);
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //定义打印奇数的线程类
    class A implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 1; i < 100; i += 2) {
                print("A" + i);
            }
        }
    }

    //定义打印偶数的线程类
    class B implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 2; i <= 100; i += 2) {
                print("B" + i);
            }
        }
    }

    public static void main(String[] args) {
        PrintSD p = new PrintSD();
        A a = p.new A();
        B b = p.new B();
        new Thread(a).start();
        new Thread(b).start();
    }
}