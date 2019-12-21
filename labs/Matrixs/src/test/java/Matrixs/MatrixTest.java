package Matrixs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void getMatrix() {
        Matrix a = new Matrix(10, 10, 2);
        int[][] arr = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = 2;
            }
        }
        assertArrayEquals(a.getMatrix(), arr);
    }
}