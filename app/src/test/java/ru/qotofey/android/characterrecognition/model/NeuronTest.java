package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static junit.framework.TestCase.assertEquals;

public class NeuronTest {

    private Synapse[] mSynapses = new Synapse[15];
    private Neuron mNeuron;

    @Rule
    public Timeout timeout = new Timeout(10);

    @Before
    public void setUp() {
        mSynapses[0] = new Synapse(-1.0F, -0.0001F);
        mSynapses[1] = new Synapse(-1.0F, 0.3451F);
        mSynapses[2] = new Synapse(1.0F, -0.4231F);
        mSynapses[3] = new Synapse(-1.0F, -0.0001F);
        mSynapses[4] = new Synapse(-1.0F, 0.340041F);
        mSynapses[5] = new Synapse(1.0F, -0.4532F);
        mSynapses[6] = new Synapse(-1.0F, -0.34356F);
        mSynapses[7] = new Synapse(-1.0F, 0.04543F);
        mSynapses[8] = new Synapse(1.0F, -0.311F);
        mSynapses[9] = new Synapse(-1.0F, -0.9001F);
        mSynapses[10] = new Synapse(-1.0F, 0.0999001F);
        mSynapses[11] = new Synapse(1.0F, 0.123001F);
        mSynapses[12] = new Synapse(-1.0F, 0.034201F);
        mSynapses[13] = new Synapse(-1.0F, 0.0F);
        mSynapses[14] = new Synapse(1.0F, -0.999001F);

        mNeuron = new Neuron(mSynapses);
    }

    @Test
    public void getSignal() {
        assertEquals(mNeuron.getSignal(), -1.0F);
    }

    @After
    public void tearDown() throws Exception {
        mSynapses = null;
        mNeuron = null;
    }
}