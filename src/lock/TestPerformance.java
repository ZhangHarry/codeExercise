package lock;

import Algorithm.aimAtOffer.InversePairs;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhanghr on 2018/5/10.
 */

public class TestPerformance {
    public static void main(String[] args){
        int num = 1000;
        for (int i =0; i<10; i++) {
            long startTime = System.currentTimeMillis();
            testSynchronize(num);
            long endTimes = System.currentTimeMillis();
            System.out.println("syn time cost : " + (endTimes - startTime));
            startTime = System.currentTimeMillis();
            testLock(num);
            endTimes = System.currentTimeMillis();
            System.out.println("lock time cost : " + (endTimes - startTime));
        }
    }

    public static void testSynchronize(int num){
        ExecutorService pool = Executors.newFixedThreadPool(num);
        Object obj = new Object();
        for (int i =0; i<num; i++){
            pool.execute(new Sync(obj));
        }
        pool.shutdown();
    }

    public static void testLock(int num){
        ExecutorService pool = Executors.newFixedThreadPool(num);
        Lock obj = new ReentrantLock();
        for (int i =0; i<num; i++){
            pool.execute(new LockJ(obj));
        }
        pool.shutdown();
    }

    public static void job(){
        InversePairs test = new InversePairs();
        int[] array = new int[]{1,2,3,4,6, 234, 234, 345, 3,4, 66,78, 9};
        test.InversePairs(array);
    }
}
class Sync implements Runnable{
    Object obj;
    Sync(Object obj){
        this.obj = obj;
    }

    public void run(){
        synchronized (obj){
            TestPerformance.job();
        }
    }
}

class LockJ implements Runnable{
    Lock lock;
    LockJ(Lock lock){
        this.lock = lock;
    }

    public void run(){
        lock.lock();
        TestPerformance.job();
        lock.unlock();
    }
}
