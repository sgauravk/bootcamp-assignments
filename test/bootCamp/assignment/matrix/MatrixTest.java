package bootCamp.assignment.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void shouldNotThrowAnExceptionForValidMatrix() {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        List<List<Double>> matrix = Arrays.asList(firstRow, secondRow);

        assertDoesNotThrow(() -> new Matrix(matrix));
    }

    @Test
    void shouldThrowAnExceptionForInvalidMatrix() {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D, 3.0D);
        List<List<Double>> matrix = Arrays.asList(firstRow, secondRow);

        assertThrows(Exception.class, () -> new Matrix(matrix));
    }

    @Test
    void shouldAddValidMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        Matrix first = new Matrix(Arrays.asList(firstRow, secondRow));

        Matrix second = new Matrix(Arrays.asList(firstRow, secondRow));

        List<Double> expectedFirstRow = Arrays.asList(2.0D, 4.0D);
        List<Double> expectedSecondRow = Arrays.asList(8.0D, 10.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), first.add(second));
    }

    @Test
    void shouldSubtractValidMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        Matrix first = new Matrix(Arrays.asList(firstRow, secondRow));

        Matrix second = new Matrix(Arrays.asList(firstRow, secondRow));

        List<Double> expectedFirstRow = Arrays.asList(0.0D, 0.0D);
        List<Double> expectedSecondRow = Arrays.asList(0.0D, 0.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), first.subtract(second));
    }

    @Test
    void shouldMultiplyMatrixWithGivenPositiveNumber() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        Matrix first = new Matrix(Arrays.asList(firstRow, secondRow));

        List<Double> expectedFirstRow = Arrays.asList(2.0D, 4.0D);
        List<Double> expectedSecondRow = Arrays.asList(8.0D, 10.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), first.multiply(2));
    }

    @Test
    void shouldMultiplyMatrixWithGivenNegativeNumber() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        Matrix first = new Matrix(Arrays.asList(firstRow, secondRow));

        List<Double> expectedFirstRow = Arrays.asList(-5.0D, -10.0D);
        List<Double> expectedSecondRow = Arrays.asList(-20.0D, -25.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), first.multiply(-5));
    }

    @Test
    void shouldReturnTheTransposeOfMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(2.0D, 3.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        List<Double> thirdRow = Arrays.asList(8.0D, 0.0D);
        Matrix matrix = new Matrix(Arrays.asList(firstRow, secondRow, thirdRow));

        List<Double> expectedFirstRow = Arrays.asList(2.0D, 4.0D, 8.0D);
        List<Double> expectedSecondRow = Arrays.asList(3.0D, 5.0D, 0.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), matrix.transpose());
    }

    @Test
    void shouldReturnTheTransposeOfSingleNumberMatrix() throws Exception {
        List<Double> firstRow = Collections.singletonList(9.0D);
        Matrix matrix = new Matrix(Collections.singletonList(firstRow));

        List<Double> expectedFirstRow = Collections.singletonList(9.0D);
        List<List<Double>> expected = Collections.singletonList(expectedFirstRow);

        assertEquals(new Matrix(expected), matrix.transpose());
    }


    @Test
    void shouldReturnTheMultiplicationOfTwoMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(3.0D, 4.0D);
        Matrix firstMatrix = new Matrix(Arrays.asList(firstRow, secondRow));

        List<Double> thirdRow = Arrays.asList(2.0D, 0.0D);
        List<Double> fourthRow = Arrays.asList(1.0D, 2.0D);
        Matrix secondMatrix = new Matrix(Arrays.asList(thirdRow, fourthRow));

        List<Double> expectedFirstRow = Arrays.asList(4.0D, 4.0D);
        List<Double> expectedSecondRow = Arrays.asList(10.0D, 8.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), firstMatrix.multiply(secondMatrix));
    }


    @Test
    void shouldReturnTheMultiplicationOfAnotherTwoMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(2.0D, 0.0D);
        List<Double> secondRow = Arrays.asList(1.0D, 2.0D);
        Matrix firstMatrix = new Matrix(Arrays.asList(firstRow, secondRow));

        List<Double> thirdRow = Arrays.asList(1.0D, 2.0D);
        List<Double> fourthRow = Arrays.asList(3.0D, 4.0D);
        Matrix secondMatrix = new Matrix(Arrays.asList(thirdRow, fourthRow));

        List<Double> expectedFirstRow = Arrays.asList(2.0D, 4.0D);
        List<Double> expectedSecondRow = Arrays.asList(7.0D, 10.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), firstMatrix.multiply(secondMatrix));
    }

    @Test
    void shouldReturnTheMultiplicationOfNonSquareMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 4.0D, 6.0D, 10.0D);
        List<Double> secondRow = Arrays.asList(2.0D, 7.0D, 5.0D, 3.0D);
        Matrix firstMatrix = new Matrix(Arrays.asList(firstRow, secondRow));

        List<Double> thirdRow = Arrays.asList(1.0D, 4.0D, 6.0D);
        List<Double> fourthRow = Arrays.asList(2.0D, 7.0D, 5.0D);
        List<Double> fifthRow = Arrays.asList(9.0D, 0.0D, 11.0D);
        List<Double> sixthRow = Arrays.asList(3.0D, 1.0D, 0.0D);
        Matrix secondMatrix = new Matrix(Arrays.asList(thirdRow, fourthRow, fifthRow, sixthRow));

        List<Double> expectedFirstRow = Arrays.asList(93.0D, 42.0D, 92.0D);
        List<Double> expectedSecondRow = Arrays.asList(70.0D, 60.0D, 102.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(new Matrix(expected), firstMatrix.multiply(secondMatrix));
    }

    @Test
    void shouldReturnTheMultiplicationOfSingleRowAndSingleColumnMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D, 3.0D);
        Matrix firstMatrix = new Matrix(Collections.singletonList(firstRow));

        List<Double> secondRow = Collections.singletonList(4.0D);
        List<Double> thirdRow = Collections.singletonList(5.0D);
        List<Double> fourthRow = Collections.singletonList(6.0D);
        Matrix secondMatrix = new Matrix(Arrays.asList(secondRow, thirdRow, fourthRow));

        List<Double> expectedFirstRow = Collections.singletonList(32.0D);
        List<List<Double>> expected = Collections.singletonList(expectedFirstRow);

        assertEquals(new Matrix(expected), firstMatrix.multiply(secondMatrix));
    }

    @Test
    void shouldReturnTheMultiplicationOfMatrixWithItsTranspose() throws Exception {
        List<Double> firstRow = Collections.singletonList(1.0D);
        List<Double> secondRow = Collections.singletonList(2.0D);
        List<Double> thirdRow = Collections.singletonList(3.0D);
        Matrix firstMatrix = new Matrix(Arrays.asList(firstRow, secondRow, thirdRow));

        List<Double> expectedFirstRow = Arrays.asList(1.0D, 2.0D, 3.0D);
        List<Double> expectedSecondRow = Arrays.asList(2.0D, 4.0D, 6.0D);
        List<Double> expectedThirdRow = Arrays.asList(3.0D, 6.0D, 9.0D);
        List<List<Double>> expected = Arrays.asList(expectedFirstRow, expectedSecondRow, expectedThirdRow);

        assertEquals(new Matrix(expected), firstMatrix.multiply(firstMatrix.transpose()));
    }
}