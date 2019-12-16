package Neighbor;

import static org.junit.jupiter.api.Assertions.*;

class NeighborTest {

    @org.junit.jupiter.api.Test
    void run() {
        Neighbor n1 = new Neighbor();
        Neighbor n2 = new Neighbor();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n2);

        t1.start();
        t2.start();

        if(n1.getJody() + n2.getJody() <= 100) {
            System.out.println("ok");
        }
    }
}