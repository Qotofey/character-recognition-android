package ru.qotofey.android.characterrecognition.app.manager;

public class MatrixMath {

    public static Double[][] summarize(Double[][] matrix1, Double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Integer n = matrix1.length;
        Integer m = matrix1[0].length;
        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public static Double[][] summarize(Double[][] matrix, Double x) {
        Double[][] m = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                m[i][j] += x;
            }
        }
        return m;
    }

    public static Double[][] difference(Double[][] matrix1, Double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Integer n = matrix1.length;
        Integer m = matrix1[0].length;
        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public static Double[][] difference(Double x, Double[][] matrix) {
        Integer n = matrix.length;
        Integer m = matrix[0].length;
        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[i][j] = x - matrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static Double[][] difference(Double[][] matrix, Double x) {
        Integer n = matrix.length;
        Integer m = matrix[0].length;
        Double[][] resultMatrix = new Double[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[i][j] = matrix[i][j] - x;
            }
        }
        return resultMatrix;
    }

    public static Double[][] multiply(Double[][] matrix1, Double[][] matrix2) {
        int n1 = matrix1.length;
        int m1 = matrix1[0].length;
        int n2 = matrix2.length;
        int m2 = matrix2[0].length;
        if (n2 != m1) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }

        Double[][] resultMatrix = new Double[n1][m2];

        int row = 0;
        for (int i = 0; i < n1; i++) {
            int col = 0;
            for (int j = 0; j < m2; j++) {
                resultMatrix[row][col] = dot(matrix1[i], T(matrix2)[j]);
                col++;
            }
            row++;
        }
        return resultMatrix;
    }

    public static Double[][] multiply(Double[][] matrix, Double x) {
        Double[][] resultMatrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[i][j] = matrix[i][j] * x;
            }
        }
        return resultMatrix;
    }

    public static Double[][] T(Double[][] matrix) {
        Integer n = matrix.length;
        Integer m = matrix[0].length;
        Double[][] resultMatrix = new Double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[j][i] = matrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static Double dot(Double[] array1, Double[] array2) {
        if (array1.length != array2.length) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Double x = 0.0;
        for (int i = 0; i < array1.length; i++) {
            x += array1[i] * array2[i];
        }
        return x;
    }

    public static Double[][] vectorsMultiply(Double[][] array1, Double[][] array2) {
        int n = array1[0].length;
        if (array1.length > 1 || array2.length > 1 || n != array2[0].length) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Double[][] resultArray = new Double[1][n];
        for (int i = 0; i < n; i++) {
            resultArray[0][i] = array1[0][i] * array2[0][i];
        }
        return resultArray;
    }

    public static Double[][] reshape(int rows, int columns, Double[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n * m != rows * columns) {
            throw new ArithmeticException(); //TODO: можно написать своё исключение
        }
        Double[][] resultMatrix = new Double[rows][columns];
        int k = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[k][l] = matrix[i][j];
                if (l < columns) {
//                    System.out.print(" | " + resultMatrix[k][l]);
                    l++;
                    if (l >= columns) {
//                        System.out.println(" | ");
                        l = 0;
                        k++;
                    }
                }

            }
        }

        return resultMatrix;
    }


}
