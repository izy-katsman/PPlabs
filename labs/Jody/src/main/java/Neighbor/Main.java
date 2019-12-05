package Neighbor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    Neighbor n1 = new Neighbor();
    Neighbor n2 = new Neighbor();

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n2);

        t1.start();
        t2.start();

    }
}
