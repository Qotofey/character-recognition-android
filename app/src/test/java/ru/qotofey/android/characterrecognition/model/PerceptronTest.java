package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PerceptronTest {

    private Perceptron mPerceptron;

    @Before
    public void setUp() throws Exception {
        mPerceptron = new Perceptron(2);
        List<Sample> samples = new ArrayList<>();
        samples.add(new Sample(
                new Double[] { //0
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                },
                new Double[] {
                        1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //1
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                },
                new Double[] {
                        0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //2
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 1.0,
                        0.0, 0.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //3
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //4
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //5
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 1.0,
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //6
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 1.0,
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //7
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //8
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //9
                        0.0, 0.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
                }
        ));
        mPerceptron.train(samples);
        mPerceptron.learn();
    }

    @After
    public void tearDown() throws Exception {
        mPerceptron = null;
    }

    @Test
    public void put() {
        Double[] signals = mPerceptron.put(
                new Double[] {
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                        1.0, 1.0, 0.0,
                        0.0, 0.0, 0.0,
                }
        );

        System.out.println("Результат 1: ");
        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i]);
        }
        System.out.println();

        signals = mPerceptron.put(
                new Double[] {
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                        1.0, 1.0, 0.0,
                }
        );

        System.out.println("Результат 2: ");
        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i]);
        }
        System.out.println();
    }
}