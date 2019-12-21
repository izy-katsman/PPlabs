package Matrixs;

import org.jetbrains.annotations.NotNull;

public class Matrix {
    private int length;
    private int height;
    private int[][] matrix;

    public int getLengthen() {
        return length;
    }

    public void setLengthen(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Matrix(int length, int height, int value){
        this.length = length;
        this.height = height;
        this.matrix = new int[length][height];

        for(int index1 = 0; index1 < height; index1++) {
            for(int  index2 = 0; index2 < length; index2++) {
                matrix[index1][index2] = value;
            }
        }
    }

    public int [][] getMatrix() {
        return matrix;
    }

    public boolean compare(@org.jetbrains.annotations.NotNull int[][] arr) {
        if(this.getLengthen() == arr[0].length && this.getHeight() == arr.length) {
            for (int i = 0; i < this.getLengthen(); i++) {
                for (int j = 0; j < this.getHeight(); j++) {
                    if(this.matrix[i][j] != arr[i][j])
                        return false;
                }
            }
            return true;
        }
        else
            return false;
    }



    public boolean compare(@NotNull Matrix arr) {
        if(this.getLengthen() == arr.matrix[0].length && this.getHeight() == arr.length) {
            for (int i = 0; i < this.getLengthen(); i++) {
                for (int j = 0; j < this.getHeight(); j++) {
                    if(this.matrix[i][j] != arr.matrix[i][j])
                        return false;
                }
            }
            return true;
        }
        else
            return false;
    }
}