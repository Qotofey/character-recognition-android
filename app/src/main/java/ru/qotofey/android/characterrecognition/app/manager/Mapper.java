package ru.qotofey.android.characterrecognition.app.manager;

import ru.qotofey.android.characterrecognition.model.Matrix;

public class Mapper {

    public static Double[][] sigmoid(Double[][] matrix) {
        Double[][] resultMatrix = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = ActivationFunctions.sigmoid(matrix[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Double[][] derivativeSigmoid(Double[][] matrix) {
        Double[][] resultMatrix = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = ActivationFunctions.derivativeSigmoid(matrix[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Matrix sigmoid(Matrix matrix) {
        Matrix resultMatrix = matrix;
        int n = matrix.getRowsCount();
        int m = matrix.getColumnsCount();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix.get()[i][j] = ActivationFunctions.sigmoid(matrix.get()[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Matrix derivativeSigmoid(Matrix matrix) {
        Matrix resultMatrix = matrix;
        int n = matrix.getRowsCount();
        int m = matrix.getColumnsCount();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix.get()[i][j] = ActivationFunctions.derivativeSigmoid(matrix.get()[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Double[][] bipolar(Double[][] matrix) {
        Double[][] resultMatrix = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = ActivationFunctions.bipolar(matrix[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Double[][] derivativeBipolar(Double[][] matrix) {
        Double[][] resultMatrix = matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = ActivationFunctions.derivativeBipolar(matrix[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Matrix bipolar(Matrix matrix) {
        Matrix resultMatrix = matrix;
        int n = matrix.getRowsCount();
        int m = matrix.getColumnsCount();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix.get()[i][j] = ActivationFunctions.bipolar(matrix.get()[i][j]);
            }
        }
        return resultMatrix;
    }

    public static Matrix derivativeBipolar(Matrix matrix) {
        Matrix resultMatrix = matrix;
        int n = matrix.getRowsCount();
        int m = matrix.getColumnsCount();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix.get()[i][j] = ActivationFunctions.derivativeBipolar(matrix.get()[i][j]);
            }
        }
        return resultMatrix;
    }

}
