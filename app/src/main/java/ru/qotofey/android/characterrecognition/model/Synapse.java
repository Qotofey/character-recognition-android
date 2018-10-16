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

    public void setSignal(Double signal) {
        mSignal = signal;
    }

    public void setWeight(Double weight) {
        mWeight = weight;
    }

    public Double getWeight() {
        return mWeight;
    }

    public Double getSignal() {
        return mSignal;
    }
}
