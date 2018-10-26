package ru.qotofey.android.characterrecognition.model;

import ru.qotofey.android.characterrecognition.app.manager.Mapper;

public class Layer {

    public Matrix weights;

    private Matrix mInputs;
    private Matrix mOutputs;

    public Layer(int countInputs, int countOutputs) {
        weights = generateWeights(countInputs, countOutputs);
    }

    public Layer(int countInputs) {
        weights = generateWeights(countInputs, countInputs);
    }

    private Matrix generateWeights(int countRows, int countColumns) {
        Double[][] weights = new Double[countRows][countColumns];
        for (int i = 0; i < countRows; i++) {
            for (int j = 0; j < countColumns; j++) {
                weights[i][j] = Math.random() * 10.0 - 5.0;
            }
        }
        return new Matrix(weights);
    }

    public Matrix predictOutputs(Matrix inputs) {
        mInputs = inputs;
        mOutputs = Mapper.sigmoid(mInputs.multiply(this.weights));
        return mOutputs;
    }

    //вызывать только после метода predictOutputs()
    public Matrix getOutputs() {
        return mOutputs;
    }

    //вызывать только после метода predictOutputs()
    public Matrix getInputs() {
        return mInputs;
    }
}
