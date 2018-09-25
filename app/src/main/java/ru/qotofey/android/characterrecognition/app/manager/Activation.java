package ru.qotofey.android.characterrecognition.app.manager;

public class Activation {

    public Float bipolar(Float x) {
        if (x >= Const.ALPHA) {
            return Const.A1;
        }
        return Const.A2;
    }

    public Float sigmoid(Float x) {
        return 0.0F;
    }

}
