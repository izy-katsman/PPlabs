package Matrixs;

public class Multiplication extends Thread {

    private int[][] arr1;
    private int[][] arr2;
    private int[][] mulArr;
    private int begin;
    private int end;
    private int dimensionA;
    private int dimensionB;
    private int dimension;

    public Multiplication(int[][] arr1, int[][] arr2, int[][] summArr, int begin, int end, int dimension) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.mulArr = summArr;
        this.begin = begin;
        this.end = end;
        this.dimension = dimension;
    }

    public Multiplication(Matrix mA, Matrix mB, Matrix resultM, int begin, int end) {
        this.arr1 = mA.getMatrix();
        this.arr2 = mB.getMatrix();
        this.mulArr = resultM.getMatrix();
        this.begin = begin;
        this.end = end;
        if(mA.getHeight() == mB.getLengthen()){
            this.dimension = mA.getLengthen();
        }
        //todo насчет демишион тут надо проверять если не квадратные
    }
    public void run() {
        System.out.println(this.getName());
        System.out.println(begin + " " + end);
        long tm1 = System.currentTimeMillis();
        for (int index1 = begin; index1 < end; index1++) {
            for (int index2 = 0; index2 < dimension; index2++) {
                mulArr[index1][index2] = 0;
                for (int k = 0; k < dimension; k++) {
                    mulArr[index1][index2] += arr1[index1][index2] * arr2[index2][index1];
                }
            }
        }
        System.out.println(System.currentTimeMillis() - tm1);
    }
}
