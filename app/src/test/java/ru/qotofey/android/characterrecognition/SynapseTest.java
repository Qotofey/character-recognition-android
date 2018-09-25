package ru.qotofey.android.characterrecognition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ru.qotofey.android.characterrecognition.model.Synapse;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class SynapseTest {

    private Synapse mSynapse_0;
    private Synapse mSynapse_1;
    private Synapse mSynapse_2;
    private Synapse mSynapse_3;
    private Synapse mSynapse_4;

    @Before
    public void setUp() throws Exception {
        mSynapse_0 = new Synapse(0.33F, 2.0F);
        mSynapse_1 = new Synapse(0.22F, 0.4F);
        mSynapse_2 = new Synapse(0.0F, 0.0F);
        mSynapse_3 = new Synapse(-0.12F, 0.5F);
        mSynapse_4 = new Synapse(-0.48F, 2.0F);
    }

    @Test
    public void testGetResult_0() throws Exception {
        assertEquals(0.66F, mSynapse_0.getResult());
    }

    @Test
    public void testGetResult_1() throws Exception {
        assertEquals(0.088F, mSynapse_1.getResult());
    }

    @Test
    public void testGetResult_2() throws Exception {
        assertEquals(0.0F, mSynapse_2.getResult());
    }

    @Test
    public void testGetResult_3() throws Exception {
        assertEquals(-0.06F, mSynapse_3.getResult());
    }

    @Test
    public void testGetResult_4() throws Exception {
        assertEquals(-0.96F, mSynapse_4.getResult());
    }

    @After
    public void tearDown() throws Exception {
        mSynapse_0 = null;
        mSynapse_1 = null;
        mSynapse_2 = null;
        mSynapse_3 = null;
        mSynapse_4 = null;
    }

}
