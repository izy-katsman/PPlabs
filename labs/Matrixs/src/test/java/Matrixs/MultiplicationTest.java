package Matrixs;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    @Test
    void run() {
        int dem = 10;
        Matrix arr1 = new Matrix(dem, dem, 2);
        Matrix arr2 = new Matrix(dem, dem, 3);
        Matrix	summArr = new Matrix(dem, dem, 0);

        for (int index1 = 0; index1 < dem; index1++) {
            for (int index2 = 0; index2 < dem; index2++) {
                summArr.getMatrix()[index1][index2] = 0;
                for (int k = 0; k < dem; k++) {
                    summArr.getMatrix()[index1][index2] += arr1.getMatrix()[index1][index2] * arr2.getMatrix()[index2][index1];
                }
            }
        }


        Matrix mA = new Matrix(dem, dem, 2);
        Matrix mB = new Matrix(dem, dem, 3);
        Matrix resultM = new Matrix(dem, dem, 0);

        long tm1 = System.currentTimeMillis();
        int index = 0;
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 1; i++) {
            Runnable worker = new Thread(new Multiplication(mA, mB, resultM, index, index += (dem/1)));
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        assertArrayEquals(summArr.getMatrix(), resultM.getMatrix());
    }
}