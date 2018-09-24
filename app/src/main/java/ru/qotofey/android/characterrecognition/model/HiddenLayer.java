package ru.qotofey.android.characterrecognition.model;

public class HiddenLayer {

    private Neuron[] mNeurons;
    private Float[][] mWeights;

    public HiddenLayer(Float[] inputLayer) {
//        mWeights = weights;
        mNeurons = new Neuron[inputLayer.length];
        for (int i = 0; i < inputLayer.length; i++) {
            mNeurons[i] = new Neuron(inputLayer);
        }
    }

}
