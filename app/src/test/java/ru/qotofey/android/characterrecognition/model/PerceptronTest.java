package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PerceptronTest {

    private Perceptron mPerceptron;

    @Before
    public void setUp() throws Exception {
        mPerceptron = new Perceptron(3);
        mPerceptron.train(
                new Double[] {
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                },
                new Double[] {
                        .0, 1.0, .0, 0.0, .0, .0, .0, .0, .0, .0,
                }
        );
    }

    @After
    public void tearDown() throws Exception {
        mPerceptron = null;
    }

    @Test
    public void foreachAllLayers() {
        mPerceptron.foreachAllLayers();

//        Double[] signals = mPerceptron.put(
//                new Double[] {
//                        1.0, 0.0,
//                }
//        );
//
//        for (int i = 0; i < signals.length; i++) {
//            System.out.println(signals[i]);
//        }
    }

    @Test
    public void foreachAllNeurons() {
        Double[][] e = mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        Double[][] ee = mPerceptron.foreachAllNeurons(mPerceptron.getSecondLayer(), e);
//        mPerceptron.foreachAllNeurons(mPerceptron.getFirstLayer(), ee);

        e = mPerceptron.foreachAllNeurons(mPerceptron.getLastLayer());
        ee = mPerceptron.foreachAllNeurons(mPerceptron.getSecondLayer(), e);
//        mPerceptron.foreachAllNeurons(mPerceptron.getFirstLayer(), ee);
    }

    @Ignore
    @Test
    public void getErrorSum() {
        Double output = mPerceptron.getErrorSum();
        assertEquals(0.834, output, 0.001); //результат веса
    }

    @Test(timeout = 10)
    public void train() {

    }

    @Test
    public void getOutputs() {
        int count = mPerceptron.getOutputSignals().length;
        for (int i = 0; i < count; i++) {
            assertTrue(mPerceptron.getOutputSignals()[i] < 1.0 && mPerceptron.getOutputSignals()[i] > -1.0);
        }
    }

    @Test
    public void put() {
        mPerceptron = new Perceptron(2);

        List<Sample> samples = new ArrayList<>();
        samples.add(new Sample(
                new Double[] {
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                        .0, .0, 1.0,
                },
                new Double[] {
                        .0, 1.0, .0, .0, .0, .0, .0, .0, .0, .0,
                }
        ));
//        samples.add(new Sample(
//                new Double[] {
//                        0.0, 1.0,
//                },
//                new Double[] {
//                        1.0, 0.0,
//                }
//        ));

        mPerceptron.train(samples);
//        mPerceptron.train(
//                new Double[] {
//                        1.0, 0.0,
//                },
//                new Double[] {
//                        0.0, 1.0,
//                }
//        );


        Double[] signals = mPerceptron.put(
                new Double[] {
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                }
        );

        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i]);
        }

//        signals = mPerceptron.put(
//                new Double[] {
//                        0.0, 1.0,
//                }
//        );
//
//        for (int i = 0; i < signals.length; i++) {
//            System.out.println(signals[i]);
//        }

    }
}