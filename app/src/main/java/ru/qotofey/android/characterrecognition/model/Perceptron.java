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
        changeWeightMatrix();

    }

    public Double[] put(Double[] inputSignals) {


        return null;
    }

    public Double[] getOutput() {
        return mLayers[mLayers.length - 1].getSignals();
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
                        Double[] errors = new Double[getOutput().length];
                        for (int j = 0; j < getOutput().length; j++) {
                            //находим производную нашей ступенчатой функции
                            Double s = 0.0;
                            for (int k = 0; k < mInputSignals.length; k++) {
                                s += mWeightMatrices[1].get()[i][j] * Double.MAX_VALUE;
                            }
                            errors[j] = 2 * (getOutput()[j] - mExpectedResults[j]) * ActivationFunctions.derivativeBipolar(s);
                            mWeightMatrices[1].get()[i][j] -= Constants.H * errors[j]; //изменяем синаптический вес
                        }
                    }
//                }

            }
//        } while (errorSum != 0.0F);
    }

    private Double getErrorSum() {
        Double errorSum = 0.0;
        for (int i = 0; i < getOutput().length; i++) {
            errorSum += (getOutput()[i] - mExpectedResults[i]) * (getOutput()[i] - mExpectedResults[i]);
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

    public void foreachAllLayer() {



    }

    public void foreachAllNeurons(Layer layer) {
        Neuron[] neurons = layer.getNeurons();
        Double[] error = new Double[neurons.length];

//        System.out.println("Количество нейронов: " + neurons.length);
//        System.out.println("Количество строк: " + layer.getWeightMatrix().length);
//        System.out.println("Количество элементов: " + layer.getWeightMatrix()[0].length);
        System.out.println("Ошибка: " + getErrorSum());

        for (int i = 0; i < neurons.length; i++) {
            //для каждого нейрона последнего слоя
            error[i] = 2 * (neurons[i].getSignal() - mExpectedResults[i]) * neurons[i].getDerivativeSignal();
//            System.out.println("error[" + i + "]: " + error[i]);
            for (int j = 0; j < layer.getWeightMatrix().length; j++) { //меняем веса синапсов подходящих к одному нейрону
//                System.out.print("w[" + j + ", " + i + "]: " + layer.getWeightMatrix()[j][i]);
                layer.getWeightMatrix()[j][i] -= Constants.H * error[i];
//                System.out.println(" | w[" + j + ", " + i + "]: " + layer.getWeightMatrix()[j][i]);
            }

        }
    }

    //проверка ошибки
    public Boolean checkForErrors() {
        return getErrorSum() != 0.0;
    }

    public Layer getLastLayer() {
        return mLayers[1];
    }

}
