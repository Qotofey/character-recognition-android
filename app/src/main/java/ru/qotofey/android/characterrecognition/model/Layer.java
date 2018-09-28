package ru.qotofey.android.characterrecognition.model;

public class Layer {
    protected int mCountNeurons;

    protected Float[] mInputSignals;
    protected Neuron[] mNeurons;

    //первый запуск
    public Layer(Float[] inputSignals) {
        mInputSignals = inputSignals;
        int count = mInputSignals.length; //количество синапсов подходящих к каждому нейрону текущего слоя

        mCountNeurons = count;

        mNeurons = new Neuron[mCountNeurons];
        for (int i = 0; i < mCountNeurons; i++) { //присоединяем к каждому нейрону в данном слое синапсы с предыдущего слоя
            Synapse[] synapses = new Synapse[count];

            for (int j = 0; j < count; j++) {
                synapses[j] = new Synapse(mInputSignals[i], (float) Math.random() * 2 - 1); //TODO: доделать заполнение матрицы весов
//                synapses[j] = new Synapse(mInputSignals[i], 1.0F); //TODO: доделать заполнение матрицы весов
            }

            mNeurons[i] = new Neuron(synapses);
        }
    }

    public Layer(Float[] inputSignals, int countOutput) {
        mInputSignals = inputSignals;
        int count = mInputSignals.length; //количество синапсов подходящих к каждому нейрону текущего слоя

        mCountNeurons = countOutput;
        //создаём массив нейронов в слое
        mNeurons = new Neuron[mCountNeurons];
        for (int i = 0; i < mCountNeurons; i++) { //присоединяем к каждому нейрону в данном слое синапсы с предыдущего слоя
            Synapse[] synapses = new Synapse[count];
            for (int j = 0; j < count; j++) {
                synapses[j] = new Synapse(mInputSignals[i], (float) Math.random() * 2 - 1); //TODO: доделать заполнение матрицы весов
            }
            mNeurons[i] = new Neuron(synapses);
        }
    }

    public Layer(WeightMatrix weightMatrix) {
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

    //второй запуск

    //выходы
    public Float[] getSignals() {
        Float[] signals = new Float[mCountNeurons];
        for (int i = 0; i < mCountNeurons; i++) {
            signals[i] = mNeurons[i].getSignal();
        }
        return signals;
    }
}
