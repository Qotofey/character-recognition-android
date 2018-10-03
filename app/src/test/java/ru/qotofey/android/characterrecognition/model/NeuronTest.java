package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static junit.framework.TestCase.assertTrue;

public class NeuronTest {

    private Synapse[] mSynapses = new Synapse[15];
    private Neuron mNeuron;

    @Rule
    public Timeout timeout = new Timeout(15);

    @Before
    public void setUp() {
        mSynapses[0] = new Synapse(-1.0, -0.0001);
        mSynapses[1] = new Synapse(-1.0, 0.3451);
        mSynapses[2] = new Synapse(1.0, -0.4231);
        mSynapses[3] = new Synapse(-1.0, -0.0001);
        mSynapses[4] = new Synapse(-1.0, 0.340041);
        mSynapses[5] = new Synapse(1.0, -0.4532);
        mSynapses[6] = new Synapse(-1.0, -0.34356);
        mSynapses[7] = new Synapse(-1.0, 0.04543);
        mSynapses[8] = new Synapse(1.0, -0.311);
        mSynapses[9] = new Synapse(-1.0, -0.9001);
        mSynapses[10] = new Synapse(-1.0, 0.0999001);
        mSynapses[11] = new Synapse(1.0, 0.123001);
        mSynapses[12] = new Synapse(-1.0, 0.034201);
        mSynapses[13] = new Synapse(-1.0, 0.0);
        mSynapses[14] = new Synapse(1.0, -0.999001);

        mNeuron = new Neuron(mSynapses);
    }

    @Test
    public void getSignal() {
        assertTrue(mNeuron.getSignal() > -1.0 && mNeuron.getSignal() < 1.0);
    }

    @Test
    public void getDerivativeSignal() {
        assertTrue(mNeuron.getDerivativeSignal() > -1.0 && mNeuron.getDerivativeSignal() < 1.0);
    }

    @After
    public void tearDown() throws Exception {
        mSynapses = null;
        mNeuron = null;
    }
}