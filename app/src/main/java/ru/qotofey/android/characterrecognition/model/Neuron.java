package ru.qotofey.android.characterrecognition.model;


import ru.qotofey.android.characterrecognition.app.manager.ActivationFunctions;
import ru.qotofey.android.characterrecognition.app.manager.Constants;

public class Neuron {

    private Synapse[] mInputSynapses;

    public Neuron(Synapse[] inputSynapses) {
        mInputSynapses = inputSynapses;
    }

    public Double getSignal() {
        Double sum = 0.0;
        for (int i = 0; i < mInputSynapses.length; i++) {
            sum += mInputSynapses[i].getResult();
        }
        return f(Constants.T + sum);
    }

    public Double getDerivativeSignal() {
        Double sum = 0.0;
        for (int i = 0; i < mInputSynapses.length; i++) {
            sum += (mInputSynapses[i].getResult());
        }
        return derivativeF(Constants.T + sum);
    }

    private Double f(Double x) {
        return ActivationFunctions.bipolar(x); //биполярная
//        return ActivationFunctions.sigmoid(x); //сигмоидальная
//        return ActivationFunctions.ReLU(x); //ReLU
    }

    private Double derivativeF(Double x) {
        return ActivationFunctions.derivativeBipolar(x); //биполярная
//        return ActivationFunctions.derivativeSigmoid(x); //сигмоидальная
//        return ActivationFunctions.derivativeReLU(x); //ReLU
    }

    public Synapse[] getInputSynapses() {
        return mInputSynapses;
    }
}
