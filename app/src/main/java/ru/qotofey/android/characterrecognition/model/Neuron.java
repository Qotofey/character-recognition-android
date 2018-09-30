package ru.qotofey.android.characterrecognition.model;


import ru.qotofey.android.characterrecognition.app.manager.ActivationFunctions;
import ru.qotofey.android.characterrecognition.app.manager.Constants;

public class Neuron {

    private Synapse[] mInputSynapses;

    public Neuron(Synapse[] inputSynapses) {
        mInputSynapses = inputSynapses;
    }

    public Float getSignal() {
        Float sum = 0.0F;
        for (int i = 0; i < mInputSynapses.length; i++) {
            sum += (mInputSynapses[i].getResult());
        }
        return f(Constants.T + sum);
    }

    private Float f(Float x) {
        return ActivationFunctions.bipolar(x);
    }



}
