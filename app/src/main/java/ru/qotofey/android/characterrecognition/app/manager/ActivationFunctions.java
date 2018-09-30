package ru.qotofey.android.characterrecognition.app.manager;

public class ActivationFunctions {

    public static Float bipolar(Float x) {
        if (x >= Constants.ALPHA) {
            return Constants.A1;
        }
        return Constants.A2;
    }

//    public static Float sigmoid(Float x) {
//        return 0.0F;
//    }


}
