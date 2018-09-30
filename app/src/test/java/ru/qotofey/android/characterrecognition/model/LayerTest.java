package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class LayerTest {

    private Layer mLayer;

    @Before
    public void setUp() throws Exception {
        mLayer = new Layer(new WeightMatrix(
                new Float[] {
                        -1.0F, -1.0F, 1.0F,
                        -1.0F, -1.0F, 1.0F,
                        -1.0F, -1.0F, 1.0F,
                        -1.0F, -1.0F, 1.0F,
                        -1.0F, -1.0F, 1.0F
                },
                15));


    }

    @After
    public void tearDown() throws Exception {
        mLayer = null;
    }

    @Test
    public void getSignals() {
        for (int i = 0; i < 15; i++) {
            assertTrue(mLayer.getSignals()[i] == 1.0F || mLayer.getSignals()[i] == -1.0F);
        }
    }
}