package de.telran.hw013CodeSmells;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalcI2Test {
    private final CalcI2 calcI2 = new CalcI2(); //Version 2

    @Test
    void calculateAreaPositiveTest() {
        Assertions.assertEquals(314.159,calcI2.calculateArea(1,new double[] {10, 0, 0}),0.001);
        Assertions.assertEquals(100,calcI2.calculateArea(2,new double[] {10, 0, 0}));
        Assertions.assertEquals(1.732,calcI2.calculateArea(3,new double[] {2, 2, 2}),0.001);
    }

    @RepeatedTest(value = 5)
    void calculateAreaNegativeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI2.calculateArea(0,new double[] {2, 2, 2}));
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI2.calculateArea(4,new double[] {2, 2, 2}));

        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI2.calculateArea(1,new double[] {-10, 0, 0}));
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI2.calculateArea(2,new double[] {0, 0, 0}));
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI2.calculateArea(3,new double[] {-1, 0, 1}));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 10, -5, -10})
    void calculateAreaParametriseExampleTest(int args) {
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI2.calculateArea(args,new double[] {2, 2, 2}));
    }
}
