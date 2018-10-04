package ru.qotofey.android.characterrecognition.app.manager;

public class ActivationFunctions {

    //биполярная (гиперболический тангенс) активационная функция
    public static Double bipolar(Double x) {
        return Math.tanh(x / Constants.ALPHA);
    }

    //производная биполярной активационной функции
    public static Double derivativeBipolar(Double x) {
        Double value = Math.cosh(x / Constants.ALPHA);
        return 1.0 / (value * value);
    }

    //сигмоидальная активационная функция
    public static Double sigmoid(Double x) {
        return 1.0 / (1.0 + Math.exp(Constants.ALPHA * x));
    }

    //производная сигмоидальной активационной функции
    public static Double derivativeSigmoid(Double x) {
        return 0.0; //TODO: вычислить производную сигмоидальной функции
    }

    //активационная функция ReLU
    public static Double ReLU(Double x) {
        return (x >= 0.0F) ? Constants.ALPHA * x : 0.0F;
    }

    //производная активационной функции ReLU
    public static Double derivativeReLU(Double x) {
        return (x >= 0.0F) ? Constants.ALPHA : 0.0F;
    }


}
