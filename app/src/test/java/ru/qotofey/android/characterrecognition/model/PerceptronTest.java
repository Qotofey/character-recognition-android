package ru.qotofey.android.characterrecognition.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PerceptronTest {

    private Perceptron mPerceptron;
    private List<Sample> mSampleList;

    @Before
    public void setUp() throws Exception {
        mPerceptron = new Perceptron(2);
        mPerceptron.build(15, 10);
        mSampleList = new ArrayList<>();
    }

    @Test
    public void train() {
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        1.0, 0.0, 1.0,
                                        1.0, 0.0, 1.0,
                                        1.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                                }
                        })
                );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        0.0, 0.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        0.0, 0.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                        1.0, 0.0, 0.0,
                                        1.0, 1.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 0.0, 1.0,
                                        1.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        0.0, 0.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        1.0, 0.0, 0.0,
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        1.0, 0.0, 0.0,
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        0.0, 1.0, 0.0,
                                        0.0, 1.0, 0.0,
                                        0.0, 1.0, 0.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        1.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                        1.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
                                }
                        }
                )
        );
        mSampleList.add(
                new Sample(
                        new Double[][] {
                                {
                                        1.0, 1.0, 1.0,
                                        1.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                        0.0, 0.0, 1.0,
                                        1.0, 1.0, 1.0,
                                }
                        },
                        new Double[][] {
                                {
                                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
                                }
                        }
                )
        );

        mPerceptron.learn(mSampleList, 1000);

        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 0.0,
                        1.0, 1.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 0.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 0.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                        0.0, 1.0, 0.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        })).println();
        mPerceptron.put(new Matrix(new Double[][]{
                {
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        })).println();

//        mPerceptron.train(
//                new Matrix(new Double[][] {
//                        {
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                                0.0, 0.0, 1.0,
//                        }
//                }),
//                new Matrix(new Double[][] {
//                        {
//                                0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//                        }
//                })
//        );
    }

    @Test
    public void put() {

    }



    @After
    public void tearDown() throws Exception {
        mPerceptron = null;
    }


}