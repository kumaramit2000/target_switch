public class ThreadDemo {
    public static void main(String[] args){
//        Hello hello = new Hello();
//        Bye bye = new Bye();
        A1 a = new A1();
        B1 b = new B1();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

//        hello.start();
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        bye.start();
        t2.start();
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