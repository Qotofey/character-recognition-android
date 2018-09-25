package ru.qotofey.android.characterrecognition.model;

public class Synapse {

    private Float mSignal;
    private Float mWeight;

    public Synapse(Float signal, Float weight) {
        mSignal = signal;
        mWeight = weight;
    }

    public Float getResult() {
        return mSignal * mWeight;
    }

//    public Float getSignal() {
//        return mSignal;
//    }
//
//    public void setSignal(Float signal) {
//        mSignal = signal;
//    }
//
//    public Float getWeight() {
//        return mWeight;
//    }
//
//    public void setWeight(Float weight) {
//        mWeight = weight;
//    }
}
