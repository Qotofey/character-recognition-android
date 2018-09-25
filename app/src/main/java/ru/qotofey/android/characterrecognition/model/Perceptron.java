package ru.qotofey.android.characterrecognition.model;

import ru.qotofey.android.characterrecognition.model.Layer;

public class Perceptron {

    private static final int[] SYMBOLS = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private Float[] mInputSignals;
    private Layer[] mLayers = new Layer[2];

    public Perceptron(Float[] inputSignals) {
        mInputSignals = inputSignals;

        mLayers[0] = new Layer(mInputSignals);

        mLayers[1] = new Layer(mLayers[0].getSignals());
    }

}
