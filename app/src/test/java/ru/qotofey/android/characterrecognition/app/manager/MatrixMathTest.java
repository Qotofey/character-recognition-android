package ru.qotofey.android.characterrecognition.app.manager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.qotofey.android.characterrecognition.model.Matrix;

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
            { -.05, -.02, .014, .09, -.05, -.02, -.02, -.02, .025, .031, .014, -.02, .025, -.031, .014, },
            { .025, -.031, -.05, -.02, .014, .09, -.05, -.02, .014, .09, -.05, -.02, -.02, .025, -.031, },
            { .014, .09, -.02, .014, .09, -.05, .025, -.031, .014, .09, -.05, -.02, -.02, .025, -.031, .014,},
            { -.05, -.02, .014, .09, -.02, .014, -.02, .014, .09, -.05, .025, -.02, .025, -.031, .014,},
            { .025, -.031, .014, .09, -.02, .014, -.031, .014, .09, -.05, -.02, -.02, .025, -.031, .014,},
            { .014, .09, .025, -.031, .014, .09, .09, -.02, .014, .09, -.05, -.02, .025, -.031, .014,},
            { -.05, -.02, -.05, -.02, -.031, .09, -.02, .014, .09, -.05, .025, -.02, .025, -.031, .014,},
            { .025, -.031, .025, -.031, -.05, -.02, -.031, -.05, -.02, .014, .09, -.02, .025, -.031, .014,},

    };
    Double[][] weights_1_2 = new Double[][] {
            { .014, .09, .014, .014, .014, .09, .014, .014, 0.02, .24, },
            { -.05, -.02, .04, -.031, .014, .014, .09, .014, .014, 0.02, },
            { .025, -.031, .4, .031, .014, .014, .09, .014, .014, 0.02, },
            { 0.017, 0.01, .34,.0131, .04, .014, .09, .014, .014, 0.02, },
            { 0.021, 0.02, .24, .014, .014, .014, .09, .014, .014, 0.02, },
            { .014, .09, .014, -.031, 0.021, 0.02, .24, .014, .014, .014, },
            { -.05, -.02, .04, -.031, 0.021, 0.02, .24, .014, .014, .014, },
            { .025, -.031, .4, .025, 0.021, 0.02, .24, .014, .014, .014, },
            { 0.017, 0.01, .34, .025, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { 0.021, 0.02, .24, .025, -.05, -.02, .04, .031, 0.021, 0.02, },
            { .014, .09, .014, 0.021, -.05, .02, .04, .091, 0.021, 0.02, },
            { -.05, -.02, .04, 0.21, -.05, -.02, .04, -.131, 0.021, 0.02, },
            { .025, -.031, .4, 0.021, -.05, -.02, .04, -.031, 0.021, 0.02, },
            { 0.017, 0.01, .34, 0.21, .205, .012, .04, -.031, 0.021, 0.02, },
            { 0.021, 0.02, .24, 0.01, .05, .02, .14, -.091, 0.021, 0.02, },

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

        int epochs = 500;
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
//            Double[][] trainLoss = MatrixMath.multiply(put(inputs), MatrixMath.T(expected));
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
        System.out.println("Результат матрица e(0): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2]);


        result = predict(new Double[][] {
                {
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                        0.0, 0.0, 1.0,
                }
        });
        System.out.println("Результат матрица e(1): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2]);

        result = predict(new Double[][] {
                {
                        1.0, 1.0, 1.0,
                        0.0, 0.0, 1.0,
                        1.0, 1.0, 1.0,
                        1.0, 0.0, 0.0,
                        1.0, 1.0, 1.0,
                }
        });
        System.out.println("Результат матрица e(2): " + result[0][0] + " | " + result[0][1] + " | " + result[0][2]);
    }

    private Double[][] predict(Double[][] inputs) {
        Double[][] inputs_1 = MatrixMath.multiply(inputs, weights_0_1);
        Double[][] outputs_1 = Mapper.sigmoid(inputs_1);

        Double[][] inputs_2 = MatrixMath.multiply(outputs_1, weights_1_2);
        Double[][] outputs_2 = Mapper.sigmoid(inputs_2);

        return outputs_2;
    }

    private void train(Double[][] inputs, Double[][] expected) {
        Matrix INPUTS = new Matrix(inputs);
        Matrix EXPECTED = new Matrix(expected);
        Matrix WEIGHT_0_1 = new Matrix(weights_0_1);
        Matrix WEIGHT_1_2 = new Matrix(weights_1_2);

        Matrix inputs1 = INPUTS.multiply(WEIGHT_0_1);
        Matrix outputs1 = Mapper.sigmoid(inputs1);

        Matrix inputs2 = outputs1.multiply(WEIGHT_1_2);
        Matrix outputs2 = Mapper.sigmoid(inputs2);

        Matrix ACTUAL_PREDICT = outputs2;

        Matrix ERROR_LAYER_2;
        Matrix ERROR_LAYER_1;
        Matrix GRADIENT_LAYER_2;
        Matrix GRADIENT_LAYER_1;
        Matrix WEIGHT_DELTA_LAYER_2;
        Matrix WEIGHT_DELTA_LAYER_1;

        ERROR_LAYER_2 = ACTUAL_PREDICT.difference(EXPECTED);
        double x = 0.0;
//        for (int i = 0; i < errorLayer2.length; i++) {
//            x += errorLayer2[0][i] * errorLayer2[0][i];
//        }
        for (int i = 0; i < ERROR_LAYER_2.getRowsCount(); i++) {
            x += ERROR_LAYER_2.get()[0][i] * ERROR_LAYER_2.get()[0][i];
        }
        System.out.println(x);

//        gradientLayer2 = Mapper.derivativeSigmoid(actualPredict);
//        weightsDeltaLayer2 = MatrixMath.vectorsMultiply(errorLayer2, gradientLayer2);
        GRADIENT_LAYER_2 = Mapper.derivativeSigmoid(ACTUAL_PREDICT);
        WEIGHT_DELTA_LAYER_2 = ERROR_LAYER_2.vectorsMultiply(GRADIENT_LAYER_2);
//        weights_1_2 = MatrixMath.difference(
//                weights_1_2,
//                MatrixMath.T(
//                        MatrixMath.multiply(
//                                MatrixMath.multiply(
//                                    MatrixMath.T(weightsDeltaLayer2),
//                                    outputs_1
//                                ),
//                                Constants.H
//                        )
//                )
//        );
        WEIGHT_1_2 = WEIGHT_1_2.difference(
                WEIGHT_DELTA_LAYER_2
                        .transpose()
                        .multiply(outputs1)
                        .multiply(Constants.H)
                        .transpose()
        );
        weights_1_2 = WEIGHT_1_2.get();

        ERROR_LAYER_1 = WEIGHT_DELTA_LAYER_2.multiply(WEIGHT_1_2.transpose());
        GRADIENT_LAYER_1 = Mapper.derivativeSigmoid(outputs1);
        WEIGHT_DELTA_LAYER_1 = ERROR_LAYER_1.vectorsMultiply(GRADIENT_LAYER_1);

        WEIGHT_0_1 = WEIGHT_0_1.difference(
                WEIGHT_DELTA_LAYER_1
                        .transpose()
                        .multiply(INPUTS)
                        .multiply(Constants.H)
                        .transpose()
        );
        weights_0_1 = WEIGHT_0_1.get();

    }

    @Test
    public void t() {

    }
}