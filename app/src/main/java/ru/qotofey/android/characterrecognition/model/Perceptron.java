package ru.qotofey.android.characterrecognition.model;

import java.util.List;

import ru.qotofey.android.characterrecognition.app.manager.Constants;

public class Perceptron {

    private Double[] mInputSignals;

    private Double[] mExpectedResults; //текущий ожидаемый результат

    private List<Sample> mSampleList; //все ожидаемые результаты

    private WeightMatrix[] mWeightMatrices;
    private Layer[] mLayers;

    private int mCountLayers;
    private int mCountOutputs;

    //конструктор для продакшена!
    public Perceptron(int countLayers) {
        mCountLayers = countLayers;
        //инициализация слоёв если их нет
        if (mWeightMatrices == null || mLayers == null) {
            mWeightMatrices = new WeightMatrix[mCountLayers];
            mLayers = new Layer[mCountLayers];
        }
    }

    /**
     * инициализация весов
     */
    private void train(Double[] set, Double[] results) {
        mInputSignals = set;

        mExpectedResults = results;

        mCountOutputs = results.length;

        //первый скрытый слой
        mWeightMatrices[0] = new WeightMatrix(mInputSignals);
        mLayers[0] = new Layer(mWeightMatrices[0]);
        //промежуточные скрытые слои
        for (int i = 1; i < mCountLayers - 1; i++) {
            mWeightMatrices[i] = new WeightMatrix(mInputSignals);
            mLayers[i] = new Layer(mWeightMatrices[i]);
        }
        //последний скрытый слой
        mWeightMatrices[mCountLayers - 1] = new WeightMatrix(mLayers[mCountLayers - 2].getSignals(), mCountOutputs);
        mLayers[mCountLayers - 1] = new Layer(mWeightMatrices[mCountLayers - 1]);

//        foreachAllLayers();
    }

    public void train(List<Sample> samples) {
        mSampleList = samples;
        train(samples.get(0).getSet(), samples.get(0).getResult()); //инициализируем веса

    }

    //обучение
    public void learn() {
        //ошибка есть, сеть нужно обучить
        int x = 0;
        do {
            for (int i = 0; i < mSampleList.size(); i++ ) {
                mExpectedResults = mSampleList.get(i).getResult();
                foreachAllLayers();
            }
        } while (checkForErrors());
//        } while (x++ < 1000);
    }

    public Double[] put(Double[] inputSignals) {
        Double[] signals = inputSignals;

        for (int i = 0; i < mLayers.length; i++) {
            mLayers[i].setInputSignals(signals);
            signals = mLayers[i].getSignals();
        }

        return signals;
    }

    public void foreachAllLayers() {
        Double[][] errors = null;
        for (int i = mLayers.length - 1; i >= 0; i--) {
            errors = foreachAllNeurons(mLayers[i], errors);
        }
    }

    private Double[] getOutputSignals() {
        return mLayers[mLayers.length - 1].getSignals();
    }

    public Neuron[] getOutputNeurons() {
        return mLayers[mLayers.length - 1].getNeurons();
    }

    public Double getErrorSum() {
        Double errorSum = 0.0;
        for (int i = 0; i < getOutputNeurons().length; i++) {
            Double value = getOutputNeurons()[i].getSignal() - mExpectedResults[i];
            errorSum += value * value;
        }
        System.out.println("ERROR: " + errorSum);
        return errorSum;
    }

    public Double[][] foreachAllNeurons(Layer layer, Double[][] e) {
        Neuron[] neurons = layer.getNeurons();
        Double[][] errors = new Double[neurons.length][];

        if (e == null) {

            for (int i = 0; i < neurons.length; i++) { //количество нейронов
                errors[i] = new Double[neurons[i].getInputSynapses().length]; //инициализируем массивы ошибок

                for (int j = 0; j < neurons[i].getInputSynapses().length; j++) { //количество синапсов
                    Double weight = layer.getNeurons()[i].getInputSynapses()[j].getWeight();

                    errors[i][j] = 2 * (neurons[i].getSignal() - mExpectedResults[i]) * neurons[i].getDerivativeSignal() * weight; //находим ошибку
                    layer.getNeurons()[i].getInputSynapses()[j].setWeight(weight - Constants.H * errors[i][j]);
                }
            }

        } else {

            for (int i = 0; i < neurons.length; i++) { //количество нейронов
                errors[i] = new Double[neurons[i].getInputSynapses().length]; //инициализируем массивы ошибок
                for (int j = 0; j < neurons[i].getInputSynapses().length; j++) { //количество синапсов
                    Double sum = 0.0;
                    for (int k = 0; k < e.length; k++) {
                        sum = e[k][i];
                    }
                    double weight = layer.getNeurons()[i].getInputSynapses()[j].getWeight();

                    errors[i][j] = sum * neurons[i].getDerivativeSignal() * weight; //находим ошибку
                    layer.getNeurons()[i].getInputSynapses()[j].setWeight(weight - Constants.H * errors[i][j]);
                }
            }
        }

        return errors;
    }

    //проверка ошибки
    public Boolean checkForErrors() {
        Double value = getErrorSum();
        return value > 0.001 || value < -0.001;
    }

}
