package ru.qotofey.android.characterrecognition.model;

public class Synapse {

    private Double mSignal;
    private Double mWeight;

    public Synapse(Double signal, Double weight) {
        mSignal = signal;
        mWeight = weight;
    }

    public Double getResult() {
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
