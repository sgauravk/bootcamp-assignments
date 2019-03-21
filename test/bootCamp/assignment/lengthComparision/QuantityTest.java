package bootCamp.assignment.lengthComparision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldReturnTrueForValidComparisionForFeetAndInch() {
        Quantity feet = new Quantity(2, Unit.FEET);
        Quantity inch = new Quantity(24, Unit.INCH);
        boolean expected = feet.equals(inch);
        assertTrue(expected);
        assertEquals(feet, inch);
    }

    @Test
    void shouldReturnFalseForInvalidComparisionForFeetAndInch() {
        Quantity feet = new Quantity(1, Unit.FEET);
        Quantity inch = new Quantity(24, Unit.INCH);
        boolean expected = feet.equals(inch);
        assertFalse(expected);
        assertNotEquals(feet, inch);
    }

    @Test
    void shouldReturnTrueForValidComparisionForInchAndCentimeter() {
        Quantity inch = new Quantity(2, Unit.INCH);
        Quantity centimeter = new Quantity(5, Unit.CENTIMETER);
        boolean expected = inch.equals(centimeter);
        assertTrue(expected);
        assertEquals(inch, centimeter);
    }

    @Test
    void shouldReturnFalseForInvalidComparisionForInchAndCentimeter() {
        Quantity inch = new Quantity(2, Unit.INCH);
        Quantity centimeter = new Quantity(6, Unit.CENTIMETER);
        boolean expected = inch.equals(centimeter);
        assertFalse(expected);
        assertNotEquals(inch, centimeter);
    }

    @Test
    void shouldReturnTrueForValidComparisionForCentimeterAndMillimeter() {
        Quantity centimeter = new Quantity(6, Unit.CENTIMETER);
        Quantity millimeter = new Quantity(60, Unit.MILIMETER);
        boolean expected = centimeter.equals(millimeter);
        assertTrue(expected);
        assertEquals(centimeter, millimeter);
    }

    @Test
    void shouldReturnFalseForInvalidComparisionForCentimeterAndMillimeter() {
        Quantity centimeter = new Quantity(6, Unit.CENTIMETER);
        Quantity millimeter = new Quantity(50, Unit.MILIMETER);
        boolean expected = centimeter.equals(millimeter);
        assertFalse(expected);
        assertNotEquals(centimeter, millimeter);
    }
}