package ru.qotofey.android.characterrecognition.app.manager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatrixMathTest {

    private MatrixMath mMatrixMath;

    @Before
    public void setUp() throws Exception {
        mMatrixMath = new MatrixMath();
    }

    @After
    public void tearDown() throws Exception {
        mMatrixMath = null;
    }

    @Test
    public void summarize() {

    }

    @Test
    public void summarize1() {

    }

    @Test
    public void multiply() {
        Double[][] expected = new Double[][] {
                { 10.0, 5.0, 1.0, },
                { 7.0, 4.0, 1.0, },
        };
        Double[][] matrix1 = new Double[][] {
                { 1.0, 3.0, },
                { 1.0, 2.0, },
        };
        Double[][] matrix2 = new Double[][] {
                { 1.0, 2.0, 1.0, },
                { 3.0, 1.0, 0.0, },
        };
        Double[][] output = mMatrixMath.multiply(matrix1, matrix2);
//        assertEquals(output, expected);
    }

    Double[][] weights_0_1 = new Double[][] {
            { .014, .09, -.05, -.02, -.05, -.02, -.05, -.02, .025, -.031, .014, .09, -.05, -.02, -.05,},
            { -.05, -.02, .014, .09, .054, .09, -.02, -.05, -.02, .025, -.031, -.02, .025, -.031, .014, },
            { .025, -.031, .014, .23, .011, .01, .014, .09, -.05, -.02, -.05, -.02, .025, -.031, .014, },
            { .014, .09, -.05, -.02, .014, .09, .014, .09, -.05, -.02, -.05, -.02, .025, -.031, .014, },
            { -.05, -.02, .025, -.031, .014, .23, .09, -.05, -.02, .014, .09, -.02, .025, -.031, .014, },
            { .025, -.031, .014, .09, -.05, -.02, -.02, .025, -.031, .014, .23, -.02, .025, -.031, .014, },
            { .014, .09, .025, -.031, .014, .09, -.02, -.02, .025, -.031, .014, -.02, .025, -.031, .014, },
            { -.05, -.02, .014, .09, -.05, -.02, -.02, -.02, .025, -.031, .014, -.02, .025, -.031, .014, },
            { .025, -.031, -.05, -.02, .014, .09, -.05, -.02, .014, .09, -.05, -.02, -.02, .025, -.031, },
            { .014, .09, -.02, .014, .09, -.05, .025, -.031, .014, .09, -.05, -.02, -.02, .025, -.031, .014,},
            { -.05, -.02, .014, .09, -.02, .014, -.02, .014, .09, -.05, .025, -.02, .025, -.031, .014,},
            { .025, -.031, .014, .09, -.02, .014, -.031, .014, .09, -.05, -.02, -.02, .025, -.031, .014,},
            { .014, .09, .025, -.031, .014, .09, .09, -.02, .014, .09, -.05, -.02, .025, -.031, .014,},
            { -.05, -.02, -.05, -.02, -.031, .09, -.02, .014, .09, -.05, .025, -.02, .025, -.031, .014,},
            { .025, -.031, .025, -.031, -.05, -.02, -.031, -.05, -.02, .014, .09, -.02, .025, -.031, .014,},

//            { .014, .09, },
//            { -.05, -.02, },
//            { .025, -.031, },

//            { 0.5, 0.5, },
//            { 0.5, 0.5, },
//            { 0.5, 0.5, },

    };
    Double[][] weights_1_2 = new Double[][] {
            { .014, .09, .014, .014, .014, .09, .014, .014, 0.02, .24, },
            { -.05, -.02, .04, -.031, .014, .014, .09, .014, .014, 0.02, },
            { .025, -.031, .4, -.031, .014, .014, .09, .014, .014, 0.02, },
            { 0.017, 0.01, .34,-.031, .014, .014, .09, .014, .014, 0.02, },
            { 0.021, 0.02, .24, .014, .014, .014, .09, .014, .014, 0.02, },
            { .014, .09, .014, -.031, 0.021, 0.02, .24, .014, .014, .014, },
            { -.05, -.02, .04, -.031, 0.021, 0.02, .24, .014, .014, .014, },
            { .025, -.031, .4, .025, 0.021, 0.02, .24, .014, .014, .014, },
            { 0.017, 0.01, .34, .025, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { 0.021, 0.02, .24, .025, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { .014, .09, .014, 0.021, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { -.05, -.02, .04, 0.21, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { .025, -.031, .4, 0.021, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { 0.017, 0.01, .34, 0.21, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { 0.021, 0.02, .24, 0.01, -.05, -.02, .04, -.091, 0.021, 0.02, },

//            { 0.5, },
//            { 0.5, },
    };

    @Test
    public void testPerceptron() {

        Double[][] inputs = new Double[][] {
                { 1.0, 1.0, 0.0, },
        };
        Double[][] expected = new Double[][] {
                { 0.0, },
        };

//        train(inputs, expected);

        int epochs = 5000;
        for (int i = 0; i < epochs; i++) {
            train(
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
                    }
            );

            train(
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
            );
            train(
                    new Double[][] {
                            {
                                    0.0, 0.0, 1.0,
                                    0.0, 1.0, 1.0,
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
            );
            train(
                    new Double[][] {
                            {
                                    0.0, 0.0, 1.0,
                                    0.0, 1.0, 5.0,
                                    0.0, 0.0, 1.0,
                                    0.0, 0.0, 1.0,
                                    0.0, 0.0, 0.0,
                            }
                    },
                    new Double[][] {
                            {
                                    0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                            }
                    }
            );

            train(
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
            );

            train(
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
            );

            train(
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
            );
//            train(
//                    new Double[][] {
//                            { 0.0, 0.0, 0.0, },
//                    },
//                    new Double[][] {
//                            { 0.0, 0.0},
//                    }
//            );
//            train(
//                    new Double[][] {
//                            { 0.0, 0.0, 0.0, },
//                    },
//                    new Double[][] {
//                            { 1.0, 1.0, },
//                    }
//            );
//            train(
//                    new Double[][] {
//                            { 0.0, 1.0, 0.0, },
//                    },
//                    new Double[][] {
//                            { 0.0, 0.0, },
//                    }
//            );
//            train(
//                    new Double[][] {
//                            { 0.0, 1.0, 1.0, },
//                    },
//                    new Double[][] {
//                            { 0.0, 0.0, },
//                    }
//            );
//            train(
//                    new Double[][] {
//                            { 1.0, 0.0, 0.0, },
//                    },
//                    new Double[][] {
//                            { 1.0, 1.0, },
//                    }
//            );
//            train(
//                    new Double[][] {
//                            { 1.0, 0.0, 1.0, },
//                    },
//                    new Double[][] {
//                            { 1.0, 1.0, },
//                    }
//            );
//            train(
//                    new Double[][] {
//                            { 1.0, 1.0, 0.0, },
//                    },
//                    new Double[][] {
//                            { 0.0, 0.0, },
//                    }
//            );
//            train(
//                    new Double[][] {
//                            { 1.0, 1.0, 1.0, },
//                    },
//                    new Double[][] {
//                            { 1.0, 1.0, },
//                    }
//            );
//            Double[][] trainLoss = MatrixMath.multiply(predict(inputs), MatrixMath.T(expected));
//            System.out.println("Error: " + trainLoss[0][0]);
        }


        Double[][] result = predict(new Double[][] {
                {
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        });
        System.out.println("Результат матрица e(0): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2] + " | " + result[0][3]);


        result = predict(new Double[][] {
                {
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                }
        });
        System.out.println("Результат матрица e(1): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2] + " | " + result[0][3]);

        result = predict(new Double[][] {
                {
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                }
        });
        System.out.println("Результат матрица e(2): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2] + " | " + result[0][3]);

        result = predict(new Double[][] {
                {
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 1.0, 1.0,
                }
        });
        System.out.println("Результат матрица e(3): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2] + " | " + result[0][3]);

        result = predict(new Double[][] {
                {
                        1.0, 0.0, 1.0,
                        1.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 1.0, 1.0,
                }
        });
        System.out.println("Результат матрица e(4): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2] + " | " + result[0][3] + " | " + result[0][4]);

    }

    private Double[][] predict(Double[][] inputs) {
        Double[][] inputs_1 = MatrixMath.multiply(inputs, weights_0_1);
        Double[][] outputs_1 = Mapper.sigmoid(inputs_1);

        Double[][] inputs_2 = MatrixMath.multiply(outputs_1, weights_1_2);
        Double[][] outputs_2 = Mapper.sigmoid(inputs_2);

        return outputs_2;
    }

    private void train(Double[][] inputs, Double[][] expected) {
        Double[][] inputs_1 = MatrixMath.multiply(inputs, weights_0_1);
        Double[][] outputs_1 = Mapper.sigmoid(inputs_1);

        Double[][] inputs_2 = MatrixMath.multiply(outputs_1, weights_1_2);
        Double[][] outputs_2 = Mapper.sigmoid(inputs_2);

        Double[][] actualPredict = outputs_2;

        Double[][] errorLayer2;
        Double[][] gradientLayer2;
        Double[][] weightsDeltaLayer2;
        Double[][] errorLayer1;
        Double[][] gradientLayer1;
        Double[][] weightsDeltaLayer1;

        errorLayer2 = MatrixMath.difference(actualPredict, expected);
        gradientLayer2 = Mapper.derivativeSigmoid(actualPredict);
        weightsDeltaLayer2 = MatrixMath.vectorsMultiply(errorLayer2, gradientLayer2);
        weights_1_2 = MatrixMath.difference(
                weights_1_2,
                MatrixMath.T(
                        MatrixMath.multiply(
                                MatrixMath.multiply(
                                    MatrixMath.T(weightsDeltaLayer2),
                                    outputs_1
                                ),
                                Constants.H
                        )
                )
        );

        errorLayer1 = MatrixMath.multiply(weightsDeltaLayer2, MatrixMath.T(weights_1_2));
        gradientLayer1 = Mapper.derivativeSigmoid(outputs_1);
        weightsDeltaLayer1 = MatrixMath.vectorsMultiply(errorLayer1, gradientLayer1);
        weights_0_1= MatrixMath.difference(
                weights_0_1,
                MatrixMath.T(
                        MatrixMath.multiply(
                                MatrixMath.multiply(
                                        MatrixMath.T(weightsDeltaLayer1),
                                        inputs
                                ),
                                Constants.H
                        )
                )
        );

    }

    @Test
    public void multiply1() {

    }

    @Test
    public void t() {

    }
}