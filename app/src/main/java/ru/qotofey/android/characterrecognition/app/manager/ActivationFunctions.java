package ru.qotofey.android.characterrecognition.app.manager;

public class ActivationFunctions {

    //биполярная активационная функция
    public static Float bipolar(Float x) {
        if (x >= Constants.ALPHA) {
            return Constants.A1;
        }
        return Constants.A2;
    }

    //производная биполярной активационной функции
    public static Float derivativeBipolar(Float x) {
        return (x == 0.0F) ? Float.MAX_VALUE : 0.5F;
    }

//    //сигмоидальная активационная функция
//    public static Float sigmoid(Float x) {
//        return 1.0F / (1.0F + (float) Math.exp(Constants.ALPHA * x));
//    }
//
//    //производная сигмоидальной активационной функции
//    public static Float derivativeSigmoid(Float x) {
//        return 0.0F;
//    }


}
