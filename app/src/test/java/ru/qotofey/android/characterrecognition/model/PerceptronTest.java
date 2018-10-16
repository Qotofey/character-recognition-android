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
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                },
                new Double[] {
                        1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

//        samples.add(new Sample(
//                new Double[] { //0
//                        0.0, 0.0, 0.0,
//                        1.0, 1.0, 1.0,
//                        1.0, 0.0, 1.0,
//                        1.0, 0.0, 1.0,
//                        1.0, 1.0, 1.0,
//                },
//                new Double[] {
//                        1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));
//
//        samples.add(new Sample(
//                new Double[] { //0
//                        1.0, 1.0, 1.0,
//                        1.0, 0.0, 1.0,
//                        1.0, 0.0, 1.0,
//                        1.0, 1.0, 1.0,
//                        0.0, 0.0, 0.0,
//                },
//                new Double[] {
//                        1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));

        samples.add(new Sample(
                new Double[] { //1
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                },
                new Double[] {
                        0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

//        samples.add(new Sample(
//                new Double[] { //1
//                        0.0, 0.0, 1.0,
//                        0.0, 1.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        0.0, 0.0, 1.0,
//                },
//                new Double[] {
//                        0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));
//
//        samples.add(new Sample(
//                new Double[] { //1
//                        0.0, 0.0, 1.0,
//                        0.0, 1.0, 0.8,
//                        0.0, 0.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        0.0, 0.0, 1.0,
//                },
//                new Double[] {
//                        0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));

        samples.add(new Sample(
                new Double[] { //2
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 0.0,
                        1.0, 1.0, 1.0,
                },
                new Double[] {
                        0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

//        samples.add(new Sample(
//                new Double[] { //2
//                        1.0, 1.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        0.6, 1.0, 0.7,
//                        1.0, 0.0, 0.0,
//                        1.0, 1.0, 1.0,
//                },
//                new Double[] {
//                        0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));
//
//        samples.add(new Sample(
//                new Double[] { //2
//                        1.0, 1.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        0.8, 1.0, 0.7,
//                        1.0, 0.0, 0.0,
//                        1.0, 1.0, 1.0,
//                },
//                new Double[] {
//                        0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));

        samples.add(new Sample(
                new Double[] { //3
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

//        samples.add(new Sample(
//                new Double[] { //3
//                        1.0, 1.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        1.0, 1.0, 0.0,
//                        0.0, 0.0, 1.0,
//                        1.0, 1.0, 1.0,
//                },
//                new Double[] {
//                        0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));
//
//        samples.add(new Sample(
//                new Double[] { //3
//                        1.0, 1.0, 0.2,
//                        0.0, 0.0, 1.0,
//                        0.0, 1.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        1.0, 1.0, 0.1,
//                },
//                new Double[] {
//                        0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));

//        samples.add(new Sample(
//                new Double[] { //4
//                        1.0, 0.0, 1.0,
//                        1.0, 0.0, 1.0,
//                        7.0, 1.0, 8.0,
//                        0.0, 0.0, 1.0,
//                        0.0, 0.0, 1.0,
//                },
//                new Double[] {
//                        0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));
//
//        samples.add(new Sample(
//                new Double[] { //4
//                        1.0, 0.0, 0.0,
//                        1.0, 0.0, 1.0,
//                        1.0, 1.0, 1.0,
//                        0.0, 0.0, 1.0,
//                        0.0, 0.0, 1.0,
//                },
//                new Double[] {
//                        0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                }
//        ));

        samples.add(new Sample(
                new Double[] { //4
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //5
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 0.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //6
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 0.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //7
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //8
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                },
                new Double[] {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
                }
        ));

        samples.add(new Sample(
                new Double[] { //9
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
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
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        );

        System.out.println("Результат 3?: ");
        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i]);
        }
        System.out.println();

        signals = mPerceptron.put(
                new Double[] {
                        0.0, 0.0, 1.0,
                        0.0, 0.4, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 0.0,
                }
        );

        System.out.println("Результат 1?: ");
        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i]);
        }
        System.out.println();

        signals = mPerceptron.put(
                new Double[] {
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        );

        System.out.println("Результат 0?: ");
        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i]);
        }
        System.out.println();

//        signals = mPerceptron.put(
//                new Double[] {
//                        0.0, 0.0, 0.0,
//                        0.0, 0.0, 0.0,
//                        0.0, 0.0, 0.0,
//                        0.0, 0.0, 0.0,
//                        0.0, 0.0, 0.0,
//                }
//        );
//
//        System.out.println("Результат *?: ");
//        for (int i = 0; i < signals.length; i++) {
//            System.out.println(signals[i]);
//        }
//        System.out.println();

        signals = mPerceptron.put(
                new Double[] {
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                }
        );

        System.out.println("Результат 7?: ");
        for (int i = 0; i < signals.length; i++) {
            System.out.println(signals[i]);
        }
        System.out.println();
    }
}