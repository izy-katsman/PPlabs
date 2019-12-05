package Neighbor;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Neighbor implements Runnable{
    ReentrantLock locker = new ReentrantLock();
    static int progres = 1000;
    private Object lock = new Object();
    private int jodiesInNeighbor = 0;

    public int getJody(){
        return jodiesInNeighbor;
    }

    public void setJody(int jodies) {
            if (progres < jodies)
                jodies = progres;//если хотим взять больще чем есть, то заберем все
            progres -= jodies;
            this.jodiesInNeighbor += jodies;
    }
    public boolean isZero(){
        if(progres != 0)
            return false;
        else
            return true;
    }

    public void run() {
        while (!isZero()) {
            locker.lock();
            try {
                Random rnd = new Random();
                setJody(rnd.nextInt(10));
                System.out.printf("%s %d \n", Thread.currentThread().getName(), jodiesInNeighbor);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                locker.unlock();
            }
        }
    }
}
