package de.telran.testing001;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Taski1Test {
    Taski1 taski1 = new Taski1();

    @Test
    void additionalTest() {
        int actual = taski1.additional(8,12);
        int expected = 20;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void subtractTest() {
        int actual = taski1.subtract(12,8);
        int expected = 4;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void multiplyWithoutZeroTest() {
        int actual = taski1.multiply(12,8);
        int expected = 96;
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void multiplyWithZeroTest() {
        int actual = taski1.multiply(12,0);
        int expected = 0;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void divideWithoutZeroTest() {
        int actual = taski1.divide(16,8);
        int expected = 2;
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void divideWithZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, ()->taski1.divide(16,0));
    }

    @Test
    void powerWithoutZeroTest() {
        Assertions.assertEquals(8,taski1.power(2.0,3));
    }
    @Test
    void powerWithZeroTest() {
        Assertions.assertEquals(1,taski1.power(2.0,0));
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(24,taski1.factorial(4));
        Assertions.assertEquals(720,taski1.factorial(6));
        Assertions.assertEquals(2,taski1.factorial(2));
    }
    @Test
    void factorialWithZeroAndOneParamTest() {
        Assertions.assertEquals(1,taski1.factorial(0));
        Assertions.assertEquals(1,taski1.factorial(1));
    }
    @Test
    void factorialWithNegativeParamTest() {
        Assertions.assertThrows(ArithmeticException.class,()->taski1.factorial(-5));
        Assertions.assertThrows(ArithmeticException.class,()->taski1.factorial(-1));
    }

    @Test
    void absoluteTest() {
        Assertions.assertEquals(10, taski1.absolute(-10));
        Assertions.assertEquals(10, taski1.absolute(10));
    }

    @Test
    void sqrtTest() {
        Assertions.assertEquals(4.0,taski1.sqrt(16));
        Assertions.assertEquals(5.0,taski1.sqrt(25));
    }
    @Test
    void sqrtWithNullAndOneTest() {
        Assertions.assertEquals(1.0,taski1.sqrt(1));
        Assertions.assertEquals(0.0,taski1.sqrt(0));
    }

    @Test
    void logarithmTest() {
        Assertions.assertEquals(4, taski1.logarithm(2,16));
        Assertions.assertEquals(2, taski1.logarithm(10.0,100.0));
    }
    @Test
    void logarithmWithZeroAndNegativeParamTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->taski1.logarithm(0,0));
        Assertions.assertThrows(IllegalArgumentException.class, ()->taski1.logarithm(-5,0));
    }
    @Test
    void logarithmWithOneParamTest() {
        Assertions.assertEquals(0, taski1.logarithm(1.0,100.0));
    }

    @Test
    void sinTest() {
        Assertions.assertEquals(0.8414, taski1.sin(1.0),0.0001);
        Assertions.assertEquals(0.997, taski1.sin(1.5),0.001);
    }
}