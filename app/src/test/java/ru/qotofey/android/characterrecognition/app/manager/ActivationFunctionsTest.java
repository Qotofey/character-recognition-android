package ru.qotofey.android.characterrecognition.app.manager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActivationFunctionsTest {

    @Test
    public void bipolar() {
        //первый тест
        Double input = 1.0;
        Double output;
        Double expected = 0.762;
        Double delta = 0.001;

        ActivationFunctions activationFunctions = new ActivationFunctions();
        output = activationFunctions.bipolar(input);

        assertEquals(expected, output, delta);

        //второй тест
        input = 1.52;
        expected = 0.908;
        delta = 0.001;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output, delta);

        /*
         *  вторая итерация
         */

        //первый тест
        input = 0.866;
        expected = 0.699;
        delta = 0.001;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output, delta);

        //первый тест
        input = 1.015;
        expected = 0.768;
        delta = 0.001;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output, delta);

        //третий тест
        input = (0.699 + 0.768) * 0.841;
        expected = 0.844;
        delta = 0.001;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output, delta);

        //четвёртый тест
        input = (0.699 + 0.768) * 1.015;
        expected = 0.903;
        delta = 0.001;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output, delta);
    }

    @Test
    public void derivativeBipolar() {
        //первый тест
        Double input =  1.52;
        Double output;
        Double expected = 0.174;
        Double delta = 0.001;

        ActivationFunctions activationFunctions = new ActivationFunctions();
        output = activationFunctions.derivativeBipolar(input);

        assertEquals(expected, output, delta);

        //второй тест
        input = 1.0;
        expected = 0.419;

        output = activationFunctions.derivativeBipolar(input);

        assertEquals(expected, output, delta);
    }

    @Test
    public void errors() {
        Double[][][] w = new Double[2][2][2];
        w[0][0][0] = 1.0;
        w[0][0][1] = 1.0;
        w[0][1][0] = 1.0;
        w[0][1][1] = 1.0;

        w[1][0][0] = 1.0;
        w[1][0][1] = 1.0;
        w[1][1][0] = 1.0;
        w[1][1][1] = 1.0;

        Double output;
        Double expected;

        Double delta = 0.001;

        /*
         * Первая итерация
         */

        //общая ошибка
        expected = 0.836;
        output = (0.91 - 0.0) * (0.91 - 0.0) + (0.91 - 1.0) * (0.91 - 1.0);
        assertEquals(expected, output, delta); //результат функции ошибки

        //функция ошибки на дендритах нейрона y1
        expected = 0.317;
        output = 2 * (0.91 - 0.0) * ActivationFunctions.derivativeBipolar(1.52);
        assertEquals(expected, output, delta);
        w[0][0][0] = w[0][0][0] - Constants.H * output;
        w[0][0][1] = w[0][0][1] - Constants.H * output;
        assertEquals(0.841, w[0][0][0], delta); //результат веса
        assertEquals(0.841, w[0][0][1], delta); //результат веса

        assertEquals(0.841, w[0][0][0], delta); //результат веса
        //функция ошибки на дендритах нейрона y2
        expected = -0.031;
        output = 2 * (0.91 - 1.0) * ActivationFunctions.derivativeBipolar(1.52);
        assertEquals(expected, output, delta);
        w[0][1][0] = w[0][1][0] - Constants.H * output;
        w[0][1][1] = w[0][1][1] - Constants.H * output;
        assertEquals(1.015, w[0][1][0], delta); //результат веса
        assertEquals(1.015, w[0][1][1], delta); //результат веса

        expected = 0.157;
        output = 2 * (0.91 - 0.0) * ActivationFunctions.derivativeBipolar(1.52) * w[0][0][0] * ActivationFunctions.derivativeBipolar(0.76) * w[1][0][0]; //функция ошибки на дендрите нейрона x1
        assertEquals(expected, output, delta);
        w[1][0][0] = w[1][0][0] - Constants.H * output;
        assertEquals(0.921, w[1][0][0], delta); //результат веса

        expected = 0.157;
        output = 2 * (0.91 - 0.0) * ActivationFunctions.derivativeBipolar(1.52) * w[0][0][1] * ActivationFunctions.derivativeBipolar(0.76) * w[1][0][1]; //функция ошибки на дендрите нейрона x1
        assertEquals(expected, output, delta);
        w[1][0][1] = w[1][0][1] - Constants.H * output;
        assertEquals(0.921, w[1][0][1], delta); //результат веса

        expected = -0.019;
        output = 2 * (0.91 - 1.0) * ActivationFunctions.derivativeBipolar(1.52) * w[0][1][0] * ActivationFunctions.derivativeBipolar(0.76) * w[1][1][0]; //функция ошибки на дендрите нейрона x2
        assertEquals(expected, output, delta);
        w[1][1][0] = w[1][1][0] - Constants.H * output;
        assertEquals(1.009, w[1][1][0], delta); //результат веса

        expected = -0.019;
        output = 2 * (0.91 - 1.0) * ActivationFunctions.derivativeBipolar(1.52) * w[0][1][1] * ActivationFunctions.derivativeBipolar(0.76) * w[1][1][1]; //функция ошибки на дендрите нейрона x2
        assertEquals(expected, output, delta);
        w[1][1][0] = w[1][1][0] - Constants.H * output;
        assertEquals(1.0, w[1][1][1], delta); //результат веса

        /*
         * Вторая итерация
         */


    }
}