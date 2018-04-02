package enitylocker;

import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock l = new ReentrantLock();
        //l.tryLock();
        //l.unlock();
        System.err.println("1>>> " + l.isLocked());
        System.err.println("2>>> " + l.isHeldByCurrentThread());

//        String s1 = "1";
//        String s2 = "2";
//        Thread tr1 = new Thread(() -> {
//            EntityLocker.INSTANCE.lock(s1);
//            try {
//                System.err.println("111111111111111");
//                Thread.sleep(1_000);
//                //EntityLocker.INSTANCE.unlock(s1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "TR1");
//        tr1.start();
//        tr1.join();
//        Thread tr2 = new Thread(() -> {
//            EntityLocker.INSTANCE.lock(s1);
//            try {
//                System.err.println("222222222");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "TR2");
//        tr2.start();
    }
}
