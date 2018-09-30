package ru.qotofey.android.characterrecognition.app.manager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class ActivationFunctionsTest {

    @Rule
    public Timeout timeout = new Timeout(10);

    @Test
    public void bipolar() {
        //первый тест
        Float input = -0.00001F;
        Float output;
        Float expected = -1.0F;
        Float delta = 0.1F;

        ActivationFunctions activationFunctions = new ActivationFunctions();
        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //второй тест
        input = 0.00001F;
        expected = 1.0F;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //третий тест
        input = 0.0F;
        expected = 1.0F;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //пятый тест
        input = 999999.999999F;
        expected = 1.0F;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);

        //шестой товар
        input = -999999.999999F;
        expected = -1.0F;

        output = activationFunctions.bipolar(input);

        assertEquals(expected, output);
    }

}