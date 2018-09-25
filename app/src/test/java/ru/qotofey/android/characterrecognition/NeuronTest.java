package ru.qotofey.android.characterrecognition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ru.qotofey.android.characterrecognition.model.Neuron;
import ru.qotofey.android.characterrecognition.model.Synapse;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class NeuronTest {

    private Neuron mNeuron_0;
    private Neuron mNeuron_1;

    @Before
    public void setUp() throws Exception {
        Synapse[] synapses_0 = new Synapse[5];
        synapses_0[0] = new Synapse(0.33F, 2.0F);
        synapses_0[1] = new Synapse(0.22F, 0.4F);
        synapses_0[2] = new Synapse(0.0F, 0.0F);
        synapses_0[3] = new Synapse(-0.12F, 0.5F);
        synapses_0[4] = new Synapse(-0.48F, 2.0F);
        mNeuron_0 = new Neuron(synapses_0);
        Synapse[] synapses_1 = new Synapse[5];
        synapses_1[0] = new Synapse(-0.33F, 2.0F);
        synapses_1[1] = new Synapse(-0.22F, 0.4F);
        synapses_1[2] = new Synapse(-0.0F, 0.0F);
        synapses_1[3] = new Synapse(0.12F, 0.5F);
        synapses_1[4] = new Synapse(0.48F, 2.0F);
        mNeuron_1 = new Neuron(synapses_1);
    }

    @Test
    public void testGetSignal_0() throws Exception {
        Float result = mNeuron_0.getSignal();
        assertTrue(result == -1.0F || result == 1.0F);
    }

    @Test
    public void testGetSignal_1() throws Exception {
        Float result = mNeuron_1.getSignal();
        assertTrue(result == -1.0F || result == 1.0F);
    }

    @Test
    public void testGetSignal_2() throws Exception {
        assertEquals(-1.0F, mNeuron_0.getSignal());
    }

    @Test
    public void testGetSignal_3() throws Exception {
        assertEquals(1.0F, mNeuron_1.getSignal());
    }

    @After
    public void tearDown() throws Exception {
        mNeuron_0 = null;
        mNeuron_1 = null;
    }

}
