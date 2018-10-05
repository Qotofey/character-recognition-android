package ru.qotofey.android.characterrecognition.model;

public class Sample {

    private Double[] mSet;
    private Double[] mResult;

    public Sample(Double[] set, Double[] result) {
        mSet = set;
        mResult = result;
    }

    public Double[] getSet() {
        return mSet;
    }

    public Double[] getResult() {
        return mResult;
    }
}
