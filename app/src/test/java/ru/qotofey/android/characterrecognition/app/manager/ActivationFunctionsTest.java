package ru.qotofey.android.characterrecognition.app.manager;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class ActivationFunctionsTest {

    @Rule
    public Timeout timeout = new Timeout(10);

    @Ignore
    @Test
    public void bipolar() {
        //первый тест
        Double input = -0.00001;
        Double output;
        Double expected = -1.0;
        Double delta = 0.1;

        ActivationFunctions activationFunctions = new ActivationFunctions();
        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //второй тест
        input = 0.00001;
        expected = 1.0;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //третий тест
        input = 0.0;
        expected = 1.0;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //пятый тест
        input = 999999.999999;
        expected = 1.0;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //шестой товар
        input = -999999.999999;
        expected = -1.0;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);
    }

}