package ru.qotofey.android.characterrecognition.app.manager;

import java.util.List;

import ru.qotofey.android.characterrecognition.model.HiddenLayer;

public class Perceptron {

    private Float[] mInputLayer;
    private List<HiddenLayer> mHiddenLayers;

    public Perceptron(Float[] inputLayer) {
        mInputLayer = inputLayer;
        mHiddenLayers.add(new HiddenLayer(inputLayer));
//        mHiddenLayers.add(new HiddenLayer(mHiddenLayers.get(0)));

    }

}
