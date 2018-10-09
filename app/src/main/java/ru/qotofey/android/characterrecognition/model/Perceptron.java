package ru.qotofey.android.characterrecognition.model;

import java.util.List;

import ru.qotofey.android.characterrecognition.app.manager.Constants;

public class Perceptron {

    private Double[] mInputSignals;
    private Double[] mExpectedResults;

    private List<Sample> mSampleList;

    private WeightMatrix[] mWeightMatrices;
    private Layer[] mLayers;

    private int mCountLayers;
    private int mCountOutputs;

    /**
     * ВНИМАНИЕ!!! НИКОГДА НЕ ИСПОЛЬЗУЙТЕ ЭТОТ КОНСТРУКТОР В ПРОДАКШЕНЕ, ОН СОЗДАЛ ИСКЛЮЧИТЕЛЬНО
     * ДЛЯ ТЕСТИРОВАНИЯ!!!
     * Первое требование заключается в том, что никогда нельзя менять количество входных сигналов,
     * пока приложение установлено на телефоне! Если вы программно поменяли количество входов в
     * нейронную сеть - то удалите приложение с вашего смартфона, чтобы почистить ранее сохраненные
     * матрицы синаптический весов.
     * Второе требование - параметр countLayers доджен быть больше или равен двум.
     */
//    public Perceptron(Double[] inputSignals, int countLayers, int countOutputs) {
//        mCountLayers = countLayers;
//        mCountOutputs = countOutputs;
//
//        mInputSignals = inputSignals;
//        //инициализация слоёв
//        mWeightMatrices = new WeightMatrix[mCountLayers];
//        mLayers = new Layer[mCountLayers];
//
//        //первый скрытый слой
//        mWeightMatrices[0] = new WeightMatrix(mInputSignals);
//        mLayers[0] = new Layer(mWeightMatrices[0]);
//        //промежуточные скрытые слови
//        for (int i = 1; i < mCountLayers - 1; i++) {
//            mWeightMatrices[i] = new WeightMatrix(mInputSignals);
//            mLayers[i] = new Layer(mWeightMatrices[i]);
//        }
//        //последний скрытый слой
//        mWeightMatrices[mCountLayers - 1] = new WeightMatrix(mLayers[mCountLayers - 2].getSignals(), mCountOutputs);
//        mLayers[mCountLayers - 1] = new Layer(mWeightMatrices[mCountLayers - 1]);
//    }

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
     * ВНИМАНИЕ!!! НИКОГДА НЕ ИСПОЛЬЗУЙТЕ ЭТОТ МЕТОД В ПРОДАКШЕНЕ, ОН СОЗДАЛ ИСКЛЮЧИТЕЛЬНО
     * ДЛЯ ТЕСТИРОВАНИЯ!!!
     * метод для обучения c одним примером
     */
    public void train(Double[] set, Double[] results) {
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

        //проверяем, следует ли изменить веса
//        foreachAllLayers();
    }

    public void train(List<Sample> samples) {
        mSampleList = samples;
        train(mSampleList.get(0).getSet(), mSampleList.get(0).getResult());
//        for (int i = 1; i < mSampleList.size(); i++) {
//            mInputSignals = mSampleList.get(i).getSet();
//            mExpectedResults = mSampleList.get(i).getResult();
//            mCountOutputs = mSampleList.get(i).getResult().length;
//            foreachAllLayers();
//        }
//        do {
//            for (int i = 0; i < mSampleList.size(); i++) {
//                mInputSignals = mSampleList.get(i).getSet();
//                mExpectedResults = mSampleList.get(i).getResult();
//                mCountOutputs = mSampleList.get(i).getResult().length;
//                foreachAllLayers();
//            }
//        } while (checkForErrors());
    }

    public Double[] put(Double[] inputSignals) {
        Double[] signals = inputSignals;

        for (int i = 0; i < mLayers.length; i++) {
            mLayers[i].setInputSignals(signals);
            signals = mLayers[i].getSignals();
        }

        return signals;
    }

    public Double[] getOutputSignals() {
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
        return errorSum;
    }

    //обучение
    public void learn() {
        if (checkForErrors()) {
            //ошибка есть, сеть нужно обучить

        }
    }

    public void foreachAllLayers() {
//        do {
        //начинаем с последнего слоя
        for (int i = mLayers.length - 1; i >= 0; i--) {
            System.out.println("Слой: " + i + " | нейронов: " + mLayers[i].getNeurons().length);
            foreachAllNeurons(mLayers[i]);
//            break;
        }
//            System.out.println("Ошибка: " + getErrorSum());
//            System.out.println();
//        } while (checkForErrors());
    }

    //
    public Double[][] foreachAllNeurons(Layer layer) {
        Neuron[] neurons = layer.getNeurons();
        Double[][] errors = new Double[neurons.length][];

        System.out.println("Количество нейронов в слое: " + neurons.length);
        System.out.println("Количество синапсов подходящих к нейрону: " + layer.getNeurons()[0].getInputSynapses().length);

        for (int i = 0; i < neurons.length; i++) { //количество нейронов

            errors[i] = new Double[neurons[i].getInputSynapses().length]; //инициализируем массивы ошибок

            for (int j = 0; j < neurons[i].getInputSynapses().length; j++) { //количество синапсов

                errors[i][j] = 2 * (neurons[i].getSignal() - mExpectedResults[i]) * neurons[i].getDerivativeSignal() * neurons[i].getInputSynapses()[j].getWeight(); //находим ошибку
//                System.out.print(" | " + j);
//                System.out.print(" | " + j + " w=" + errors[i][j]);
                layer.getNeurons()[i].getInputSynapses()[j].setWeight(layer.getNeurons()[i].getInputSynapses()[j].getWeight() - Constants.H * errors[i][j]);
                System.out.print(" | " + j + " w=" + (layer.getNeurons()[i].getInputSynapses()[j].getWeight()));
            }
            System.out.println(" | *i = " + i);
        }

        return errors;
    }

