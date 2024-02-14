package de.telran.hw013CodeSmells;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcITest {
    private final CalcI calcI = new CalcI();
    @Test
    void calculateAreaPositiveTest() {
        Assertions.assertEquals(314.159,calcI.calculateArea(1,10),0.001);
        Assertions.assertEquals(100,calcI.calculateArea(2,10));
        Assertions.assertEquals(1.732,calcI.calculateArea(3,2,2,2),0.001);
    }
    @Test
    void calculateAreaNegativeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI.calculateArea(1,-10));
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI.calculateArea(0,10));
        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI.calculateArea(4,10));

        Assertions.assertThrows(IllegalArgumentException.class, ()->calcI.calculateArea(4,2,2,2));
    }


}