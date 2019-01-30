package ro.mirodone;

public class Main {

    private static Object lock = new Object();

    public static void main(String[] args) {

        Thread th1 = new Thread(new Runner(ThreadColor.ANSI_BLUE), "Priority 10");
        Thread th2 = new Thread(new Runner(ThreadColor.ANSI_CYAN), "Priority 8");
        Thread th3 = new Thread(new Runner(ThreadColor.ANSI_RED), "Priority 6");
        Thread th4 = new Thread(new Runner(ThreadColor.ANSI_GREEN), "Priority 4");
        Thread th5 = new Thread(new Runner(ThreadColor.ANSI_YELLOW), "Priority 2");

        th1.setPriority(10);
        th2.setPriority(8);
        th3.setPriority(6);
        th4.setPriority(4);
        th5.setPriority(2);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();


    }

    private static class Runner implements Runnable {

        private int runCount = 1;
        private String threadColor;

        public Runner(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    //execute critical section of the code
                }

                // System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
            }

        }
    }
}
