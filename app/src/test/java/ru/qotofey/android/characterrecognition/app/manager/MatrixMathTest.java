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
            { .14, .09, },
            { -.5, -.2, },
            { .65, .39, },
//            { 0.5, 0.5, },
//            { 0.5, 0.5, },
//            { 0.5, 0.5, },

    };
    Double[][] weights_1_2 = new Double[][] {
            { 0.17, },
            { 0.21, },
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

        int epochs = 10000;
        for (int i = 0; i < epochs; i++) {
            train(
                    new Double[][] {
                            { 0.0, 0.0, 0.0, },
                    },
                    new Double[][] {
                            { 0.0, },
                    }
            );
            train(
                    new Double[][] {
                            { 0.0, 0.0, 0.0, },
                    },
                    new Double[][] {
                            { 1.0, },
                    }
            );
            train(
                    new Double[][] {
                            { 0.0, 1.0, 0.0, },
                    },
                    new Double[][] {
                            { 0.0, },
                    }
            );
            train(
                    new Double[][] {
                            { 0.0, 1.0, 1.0, },
                    },
                    new Double[][] {
                            { 0.0, },
                    }
            );
            train(
                    new Double[][] {
                            { 1.0, 0.0, 0.0, },
                    },
                    new Double[][] {
                            { 1.0, },
                    }
            );
            train(
                    new Double[][] {
                            { 1.0, 0.0, 1.0, },
                    },
                    new Double[][] {
                            { 1.0, },
                    }
            );
            train(
                    new Double[][] {
                            { 1.0, 1.0, 0.0, },
                    },
                    new Double[][] {
                            { 0.0, },
                    }
            );
            train(
                    new Double[][] {
                            { 1.0, 1.0, 1.0, },
                    },
                    new Double[][] {
                            { 1.0, },
                    }
            );
//            Double[][] trainLoss = MatrixMath.multiply(predict(inputs), MatrixMath.T(expected));
//            System.out.println("Error: " + trainLoss[0][0]);
        }

        Double[][] result = predict(new Double[][] {{ 1.0, 1.0, 0.0, },});
        System.out.println("Результат матрица e(0): " + result[0][0]);
        result = predict(new Double[][] {{ 0.0, 0.0, 0.0, },});
        System.out.println("Результат матрица e(0): " + result[0][0]);

        result = predict(new Double[][] {{ 0.0, 0.0, 1.0, },});
        System.out.println("Результат матрица e(1): " + result[0][0]);

        result = predict(new Double[][] {{ 0.0, 1.0, 0.0, },});
        System.out.println("Результат матрица e(0): " + result[0][0]);

        result = predict(new Double[][] {{ 1.0, 1.0, 1.0, },});
        System.out.println("Результат матрица e(1): " + result[0][0]);

        result = predict(new Double[][] {{ 1.0, 0.0, 1.0, },});
        System.out.println("Результат матрица e(1): " + result[0][0]);


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

//    private Double MSE(Double[][] y, Double[][] Y) {
//        Double sum = 0.0;
//        for (int i = 0; i < y.length; i++) {
//            sum += (y[i][0] - Y[i][0]) * (y[i][0] - Y[i][0]);
//        }
//        return sum;
//    }


//    private Double[][] predict(Double[][] inputs) {
//        Double[][] inputs_1 = MatrixMath.multiply(weights_0_1, inputs);
//        Double[][] outputs_1 = Mapper.sigmoid(inputs_1);
//
//        Double[][] inputs_2 = MatrixMath.multiply(weights_1_2, outputs_1);
//        Double[][] outputs_2 = Mapper.sigmoid(inputs_2);
//
//        return outputs_2;
//    }

//    private void train(Double[][] inputs, Double[][] expected) {
//        Double[][] inputs_1 = MatrixMath.multiply(weights_0_1, inputs);
////
////        System.out.println("Новая матрица inputs_1: ");
////        for (int i = 0; i < inputs_1.length; i++) {
////            for (int j = 0; j < inputs_1[0].length; j++) {
////                System.out.print(" | " + inputs_1[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
//        Double[][] outputs_1 = Mapper.sigmoid(inputs_1);
////        System.out.println("Новая матрица outputs_1: ");
////        for (int i = 0; i < outputs_1.length; i++) {
////            for (int j = 0; j < outputs_1[0].length; j++) {
////                System.out.print(" | " + outputs_1[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
//        Double[][] inputs_2 = MatrixMath.multiply(weights_1_2, outputs_1);
//
////        System.out.println("Новая матрица inputs_2: ");
////        for (int i = 0; i < inputs_2.length; i++) {
////            for (int j = 0; j < inputs_2[0].length; j++) {
////                System.out.print(" | " + inputs_2[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
//        Double[][] outputs_2 = Mapper.sigmoid(inputs_2);
//
////        System.out.println("Новая матрица outputs_2: ");
////        for (int i = 0; i < outputs_2.length; i++) {
////            for (int j = 0; j < outputs_2[0].length; j++) {
////                System.out.print(" | " + outputs_2[i][j]);
////            }
////            System.out.println(" | ");
////        }
////
//        Double[][] actualPredict = outputs_2;
//
//        Double[][] errorLayer2 = MatrixMath.difference(actualPredict, expected);
//        Double[][] gradientLayer2 = MatrixMath.multiply(actualPredict, MatrixMath.T(MatrixMath.difference(1.0, actualPredict))); //actualPredict * (1 - actualPredict)
////
////        System.out.println("Новая матрица errorLayer2: ");
////        for (int i = 0; i < errorLayer2.length; i++) {
////            for (int j = 0; j < errorLayer2[0].length; j++) {
////                System.out.print(" | " + errorLayer2[i][j]);
////            }
////            System.out.println(" | ");
////        }
////        System.out.println("Новая матрица gradientLayer2: ");
////        for (int i = 0; i < gradientLayer2.length; i++) {
////            for (int j = 0; j < gradientLayer2[0].length; j++) {
////                System.out.print(" | " + gradientLayer2[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
//        Double[][] weightsDeltaLayer2 = MatrixMath.multiply(MatrixMath.T(errorLayer2), gradientLayer2);
////
////        System.out.println("n = " + weightsDeltaLayer2.length);
////        System.out.println("m = " + weightsDeltaLayer2[0].length);
////        System.out.println("_n = " + outputs_2.length);
////        System.out.println("_m = " + outputs_2[0].length);
//
////        weights_1_2 = MatrixMath.difference(weights_0_1, MatrixMath.dot(weightsDeltaLayer2[0], outputs_1[0]) * Constants.H);
//        weights_1_2 = MatrixMath.difference(
//                weights_1_2,
//                MatrixMath.multiply(
//                        MatrixMath.multiply(
//                                MatrixMath.T(weightsDeltaLayer2),
//                                MatrixMath.reshape(1, outputs_1.length * outputs_1[0].length, outputs_1)
//                        ),
//                        Constants.H
//                )
//        );
//
////        System.out.println("Новая матрица weightsDeltaLayer2: ");
////        for (int i = 0; i < weightsDeltaLayer2.length; i++) {
////            for (int j = 0; j < weightsDeltaLayer2[0].length; j++) {
////                System.out.print(" | " + weightsDeltaLayer2[i][j]);
////            }
////            System.out.println(" | ");
////        }
////
////        System.out.println("Новая матрица weights_1_2: ");
////        for (int i = 0; i < weights_1_2.length; i++) {
////            for (int j = 0; j < weights_1_2[0].length; j++) {
////                System.out.print(" | " + weights_1_2[i][j]);
////            }
////            System.out.println(" | ");
////        }
////        System.out.println();
//
////        Double[][] errorLayer1 = MatrixMath.multiply(MatrixMath.reshape(1, weightsDeltaLayer2.length * weightsDeltaLayer2[0].length, weightsDeltaLayer2),  weights_1_2);
//        Double[][] errorLayer1 = MatrixMath.multiply(weightsDeltaLayer2,  weights_1_2);
////        System.out.println("Новая матрица errorLayer1: ");
////        for (int i = 0; i < errorLayer1.length; i++) {
////            for (int j = 0; j < errorLayer1[0].length; j++) {
////                System.out.print(" | " + errorLayer1[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
////        System.out.println("Новая матрица outputs_1: ");
////        for (int i = 0; i < outputs_1.length; i++) {
////            for (int j = 0; j < outputs_1[0].length; j++) {
////                System.out.print(" | " + outputs_1[i][j]);
////            }
////            System.out.println(" | ");
////        }
//        Double[][] gradientLayer1 = MatrixMath.multiply(outputs_1, MatrixMath.T(MatrixMath.difference(1.0, outputs_1)));
//
////        System.out.println("Новая матрица gradientLayer1: ");
////        for (int i = 0; i < gradientLayer1.length; i++) {
////            for (int j = 0; j < gradientLayer1[0].length; j++) {
////                System.out.print(" | " + gradientLayer1[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
//        Double[][] weightsDeltaLayer1 = MatrixMath.multiply(errorLayer1, gradientLayer1);
//
////        System.out.println("Новая матрица weightsDeltaLayer1: ");
////        for (int i = 0; i < weightsDeltaLayer1.length; i++) {
////            for (int j = 0; j < weightsDeltaLayer1[0].length; j++) {
////                System.out.print(" | " + weightsDeltaLayer1[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
//        weights_0_1 = MatrixMath.T(
//                MatrixMath.difference(
//                        MatrixMath.multiply(
//                            inputs,
//                            weightsDeltaLayer1
//                        ),
//                        Constants.H
//                )
//        );
//
//
//        /////////////////////////////
//        /////////////////////////////
////        System.out.println("/////////////////////////////");
////
////        inputs_1 = MatrixMath.multiply(weights_0_1, inputs);
////
////        System.out.println("Новая матрица inputs_1: ");
////        for (int i = 0; i < inputs_1.length; i++) {
////            for (int j = 0; j < inputs_1[0].length; j++) {
////                System.out.print(" | " + inputs_1[i][j]);
////            }
////            System.out.println(" | ");
////        }
////        System.out.println("Новая матрица outputs_1: ");
////        outputs_1 = Mapper.sigmoid(inputs_1);
////        for (int i = 0; i < outputs_1.length; i++) {
////            for (int j = 0; j < outputs_1[0].length; j++) {
////                System.out.print(" | " + outputs_1[i][j]);
////            }
////            System.out.println(" | ");
////        }
////
////        inputs_2 = MatrixMath.multiply(weights_1_2, outputs_1);
////
////        System.out.println("Новая матрица inputs_2: ");
////        for (int i = 0; i < inputs_2.length; i++) {
////            for (int j = 0; j < inputs_2[0].length; j++) {
////                System.out.print(" | " + inputs_2[i][j]);
////            }
////            System.out.println(" | ");
////        }
////
////        outputs_2 = Mapper.sigmoid(inputs_2);
////
////        System.out.println("Новая матрица outputs_2: ");
////        for (int i = 0; i < outputs_2.length; i++) {
////            for (int j = 0; j < outputs_2[0].length; j++) {
////                System.out.print(" | " + outputs_2[i][j]);
////            }
////            System.out.println(" | ");
////        }
////
////        actualPredict = outputs_2;
////
////        errorLayer2 = MatrixMath.difference(actualPredict, expected);
////        gradientLayer2 = MatrixMath.vectorsMultiply(actualPredict, MatrixMath.difference(1.0, actualPredict)); //actualPredict * (1 - actualPredict)
////        weightsDeltaLayer2 = MatrixMath.vectorsMultiply(errorLayer2, gradientLayer2);
////        errorLayer1 = MatrixMath.multiply(weightsDeltaLayer2,  weights_1_2);
////        gradientLayer1 = MatrixMath.multiply(outputs_1, MatrixMath.T(MatrixMath.difference(1.0, outputs_1)));
////        weightsDeltaLayer1 = MatrixMath.multiply(errorLayer1, gradientLayer1);
////        weights_0_1 = MatrixMath.T(
////                MatrixMath.difference(
////                        MatrixMath.multiply(
////                                inputs,
////                                weightsDeltaLayer1
////                        ),
////                        Constants.H
////                )
////        );
//
//
//        /////////////////////////////
//        /////////////////////////////
////        System.out.println("/////////////////////////////");
////
////        inputs_1 = MatrixMath.multiply(weights_0_1, inputs);
////
////        System.out.println("Новая матрица inputs_1: ");
////        for (int i = 0; i < inputs_1.length; i++) {
////            for (int j = 0; j < inputs_1[0].length; j++) {
////                System.out.print(" | " + inputs_1[i][j]);
////            }
////            System.out.println(" | ");
////        }
////        System.out.println("Новая матрица outputs_1: ");
////        outputs_1 = Mapper.sigmoid(inputs_1);
////        for (int i = 0; i < outputs_1.length; i++) {
////            for (int j = 0; j < outputs_1[0].length; j++) {
////                System.out.print(" | " + outputs_1[i][j]);
////            }
////            System.out.println(" | ");
////        }
////
////        inputs_2 = MatrixMath.multiply(weights_1_2, outputs_1);
////
////        System.out.println("Новая матрица inputs_2: ");
////        for (int i = 0; i < inputs_2.length; i++) {
////            for (int j = 0; j < inputs_2[0].length; j++) {
////                System.out.print(" | " + inputs_2[i][j]);
////            }
////            System.out.println(" | ");
////        }
////
////        outputs_2 = Mapper.sigmoid(inputs_2);
////
////        System.out.println("Новая матрица outputs_2: ");
////        for (int i = 0; i < outputs_2.length; i++) {
////            for (int j = 0; j < outputs_2[0].length; j++) {
////                System.out.print(" | " + outputs_2[i][j]);
////            }
////            System.out.println(" | ");
////        }
//
//    }



    @Test
    public void multiply1() {

    }

    @Test
    public void t() {

    }
}