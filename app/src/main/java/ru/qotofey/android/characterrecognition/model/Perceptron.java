package ru.qotofey.android.characterrecognition.model;

import ru.qotofey.android.characterrecognition.app.manager.ActivationFunctions;
import ru.qotofey.android.characterrecognition.app.manager.Constants;

public class Perceptron {

    private Double[] mInputSignals;
    private Double[] mExpectedResults;


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
    public Perceptron(Double[] inputSignals, int countLayers, int countOutputs) {
        mCountLayers = countLayers;
        mCountOutputs = countOutputs;

        mInputSignals = inputSignals;
        //инициализация слоёв
        mWeightMatrices = new WeightMatrix[mCountLayers];
        mLayers = new Layer[mCountLayers];

        //первый скрытый слой
        mWeightMatrices[0] = new WeightMatrix(mInputSignals);
        mLayers[0] = new Layer(mWeightMatrices[0]);
        //промежуточные скрытые слови
        for (int i = 1; i < mCountLayers - 1; i++) {
            mWeightMatrices[i] = new WeightMatrix(mInputSignals);
            mLayers[i] = new Layer(mWeightMatrices[i]);
        }
        //последний скрытый слой
        mWeightMatrices[mCountLayers - 1] = new WeightMatrix(mLayers[mCountLayers - 2].getSignals(), mCountOutputs);
        mLayers[mCountLayers - 1] = new Layer(mWeightMatrices[mCountLayers - 1]);
    }

    //конструктор для продакшена!
    public Perceptron(int countLayers) {
        mCountLayers = countLayers;
    }

    public void train(Double[] set, Double[] results) {
        mInputSignals = set;

        mExpectedResults = results;

        mCountOutputs = results.length;

        //инициализация слоёв если их нет
        if (mWeightMatrices == null || mLayers == null) {
            mWeightMatrices = new WeightMatrix[mCountLayers];
            mLayers = new Layer[mCountLayers];
        }

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
//        changeWeightMatrix();

    }

    public Double[] put(Double[] inputSignals) {


        return null;
    }

    public Double[] getOutputSignals() {
        return mLayers[mLayers.length - 1].getSignals();
    }

    public Neuron[] getOutputNeurons() {
        return mLayers[mLayers.length - 1].getNeurons();
    }

    private void changeWeightMatrix() {
        //проверяем, следует ли изменить веса
        Double errorSum = 0.0;
//        do {

            errorSum = this.getErrorSum();
//            Log.e("error: ", "" + errorSum);
            if (errorSum != 0.0F) {
                //слои
//                for (int iter = mWeightMatrices.length - 1; iter >= 0; iter--) { //только один слой
                    //нейроны из одного слоя
                    for (int i = 0; i < mInputSignals.length; i++) {
                        //теперь исправляем веса для одного нейрона
                        Double[] errors = new Double[getOutputSignals().length];
                        for (int j = 0; j < getOutputSignals().length; j++) {
                            //находим производную нашей ступенчатой функции
                            Double s = 0.0;
                            for (int k = 0; k < mInputSignals.length; k++) {
                                s += mWeightMatrices[1].get()[i][j] * Double.MAX_VALUE;
                            }
                            errors[j] = 2 * (getOutputSignals()[j] - mExpectedResults[j]) * ActivationFunctions.derivativeBipolar(s);
                            mWeightMatrices[1].get()[i][j] -= Constants.H * errors[j]; //изменяем синаптический вес
                        }
                    }
//                }

            }
//        } while (errorSum != 0.0F);
    }

    public Double getErrorSum() {
        Double errorSum = 0.0;
        for (int i = 0; i < getOutputNeurons().length; i++) {
//            System.out.print("y[" + i + "] = " + getOutputNeurons()[i].getSignal());
//            System.out.println(" | Y[" + i + "] = " + mExpectedResults[i]);
            Double value = getOutputNeurons()[i].getSignal() - mExpectedResults[i];
            errorSum += value * value;
        }
        return errorSum;
    }

//    public Float sum
//    public

    //обучение
    public void learn() {
        if (checkForErrors()) {
            //ошибка есть, сеть нужно обучить

        }
    }

    public void foreachAllLayers() {
        //начинаем с последнего слоя
        for (int i = mLayers.length - 1; i >= 0; i--) {
            System.out.print("Слой: " + i);
            System.out.println(" | нейронов: " + mLayers[i].getNeurons().length);
            foreachAllNeurons(mLayers[i]);

        }
        System.out.println("Ошибка: " + getErrorSum());
        System.out.println();

    }

    public void foreachAllNeurons(Layer layer) {
        Neuron[] neurons = layer.getNeurons();
        Double[] error = new Double[neurons.length];
//        do {

//        System.out.println("Количество нейронов: " + neurons.length);
//        System.out.println("Количество строк: " + layer.getWeightMatrix().length);
//        System.out.println("Количество элементов: " + layer.getWeightMatrix()[0].length);
//        do {
//
//        System.out.println("!!!Ошибка: " + getErrorSum());
        //первый слой
//            System.out.println(getErrorSum());
        for (int i = 0; i < neurons.length; i++) {
            //для каждого нейрона последнего слоя
            error[i] = 2 * (neurons[i].getSignal() - mExpectedResults[i]) * neurons[i].getDerivativeSignal();
            for (int j = 0; j < layer.getNeurons()[i].getInputSynapses().length; j++) { //меняем веса синапсов подходящих к одному нейрону
                Synapse synapse = layer.getNeurons()[i].getInputSynapses()[j];
                layer.getNeurons()[i].getInputSynapses()[j].setWeight(synapse.getWeight() - Constants.H * error[i]);
            }
        }
        //второй слой



//        } while (checkForErrors());
        System.out.println("y1 = " + layer.getNeurons()[0].getSignal());
        System.out.println("y2 = " + layer.getNeurons()[1].getSignal());
    }

    //проверка ошибки
    public Boolean checkForErrors() {
        Double value = getErrorSum();
//        return value != 0.0;
        return value > 0.001 || value < -0.001;
    }

    //метод для тестирования
    public Layer getLastLayer() {
        return mLayers[1];
    }

}
