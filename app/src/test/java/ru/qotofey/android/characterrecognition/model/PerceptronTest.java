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
                new Float[] {
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                },
                new Float[] {
//                        .0F, 1.0F, .0F, .0F, .0F, .0F, .0F, .0F, .0F, .0F,
                        -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F,
                }
        );
    }

    @After
    public void tearDown() throws Exception {
        mPerceptron = null;
    }

//    @Ignore
    @Test(timeout = 10)
    public void train() {
        mPerceptron.train(
                new Float[] {
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                        1.0F, 1.0F, 0.0F,
                },
                new Float[] {
//                        .0F, 1.0F, .0F, .0F, .0F, .0F, .0F, .0F, .0F, .0F,
                        -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F,
                }
        );

    }

//    @Ignore
    @Test
    public void getOutputs() {
        int count = mPerceptron.getOutput().length;
        for (int i = 0; i < count; i++) {
            assertTrue(mPerceptron.getOutput()[i] == 1.0F || mPerceptron.getOutput()[i] == -1.0F);
        }
    }

//    @Ignore
    @Test
    public void put() {
        
    }
}