package bootCamp.assignment.matrix;

import java.util.ArrayList;
import java.util.List;

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
        int numOfColumnInSecond = this.matrix.get(0).size();

        if (numOfRowInFirst != numOfRowInSecond || numOfColumnInFirst != numOfColumnInSecond) {
            throw new Exception("matrix can not be add");
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


    List<List<Double>> add(Matrix anotherMatrix) throws Exception {
        validateMatrixForAddition(anotherMatrix);

        List<List<Double>> addition = new ArrayList<>(this.matrix.size());
        for (int i = 0; i < this.matrix.size(); i++) {
            addition.add(addRow(this.matrix.get(i), anotherMatrix.matrix.get(i)));
        }
        return addition;
    }


    List<List<Double>> subtract(Matrix anotherMatrix) throws Exception {
        validateMatrixForAddition(anotherMatrix);

        List<List<Double>> subtraction = new ArrayList<>(this.matrix.size());
        for (int i = 0; i < this.matrix.size(); i++) {
            subtraction.add(subtractRow(this.matrix.get(i), anotherMatrix.matrix.get(i)));
        }
        return subtraction;
    }


    List<List<Double>> multiply(double multiplier) {
        List<List<Double>> result = new ArrayList<>(this.matrix.size());

        this.matrix.forEach(row -> result.add(multiplyRow(multiplier, row)));
        return result;
    }
}
