package thread.code;


public class MySemaphoreTest {

    private static Semaphore guard1 = new Semaphore(1,true);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    setName("thread"+ finalI);
                    try {
                        guard1.acquire();
                        Thread.sleep(1000*finalI+1000);
                        guard1.release();
                    } catch (InterruptedException e) {
                    }
                }
            }.start();
            Thread.sleep(100);
        }
        Thread.sleep(2000000);
    }
}
