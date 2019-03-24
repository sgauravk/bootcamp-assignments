package bootCamp.assignment.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        List<List<Double>> firstMatrix = Arrays.asList(firstRow, secondRow);
        Matrix first = new Matrix(firstMatrix);

        List<List<Double>> secondMatrix = Arrays.asList(firstRow, secondRow);
        Matrix second = new Matrix(secondMatrix);

        List<Double> expectedFirstRow = Arrays.asList(2.0D, 4.0D);
        List<Double> expectedSecondRow = Arrays.asList(8.0D, 10.0D);
        List<List<Double>> expectedMatrix = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(expectedMatrix, first.add(second));
    }

    @Test
    void shouldSubtractValidMatrix() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        List<List<Double>> firstMatrix = Arrays.asList(firstRow, secondRow);
        Matrix first = new Matrix(firstMatrix);

        List<List<Double>> secondMatrix = Arrays.asList(firstRow, secondRow);
        Matrix second = new Matrix(secondMatrix);

        List<Double> expectedFirstRow = Arrays.asList(0.0D, 0.0D);
        List<Double> expectedSecondRow = Arrays.asList(0.0D, 0.0D);
        List<List<Double>> expectedMatrix = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(expectedMatrix, first.subtract(second));
    }

    @Test
    void shouldMultiplyMatrixWithGivenPositiveNumber() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        List<List<Double>> firstMatrix = Arrays.asList(firstRow, secondRow);
        Matrix first = new Matrix(firstMatrix);

        List<Double> expectedFirstRow = Arrays.asList(2.0D, 4.0D);
        List<Double> expectedSecondRow = Arrays.asList(8.0D, 10.0D);
        List<List<Double>> expectedMatrix = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(expectedMatrix, first.multiply(2));
    }

    @Test
    void shouldMultiplyMatrixWithGivenNegativeNumber() throws Exception {
        List<Double> firstRow = Arrays.asList(1.0D, 2.0D);
        List<Double> secondRow = Arrays.asList(4.0D, 5.0D);
        List<List<Double>> firstMatrix = Arrays.asList(firstRow, secondRow);
        Matrix first = new Matrix(firstMatrix);

        List<Double> expectedFirstRow = Arrays.asList(-5.0D, -10.0D);
        List<Double> expectedSecondRow = Arrays.asList(-20.0D, -25.0D);
        List<List<Double>> expectedMatrix = Arrays.asList(expectedFirstRow, expectedSecondRow);

        assertEquals(expectedMatrix, first.multiply(-5));
    }
}