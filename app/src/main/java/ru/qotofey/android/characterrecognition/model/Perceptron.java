package ru.qotofey.android.characterrecognition.model;

import java.util.ArrayList;
import java.util.List;

import ru.qotofey.android.characterrecognition.app.manager.Constants;
import ru.qotofey.android.characterrecognition.app.manager.Mapper;

public class Perceptron {

    private List<Layer> mLayerList;

    private int mCountLayers;

    public Perceptron(int countLayers) {
        mCountLayers = countLayers;
    }

    public void build(int countInputs, int countOutput) {
        if (mLayerList == null) {
            mLayerList = new ArrayList<>();
            for (int i = 0; i < mCountLayers; i++) {
                if (mCountLayers - 1 == i) {
                    mLayerList.add(new Layer(countInputs, countOutput)); //синапсы у последнего слоя
                } else {
                    mLayerList.add(new Layer(countInputs));
                }
            }
        }
    }

    public Matrix put(Matrix inputs) {
        for (Layer layer : mLayerList) {
            inputs = layer.predictOutputs(inputs);
        }
        return inputs;
    }

    //TODO: потом заприватить
    public void train(Matrix inputs, Matrix expected) {
        Matrix actual = put(inputs);
        //меняем веса в кажом слое
        Matrix errors = actual.difference(expected);

        for (int i = mCountLayers - 1; i >= 0; i--) {
            errors = foreachAllNeurons(mLayerList.get(i), errors);
        }

        double x = 0.0;
        for (int i = 0; i < errors.getRowsCount(); i++) {
            x += errors.get()[0][i] * errors.get()[0][i];
        }
        System.out.println(x);

    }

    private Matrix foreachAllNeurons(Layer layer, Matrix errors) {
        Matrix gradients = Mapper.derivativeSigmoid(layer.getOutputs());
        Matrix deltaWeights = errors.vectorsMultiply(gradients);
        layer.weights = layer.weights.difference(
                deltaWeights
                        .transpose()
                        .multiply(layer.getInputs())
                        .multiply(Constants.H)
                        .transpose()
        );
        return deltaWeights.multiply(layer.weights.transpose());
    }

    public void learn(List<Sample> samples, int epochs) {
        //устанавливаем количество эпох
        for (int i = 0; i < epochs; i++) {
            //прогоняем обучающую выборку
            for (Sample sample : samples) {
                train(
                        new Matrix(sample.getSet()),
                        new Matrix(sample.getExpected())
                );
//                Log.e("TAG", "iteration: " + i);
            }
        }
    }



}


