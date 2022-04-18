package thread;


import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Semaphore guard1 = new Semaphore(1);
    private static Semaphore guard2 = new Semaphore(1);

    public static void test1(String testV) {
        try {
            guard1.acquire();
            Thread.sleep(1000);
            guard2.acquire();
            int i = 0;
            while(i< 10){
                System.out.println(Thread.currentThread().getName() + testV);
                Thread.sleep(1000);
                i++;
            }
            guard2.release();
            guard1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test2(String testV) {
        try {
            guard2.acquire();
            Thread.sleep(1000);
            guard1.acquire();
            int i = 0;
            while(i< 10){
                System.out.println(Thread.currentThread().getName() + testV);
                Thread.sleep(1000);
                i++;
            }
            guard1.release();
            guard2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                test1("thread0");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                test2("thread1");
            }
        }.start();

        Thread.sleep(2000);
        guard1.release();
        Thread.sleep(2000);
    }
}
