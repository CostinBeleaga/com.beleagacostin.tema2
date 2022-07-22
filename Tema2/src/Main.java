import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(1);

        MyThread car1 = new MyThread("A",true, sem1, sem2);
        MyThread car2 = new MyThread("B",true, sem1, sem2);
        MyThread car3 = new MyThread("C",false, sem1, sem2);
        MyThread car4 = new MyThread("D",true, sem1, sem2);
        MyThread car5 = new MyThread("E",false, sem1, sem2);
        MyThread car6 = new MyThread("F",false, sem1, sem2);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car1.join();
        car2.join();
        car3.join();
        car4.join();
        car5.join();
        car6.join();
    }
}
