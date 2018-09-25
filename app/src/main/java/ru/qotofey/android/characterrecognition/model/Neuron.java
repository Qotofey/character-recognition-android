package ru.qotofey.android.characterrecognition.model;


public class Neuron {

    private static final Float A1 = 1.0F;
    private static final Float A2 = -1.0F;
    private static final Float ALPHA = .0F;
    private static final Float T = .0F;

    private Synapse[] mInputSynapses;

    public Neuron(Synapse[] inputSynapses) {
        mInputSynapses = inputSynapses;
    }

    public Float getSignal() {
        Float sum = 0.0F;
        for (int i = 0; i < mInputSynapses.length; i++) {
            sum += (mInputSynapses[i].getResult());
        }
        return bipolar(T + sum);
    }

    private Float bipolar(Float x) {
        if (x >= ALPHA) {
            return A1;
        }
        return A2;
    }

}
