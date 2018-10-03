package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static junit.framework.TestCase.assertEquals;


public class SynapseTest {

    private Synapse mSynapse;

    @Rule
    public Timeout timeout = new Timeout(10);

    @Before
    public void setUp() throws Exception {
        mSynapse = new Synapse(1.3, -0.0001);
    }

    @Test
    public void getResult() {
        assertEquals(-0.00013, mSynapse.getResult(), 0.00000001); //произведение сигнала и синаптического веса
    }

    @After
    public void tearDown() throws Exception {
        mSynapse = null;
    }
}