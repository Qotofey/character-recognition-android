package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class LayerTest {

    private Layer mLayer;
    private Layer mLayer1;

    @Before
    public void setUp() throws Exception {
        mLayer = new Layer(new WeightMatrix(
                new Double[] {
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                },
                10));
    }

    @After
    public void tearDown() throws Exception {
        mLayer = null;
    }

    @Test
    public void getSignals() {
        for (int i = 0; i < mLayer.getSignals().length; i++) {
            assertTrue(mLayer.getSignals()[i] < 1.0 && mLayer.getSignals()[i] > -1.0);
        }
    }

    @Test
    public void getNeurons() {
        for (int i = 0; i < mLayer.getSignals().length; i++) {
            assertTrue(mLayer.getNeurons()[i].getSignal() < 1.0 && mLayer.getNeurons()[i].getSignal() > -1.0);
        }
    }


}