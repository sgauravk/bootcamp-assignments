package bootCamp.assignment.measurementComparision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldReturnTrueForValidComparisionForFeetAndInch() {
        Quantity feet = new Quantity(2, Unit.FEET);
        Quantity inch = new Quantity(24, Unit.INCH);
        assertEquals(feet, inch);
    }

    @Test
    void shouldReturnFalseForInvalidComparisionForFeetAndInch() {
        Quantity feet = new Quantity(1, Unit.FEET);
        Quantity inch = new Quantity(24, Unit.INCH);
        assertNotEquals(feet, inch);
    }

    @Test
    void shouldReturnTrueForValidComparisionForInchAndCentimeter() {
        Quantity inch = new Quantity(2, Unit.INCH);
        Quantity centimeter = new Quantity(5, Unit.CENTIMETER);
        assertEquals(inch, centimeter);
    }

    @Test
    void shouldReturnFalseForInvalidComparisionForInchAndCentimeter() {
        Quantity inch = new Quantity(2, Unit.INCH);
        Quantity centimeter = new Quantity(6, Unit.CENTIMETER);
        assertNotEquals(inch, centimeter);
    }

    @Test
    void shouldReturnTrueForValidComparisionForCentimeterAndMillimeter() {
        Quantity centimeter = new Quantity(6, Unit.CENTIMETER);
        Quantity millimeter = new Quantity(60, Unit.MILLIMETER);
        assertEquals(centimeter, millimeter);
    }

    @Test
    void shouldReturnFalseForInvalidComparisionForCentimeterAndMillimeter() {
        Quantity centimeter = new Quantity(6, Unit.CENTIMETER);
        Quantity millimeter = new Quantity(50, Unit.MILLIMETER);
        assertNotEquals(centimeter, millimeter);
    }

    @Test
    void shouldReturnTrueForValidComparisionForGallonAndLiters() {
        Quantity gallon = new Quantity(1, Unit.GALLON);
        Quantity liters = new Quantity(3.78, Unit.LITER);
        assertEquals(gallon, liters);
    }

    @Test
    void shouldReturnFalseForValidComparisionForGallonAndLiters() {
        Quantity gallon = new Quantity(1, Unit.GALLON);
        Quantity liters = new Quantity(2.78, Unit.LITER);
        assertNotEquals(gallon, liters);
    }

    @Test
    void shouldReturnFalseForDifferentTypesComparision() {
        Quantity liter = new Quantity(1, Unit.LITER);
        Quantity centimeter = new Quantity(100, Unit.CENTIMETER);
        assertNotEquals(liter, centimeter);
    }

    @Test
    void shouldAddTwoLengthsOfSameType() throws Exception {
        Quantity twoInches = new Quantity(2, Unit.INCH);
        Quantity expectedSum = new Quantity(4, Unit.INCH);
        Quantity actualSum = twoInches.add(twoInches);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void shouldThrowExceptionForTwoLengthsOfDifferentType() {
        Quantity twoInches = new Quantity(2, Unit.INCH);
        Quantity fourGallon = new Quantity(4, Unit.GALLON);
        assertThrows(Exception.class, () -> twoInches.add(fourGallon));
    }

    @Test
    void shouldConvertToOneTypeIfTypesAreSameButUnitsAreDifferent() throws Exception {
        Quantity oneInch = new Quantity(1, Unit.INCH);
        Quantity twentyFiveMm = new Quantity(25, Unit.MILLIMETER);
        Quantity actualQuantity = oneInch.add(twentyFiveMm);
        Quantity expectedQuantity = new Quantity(2, Unit.INCH);
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    void shouldAddTwoPointFiveCmWithTwoInches() throws Exception {
        Quantity twoInches = new Quantity(2, Unit.INCH);
        Quantity twoPointFiveCm = new Quantity(2.5D, Unit.CENTIMETER);
        Quantity actualQuantity = twoInches.add(twoPointFiveCm);
        Quantity expectedQuantity = new Quantity(3, Unit.INCH);
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    void shouldAddTwoInchesWithTwoPointFiveCm() throws Exception {
        Quantity twoInches = new Quantity(2, Unit.INCH);
        Quantity twoPointFiveCm = new Quantity(2.5D, Unit.CENTIMETER);
        Quantity actualQuantity = twoPointFiveCm.add(twoInches);
        Quantity expectedQuantity = new Quantity(3, Unit.INCH);
        assertEquals(expectedQuantity, actualQuantity);
    }


    @Test
    void shouldAddOneFeetWithTwoInches() throws Exception {
        Quantity twoFeet = new Quantity(2, Unit.FEET);
        Quantity twoInches = new Quantity(2, Unit.INCH);
        Quantity actualQuantity = twoFeet.add(twoInches);
        Quantity expectedQuantity = new Quantity(26, Unit.INCH);
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    void shouldAddOneGallonWithOneLiter() throws Exception {
        Quantity OneGallon = new Quantity(100, Unit.GALLON);
        Quantity OneLiter = new Quantity(1, Unit.LITER);
        Quantity actualQuantity = OneGallon.add(OneLiter);
        Quantity expectedQuantity = new Quantity(379, Unit.LITER);
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    void shouldCompare212FahrenheitWith100Celsius() throws Exception {

        Quantity hundredCelsius = new Quantity(100, Unit.CELSIUS);
        Quantity twoOneTwoFahrenheit = new Quantity(212, Unit.FAHRENHEIT);
        assertEquals(hundredCelsius, twoOneTwoFahrenheit);
    }
}
