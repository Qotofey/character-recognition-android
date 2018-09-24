package ru.qotofey.android.characterrecognition.model;

public class Neuron {

    private static final Float A1 = 1.0F;
    private static final Float A2 = -1.0F;
    private static final Float ALPHA = .0F;
    private static final Float T = .0F;

    private Float[] mVector;
    private Float mWeight;

    public Neuron(Float[] inputVector) {
        mVector = inputVector;
    }

    public Float output() {
        Float sum = 0.0F;
        for (int i = 0; i < mVector.length; i++) {
            sum += mVector[i];
        }
        return bipolar(T + sum);
    }

    private Float bipolar(Float x) {
        if (x >= ALPHA) {
            return A1;
        }
        return A2;
    }

    public Float getWeight() {
        return mWeight;
    }

    public void setWeight(Float mWeight) {
        this.mWeight = mWeight;
    }

}
