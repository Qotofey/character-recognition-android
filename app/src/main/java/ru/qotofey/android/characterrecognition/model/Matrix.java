package ru.qotofey.android.characterrecognition.model;

public class Matrix {

    private Double[][] mMatrix;

    public Matrix(Double[][] matrix) {
        mMatrix = matrix;
    }

    public Matrix transpose() {
        Integer n = mMatrix.length;
        Integer m = mMatrix[0].length;
        Double[][] resultMatrix = new Double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[j][i] = mMatrix[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix add(Matrix matrix) {
        if (mMatrix.length != matrix.get().length || mMatrix[0].length != matrix.get()[0].length) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Integer n = mMatrix.length;
        Integer m = mMatrix[0].length;
        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = mMatrix[i][j] + matrix.get()[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix difference(Matrix matrix) {
//        System.out.println(mMatrix.length);
//        System.out.println(matrix.get().length);
//        System.out.println(mMatrix[0].length);
//        System.out.println(matrix.get()[0].length);

        if (mMatrix.length != matrix.get().length || mMatrix[0].length != matrix.get()[0].length) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }

        Integer n = mMatrix.length;
        Integer m = mMatrix[0].length;
        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = mMatrix[i][j] - matrix.get()[i][j];
            }
        }

        return new Matrix(resultMatrix);
    }

    public Matrix difference(Double x) {
        Integer n = mMatrix.length;
        Integer m = mMatrix[0].length;
        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = mMatrix[i][j] - x;
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix multiply(Matrix matrix) {
        int n1 = mMatrix.length;
        int m1 = mMatrix[0].length;
        int n2 = matrix.get().length;
        int m2 = matrix.get()[0].length;
        if (n2 != m1) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Double[][] resultMatrix = new Double[n1][m2];
        int row = 0;
        for (int i = 0; i < n1; i++) {
            int col = 0;
            for (int j = 0; j < m2; j++) {
                Double x = 0.0;
                for (int k = 0; k < mMatrix[i].length; k++) {
                    x += mMatrix[i][k] * matrix.transpose().get()[j][k];
                }
                resultMatrix[row][col] = x;
                col++;
            }
            row++;
        }
        return new Matrix(resultMatrix);
    }

    public Matrix multiply(Double x) {
        int n = mMatrix.length;
        int m = mMatrix[0].length;

        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = mMatrix[i][j] * x;
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix vectorsMultiply(Matrix matrix) {
        int n = mMatrix[0].length;
        if (mMatrix.length > 1 || matrix.get().length > 1 || n != matrix.get()[0].length) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Double[][] resultArray = new Double[1][n];
        for (int i = 0; i < n; i++) {
            resultArray[0][i] = mMatrix[0][i] * matrix.get()[0][i];
        }
        return new Matrix(resultArray);
    }

    public Double[][] get() {
        return mMatrix;
    }

    public int getRowsCount() {
        return mMatrix.length;
    }

    public int getColumnsCount() {
        return mMatrix[0].length;
    }

    public Matrix println() {
        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                System.out.print("| " + mMatrix[i][j] + " ");
            }
            System.out.println("| ");
        }
        System.out.println();
        return new Matrix(mMatrix);
    }
}
