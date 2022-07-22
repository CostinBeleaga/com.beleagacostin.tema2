import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private String threadName;
    private boolean direction;
    private Semaphore semaphoreNS;
    private Semaphore semaphoreWE;

    MyThread(String name, boolean direction, Semaphore sem1, Semaphore sem2) {
        this.threadName = name;
        this.direction = direction;
        this.semaphoreNS = sem1;
        this.semaphoreWE = sem2;
    }

    void threadExecute() {
        try {
            System.out.println(threadName + " is waiting to cross the street.");
            if (direction) {
                if(semaphoreWE.availablePermits() == 1) {
                    semaphoreNS.acquire();
                    System.out.println(threadName + " cross the road from N to S");
                    Thread.sleep(10);
                } else {
                    while(semaphoreWE.availablePermits() == 0) {
                        Thread.sleep(10);
                    }
                    semaphoreNS.acquire();
                    System.out.println(threadName + " cross the road from N to S");
                    Thread.sleep(10);
                }
            } else {
                if(semaphoreNS.availablePermits() == 1) {
                    semaphoreWE.acquire();
                    System.out.println(threadName + " cross the road from W to E");
                    Thread.sleep(10);
                } else {
                    while(semaphoreNS.availablePermits() == 0) {
                        Thread.sleep(10);
                    }
                    semaphoreWE.acquire();
                    System.out.println(threadName + " cross the road from W to E");
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(threadName + " leave the street");
        if (direction)
            semaphoreNS.release();
        else
            semaphoreWE.release();
    }

        @Override
        public void run() {
            if (threadName.equals("A")) {
                this.threadExecute();
            } else if (threadName.equals("B")) {
                this.threadExecute();
            } else if (threadName.equals("C")) {
                this.threadExecute();
            } else if (threadName.equals("D")) {
                this.threadExecute();
            } else if (threadName.equals("E")) {
                this.threadExecute();
            } else {
                this.threadExecute();
            }

        }
    }