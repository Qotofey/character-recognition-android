package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PerceptronTest {

    private Perceptron mPerceptron;

    @Before
    public void setUp() throws Exception {

        mPerceptron = new Perceptron(2);
        mPerceptron.train(
                new Double[] {
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                },
                new Double[] {
                        -1.0, 1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0,
                }
        );
    }

    @After
    public void tearDown() throws Exception {
        mPerceptron = null;
    }

    @Test
    public void foreachAllNeurons() {
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());

    }

    @Test(timeout = 10)
    public void train() {
        mPerceptron.train(
                new Double[] {
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                },
                new Double[] {
                        -1.0, 1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0,
                }
        );

    }

//    @Ignore
    @Test
    public void getOutputs() {
        int count = mPerceptron.getOutput().length;
        for (int i = 0; i < count; i++) {
            assertTrue(mPerceptron.getOutput()[i] < 1.0 && mPerceptron.getOutput()[i] > -1.0);
        }
    }

//    @Ignore
    @Test
    public void put() {
        
    }
}