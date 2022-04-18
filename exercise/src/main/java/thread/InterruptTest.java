package thread;

public class InterruptTest {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 依旧在运行");
                }
            }
        });

        thread.start();
        // 执行线程的interrupt()方法
        /**
         * java.lang.Thread public void interrupt()
         * Interrupts this thread.
         * Unless the current thread is interrupting itself, which is always permitted,
         * the checkAccess method of this thread is invoked, which may cause a SecurityException to be thrown.
         * If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int)
         * methods of the Object class, or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int),
         * methods of this class, then its interrupt status will be cleared and it will receive an InterruptedException.
         * If this thread is blocked in an I/O operation upon an InterruptibleChannel then the channel will be closed,
         * the thread's interrupt status will be set, and the thread will receive a java.nio.channels.ClosedByInterruptException.
         * If this thread is blocked in a java.nio.channels.Selector then the thread's interrupt status will be set and
         * it will return immediately from the selection operation, possibly with a non-zero value,
         * just as if the selector's wakeup method were invoked.
         * If none of the previous conditions hold then this thread's interrupt status will be set.
         * Interrupting a thread that is not alive need not have any effect.
         *
         * Throws:
         * SecurityException – if the current thread cannot modify this thread
         *
         * */
        thread.interrupt();
    }
}
