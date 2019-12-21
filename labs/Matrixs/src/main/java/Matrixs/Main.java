package Matrixs;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int dem = 1000;
        int numberOfThreads = 2;

        Matrix arr1 = new Matrix(dem, dem, 2);
        Matrix arr2 = new Matrix(dem, dem, 3);
        Matrix	summArr = new Matrix(dem, dem, 0);


        Matrix mA = new Matrix(dem, dem, 2);
        Matrix mB = new Matrix(dem, dem, 3);
        Matrix resultM = new Matrix(dem, dem, 0);

        long tm1 = System.currentTimeMillis();
        int index = 0;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            Runnable worker = new Thread(new Multiplication(mA, mB, resultM, index, index += (dem/numberOfThreads)));
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Скорость при многопоточном = " + (System.currentTimeMillis() - tm1));

        // Подсчет одним потоком
        long tm2 = System.currentTimeMillis();

        for (int index1 = 0; index1 < dem; index1++) {
            for (int index2 = 0; index2 < dem; index2++) {
                summArr.getMatrix()[index1][index2] = 0;
                for (int k = 0; k < dem; k++) {
                    summArr.getMatrix()[index1][index2] += arr1.getMatrix()[index1][index2] * arr2.getMatrix()[index2][index1];
                }

            }
        }

        System.out.println("----------");
        System.out.println("Скорость при одном потоке = " + (System.currentTimeMillis() - tm2));

        System.out.println(resultM.compare(summArr));
    }
}
