package ru.qotofey.android.characterrecognition.app.manager;

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

}
