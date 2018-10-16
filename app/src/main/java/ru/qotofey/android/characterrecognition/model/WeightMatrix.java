package ru.qotofey.android.characterrecognition.model;

public class WeightMatrix {

    private Double[] mSignals;
    private Integer mCountNeurons;
    private Double[][] mWeightMatrix;

    public WeightMatrix(Double[] inputSignals, int countNeurons) {
        mSignals = inputSignals;
        mCountNeurons = countNeurons;
        mWeightMatrix = new Double[countNeurons][mSignals.length];
        for (int i = 0; i < mWeightMatrix.length; i++) {
            for (int j = 0; j < mWeightMatrix[i].length; j++) {
                mWeightMatrix[i][j] = Math.random() * 1.0 - 0.5;
//                mWeightMatrix[i][j] = Math.random() * 1.0;
//                mWeightMatrix[i][j] = .1;
            }
        }
    }

    public WeightMatrix(Double[] signals, Integer countNeurons, Double[][] weightMatrix) {
        mSignals = signals;
        mCountNeurons = countNeurons;
        mWeightMatrix = weightMatrix;
    }

    public WeightMatrix(Double[] inputSignals) {
        this(inputSignals, inputSignals.length);
    }

    public Double[] getSignals() {
        return mSignals;
    }

    public Integer getCountNeurons() {
        return mCountNeurons;
    }

    public Double[][] get() {
        return mWeightMatrix;
    }
}
