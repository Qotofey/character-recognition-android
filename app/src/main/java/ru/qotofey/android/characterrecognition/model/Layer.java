package ru.qotofey.android.characterrecognition.model;

public class Layer {
    private int mCountNeurons;

    private Double[] mInputSignals;
    private Neuron[] mNeurons;

    private Double[][] mWeightMatrix;

    public Layer(WeightMatrix weightMatrix) {
        mWeightMatrix = weightMatrix.get();

        mInputSignals = weightMatrix.getSignals();
        int count = mInputSignals.length; //количество синапсов подходящих к каждому нейрону текущего слоя

        mCountNeurons = weightMatrix.getCountNeurons();
        //создаём массив нейронов в слое
        mNeurons = new Neuron[mCountNeurons];
        for (int i = 0; i < mCountNeurons; i++) { //присоединяем к каждому нейрону в данном слое синапсы с предыдущего слоя
            Synapse[] synapses = new Synapse[count];
            for (int j = 0; j < count; j++) {
                synapses[j] = new Synapse(mInputSignals[i], weightMatrix.get()[j][i]);
            }
            mNeurons[i] = new Neuron(synapses);
        }
    }

    public Neuron[] getNeurons() {
        return mNeurons;
    }

    //выходы
    public Double[] getSignals() {
        Double[] signals = new Double[mCountNeurons];
        for (int i = 0; i < mCountNeurons; i++) {
            signals[i] = mNeurons[i].getSignal();
        }
        return signals;
    }

    public Double[][] getWeightMatrix() {
        return mWeightMatrix;
    }

}
