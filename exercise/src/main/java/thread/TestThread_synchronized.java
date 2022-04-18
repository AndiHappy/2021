package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThread_synchronized {

    private volatile int count = 0;  
      
    /** 
     * 为了保证数据的准确性，多线程的情况下需要加上synchronized关键字
     * 否则会出现出乎预料的结果 这也是线程安全的重要体现 
     */  
    public synchronized void increment() {  
        count++;  
    }  
      
    private int getCount() {  
        return count;  
    }  
      
    /**
     * 这里模拟一个递增的任务，递增目标为50000 
     */  
    public static void main(String[] args) throws InterruptedException {  
        final TestThread_synchronized counter = new TestThread_synchronized();
        int workCount = 50000;  
        ExecutorService executor = Executors.newFixedThreadPool(10);  
        long start = System.currentTimeMillis();  
        for (int i = 0; i < workCount; i++) {  
            Runnable runnable = new Runnable() {  
                @Override  
                public void run() {
                    Thread.interrupted();
                    counter.increment();
                }  
            };  
            executor.execute(runnable);  
        }  
        // 关闭启动线程，执行未完成的任务  
        executor.shutdown();  
        // 等待所有线程完成任务，完成后才继续执行下一步  
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);  
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");  
        System.out.println("执行结果：count=" + counter.getCount());  
    } 
}
