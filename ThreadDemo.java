import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {
    public static void main(String[] args) throws Exception{
//        Hello hello = new Hello();
//        Bye bye = new Bye();
//        A1 a = new A1();
//        B1 b = new B1();
//
//        Thread t1 = new Thread(a);
//        Thread t2 = new Thread(b);

//        hello.start();
//        t1.start();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        bye.start();
//        t2.start();
//        t1.setName("A1 changes to A2");
        Counter c = new Counter();
        Thread c1 = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<1000;i++){
                    c.increment1();
                }
            }
        });

        Thread c2 = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<1000;i++){
                    c.increment1();
                }
            }
        });


        c1.start();
        c2.start();

        c1.join();
        c2.join();

        System.out.println("Value of count is - "+c.count1);

    }
}

class Hello extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Bye extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Bye");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class A1 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B1 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Counter{
    int count;
    AtomicInteger count1 = new AtomicInteger();
    // Here now increment() is thread safe. Only 1 thread can work at a time.
    public synchronized void increment(){
        count++;
    }

    public void increment1(){
        count1.incrementAndGet();
    }
}