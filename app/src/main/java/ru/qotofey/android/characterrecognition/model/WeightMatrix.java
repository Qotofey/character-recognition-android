package ru.qotofey.android.characterrecognition.model;

import android.util.Log;

public class WeightMatrix {

    private Float[] mSignals;
    private Integer mCountNeurons;
    private Float[][] mWeightMatrix;

    public WeightMatrix(Float[] inputSignals, int countNeurons) {
        mSignals = inputSignals;
        mCountNeurons = countNeurons;
        mWeightMatrix = new Float[mSignals.length][countNeurons];
        Log.i("Weight Matrix", "Weight Matrix");
        for (int i = 0; i < mWeightMatrix.length; i++) {
            for (int j = 0; j < mWeightMatrix[i].length; j++) {
                mWeightMatrix[i][j] = (float) Math.random() * 2.0F - 1.0F;
                Log.e("weight[" + i + "][" + j + "] = ", "" + mWeightMatrix[i][j]);
            }
        }
    }

    public WeightMatrix(Float[] inputSignals) {
        this(inputSignals, inputSignals.length);
    }

    public Float[] getSignals() {
        return mSignals;
    }

    public Integer getCountNeurons() {
        return mCountNeurons;
    }

    public Float[][] get() {
        return mWeightMatrix;
    }
}
