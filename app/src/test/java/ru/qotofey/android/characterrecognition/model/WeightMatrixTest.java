package ru.qotofey.android.characterrecognition.model;

import org.junit.Before;
import org.junit.Test;

import ru.qotofey.android.characterrecognition.model.deprecated.WeightMatrix;

import static org.junit.Assert.assertEquals;

public class WeightMatrixTest {

    private WeightMatrix[] mWeightMatrix = new WeightMatrix[2];

    @Before
    public void setUp() throws Exception {
        mWeightMatrix[0] = new WeightMatrix(
                new Double[] {
                            0.0, 0.0, 1.0,
                            0.0, 0.0, 1.0,
                            0.0, 0.0, 1.0,
                            0.0, 0.0, 1.0,
                            0.0, 0.0, 1.0,
                        },
                10
        );
        mWeightMatrix[1] = new WeightMatrix(
                new Double[] {
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                },
                6
        );
    }

    @Test
    public void getSignals() {

    }

    @Test
    public void getCountNeurons() {
        int expected;
        int output;
        //первый тест
        expected = 10;
        output = mWeightMatrix[0].getCountNeurons();
        assertEquals(expected, output);
        //второй тест
        expected = 6;
        output = mWeightMatrix[1].getCountNeurons();
        assertEquals(expected, output);

    }

    @Test
    public void get() {
    }
}