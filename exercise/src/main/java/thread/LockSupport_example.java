package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupport_example {

    public static void main(String[] args) throws Exception {
        test();
        test1();
    }

    public static void test(){

        Thread e2 = new Thread(){
            @Override
            public void run() {
                System.out.println("run");
                LockSupport.park(this);
                System.out.println("unpark");
            }
        };
        e2.start();
        boolean inter =  e2.isInterrupted();
        System.out.println(inter);
        LockSupport.unpark(e2);
    }

    public static void test1() throws Exception {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("before unpark, " + LockSupport.getBlocker(mainThread));
            LockSupport.unpark(mainThread);
            System.out.println("after unpark, " + LockSupport.getBlocker(mainThread));
        });
        thread.start();
        System.out.println("before park");
        // 等待获取许可
        LockSupport.park("Park");
        System.out.println("after park");
    }
}
