package ru.qotofey.android.characterrecognition.model;

public class Layer {
    private int countNeurons;

    private Float[] mInputSignals;
    private Neuron[] mNeurons;

    //первый запуск
    public Layer(Float[] inputSignals) {
        mInputSignals = inputSignals;
        int count = mInputSignals.length; //количество синапсов подходящих к каждому нейрону текущего слоя

        countNeurons = count;

        mNeurons = new Neuron[countNeurons];
        for (int i = 0; i < countNeurons; i++) { //присоединяем к каждому нейрону в данном слое синапсы с предыдущего слоя
            Synapse[] synapses = new Synapse[count];

            for (int j = 0; j < count; j++) {
                synapses[j] = new Synapse(mInputSignals[i], 1.0F); //TODO: доделать заполнение матрицы весов
            }

            mNeurons[i] = new Neuron(synapses);
        }

    }

    //второй запуск

    //выходы
    public Float[] getSignals() {
        Float[] signals = new Float[countNeurons];
        for (int i = 0; i < countNeurons; i++) {
            signals[i] = mNeurons[i].getSignal();
        }
        return null;
    }
}