    public Double[][] foreachAllNeurons(Layer layer, Double[][] e) {
        Neuron[] neurons = layer.getNeurons();
        Double[][] errors = new Double[neurons.length][];

        System.out.println("Количество нейронов в слое: " + neurons.length);
        System.out.println("Количество синапсов подходящих к нейрону: " + layer.getNeurons()[0].getInputSynapses().length);

        for (int i = 0; i < neurons.length; i++) { //количество нейронов

            errors[i] = new Double[neurons[i].getInputSynapses().length]; //инициализируем массивы ошибок

            for (int j = 0; j < neurons[i].getInputSynapses().length; j++) { //количество синапсов
                Double sum = 0.0;
                for (int k = 0; k < e.length; k++) {
                    sum = e[k][j];
                }
                errors[i][j] = sum * neurons[i].getDerivativeSignal() * neurons[j].getInputSynapses()[j].getWeight(); //находим ошибку
                layer.getNeurons()[i].getInputSynapses()[j].setWeight(layer.getNeurons()[i].getInputSynapses()[j].getWeight() - Constants.H * errors[i][j]);
                System.out.print(" | " + j + " w=" + (layer.getNeurons()[i].getInputSynapses()[j].getWeight()));
            }
            System.out.println(" | *i = " + i);
        }


        return errors;
    }

//        int i = 0;
//        System.out.println("Количество нейронов в слое: " + neurons.length);
//        System.out.println("Количество синапсов подходящих к нейрону: " + layer.getNeurons()[i].getInputSynapses().length);
//
//        Layer returnLayer;

//        //представим, что это последний слой
//        for (i = 0; i < neurons.length; i++) {
//            //для каждого нейрона последнего слоя
//
////            //для каждого нейрона предпоследнего слоя
////            error[i] = 2 * (neurons[i].getSignal() - mExpectedResults[i]) * neurons[i].getDerivativeSignal();
//            for (int j = 0; j < layer.getNeurons()[i].getInputSynapses().length; j++) { //меняем веса синапсов подходящих к одному нейрону
//                error[i] = 2 * (neurons[i].getSignal() - mExpectedResults[i]) * neurons[i].getDerivativeSignal() * neurons[i].getInputSynapses()[j].getWeight();
//                System.out.print(" | " + j);
//                Synapse synapse = layer.getNeurons()[i].getInputSynapses()[j];
//                layer.getNeurons()[i].getInputSynapses()[j].setWeight(synapse.getWeight() - Constants.H * error[i]);
//            }
//            System.out.println(" | *i = " + i);
//        }
//        returnLayer = layer; //слой который мы возвращаем
////////////////////////////////////////////////////////////////////////////////////////////////////




//        for (i = 0; i < getLastLayer().getNeurons().length; i++) {
//            //для каждого нейрона последнего слоя
//            error[i] = 2 * (getLastLayer().getNeurons()[i].getSignal() - mExpectedResults[i]) * getLastLayer().getNeurons()[i].getDerivativeSignal();
//            for (int j = 0; j < getLastLayer().getNeurons()[i].getInputSynapses().length; j++) {
//                Synapse synapse = getLastLayer().getNeurons()[i].getInputSynapses()[j];
//                getLastLayer().getNeurons()[i].getInputSynapses()[j].setWeight(synapse.getWeight() - Constants.H * error[i]);
//            }
//        }
//
//        for (i = 0; i < layer.getNeurons().length; i++) {
////            error[i] = error[i] *
//        }
//        for (i = 0; i < neurons.length; i++) {
//            //для каждого нейрона последнего слоя
//            error[i] = 2 * (neurons[i].getSignal() - mExpectedResults[i]) * neurons[i].getDerivativeSignal();
//            for (int j = 0; j < layer.getNeurons()[i].getInputSynapses().length; j++) { //меняем веса синапсов подходящих к одному нейрону
//                System.out.print(" | " + j);
//                Synapse synapse = layer.getNeurons()[i].getInputSynapses()[j];
//                layer.getNeurons()[i].getInputSynapses()[j].setWeight(synapse.getWeight() - Constants.H * error[i]);
//            }
//            System.out.println("| *i = " + i);
//        }

//
//        return returnLayer;
//    }
//
//    private double mErrorSum = 0.0;
//    private double mPrevErrorSum = 0.0;

    //проверка ошибки
    public Boolean checkForErrors() {
//        mErrorSum = getErrorSum();
//        if (mErrorSum == mPrevErrorSum) {
//            return false;
//        }
//        mPrevErrorSum = mErrorSum;
//        return true;
        Double value = getErrorSum();
        return value > 0.001 || value < -0.001;
    }

    //метод для тестирования
    public Layer getLastLayer() {
        return mLayers[2];
    }

    public Layer getSecondLayer() {
        return mLayers[1];
    }

    public Layer getFirstLayer() {
        return mLayers[0];
    }

}
