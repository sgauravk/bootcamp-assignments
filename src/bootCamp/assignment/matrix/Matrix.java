package bootCamp.assignment.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Matrix {
    private List<List<Double>> matrix;

    Matrix(List<List<Double>> matrix) throws Exception {
        validateMatrix(matrix);
        this.matrix = matrix;
    }


    private void validateMatrix(List<List<Double>> matrix) throws Exception {
        int firstRowLength = matrix.get(0).size();
        if (matrix.stream().anyMatch(row -> row.size() != firstRowLength)) {
            throw new Exception("invalid matrix");
        }
    }


    private void validateMatrixForAddition(Matrix anotherMatrix) throws Exception {
        int numOfRowInFirst = this.matrix.size();
        int numOfRowInSecond = anotherMatrix.matrix.size();

        int numOfColumnInFirst = this.matrix.get(0).size();
        int numOfColumnInSecond = anotherMatrix.matrix.get(0).size();

        if (numOfRowInFirst != numOfRowInSecond || numOfColumnInFirst != numOfColumnInSecond) {
            throw new Exception("matrix can not be add");
        }
    }


    private void validateMatrixForMultiplication(Matrix anotherMatrix) throws Exception {
        int numOfRowInFirst = this.matrix.get(0).size();

        int numOfColumnInSecond = anotherMatrix.matrix.size();

        if (numOfRowInFirst != numOfColumnInSecond) {
            throw new Exception("matrix can not be multiply");
        }
    }


    private List<Double> addRow(List<Double> firstRow, List<Double> secondRow) {
        List<Double> result = new ArrayList<>(firstRow.size());
        for (int i = 0; i < firstRow.size(); i++) {
            result.add(firstRow.get(i) + secondRow.get(i));
        }
        return result;
    }


    private List<Double> subtractRow(List<Double> firstRow, List<Double> secondRow) {
        List<Double> result = new ArrayList<>(firstRow.size());
        for (int i = 0; i < firstRow.size(); i++) {
            result.add(firstRow.get(i) - secondRow.get(i));
        }
        return result;
    }


    private List<Double> multiplyRow(double multiplier, List<Double> row) {
        List<Double> result = new ArrayList<>(row.size());

        row.forEach(element -> result.add(element * multiplier));
        return result;
    }


    private double multiplyRow(List<Double> row, List<Double> column) {
        double result = 0;

        for (int i = 0; i < row.size(); i++) {
            result += row.get(i) * column.get(i);
        }
        return result;
    }


    private List<Double> calculateColumn(List<List<Double>> matrix, int columnNum) {
        List<Double> column = new ArrayList<>(matrix.get(0).size());

        matrix.forEach(row -> column.add(row.get(columnNum)));
        return column;
    }


    Matrix add(Matrix anotherMatrix) throws Exception {
        validateMatrixForAddition(anotherMatrix);

        List<List<Double>> addition = new ArrayList<>(this.matrix.size());
        for (int i = 0; i < this.matrix.size(); i++) {
            addition.add(addRow(this.matrix.get(i), anotherMatrix.matrix.get(i)));
        }
        return new Matrix(addition);
    }


    Matrix subtract(Matrix anotherMatrix) throws Exception {
        validateMatrixForAddition(anotherMatrix);

        List<List<Double>> subtraction = new ArrayList<>(this.matrix.size());
        for (int i = 0; i < this.matrix.size(); i++) {
            subtraction.add(subtractRow(this.matrix.get(i), anotherMatrix.matrix.get(i)));
        }
        return new Matrix(subtraction);
    }


    Matrix multiply(double multiplier) throws Exception {
        List<List<Double>> result = new ArrayList<>(this.matrix.size());

        this.matrix.forEach(row -> result.add(multiplyRow(multiplier, row)));
        return new Matrix(result);
    }


    Matrix transpose() throws Exception {
        List<List<Double>> transpose = new ArrayList<>(this.matrix.get(0).size());

        for (int i = 0; i < this.matrix.get(0).size(); i++) {
            transpose.add(calculateColumn(this.matrix, i));
        }
        return new Matrix(transpose);
    }


    private List<Double> getRowAfterMultiplication(List<Double> row, Matrix matrix) {
        List<Double> result = new ArrayList<>(matrix.matrix.get(0).size());

        for (int i = 0; i < matrix.matrix.get(0).size(); i++) {
            result.add(multiplyRow(row, calculateColumn(matrix.matrix, i)));
        }
        return result;
    }


    Matrix multiply(Matrix anotherMatrix) throws Exception {
        validateMatrixForMultiplication(anotherMatrix);

        List<List<Double>> result = new ArrayList<>(this.matrix.size());
        this.matrix.forEach(row -> result.add(getRowAfterMultiplication(row, anotherMatrix)));
        return new Matrix(result);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix1 = (Matrix) o;
        return Objects.equals(matrix, matrix1.matrix);
    }
}