package bootCamp.assignment.shapes;

import bootCamp.assignment.shapes.Dimension;
import bootCamp.assignment.shapes.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    @DisplayName("it should calculate area without decimal dimension")
    void calculateAreaForSide4() throws Exception {
        Dimension side = new Dimension(4);
        Square square = new Square(side);
        assertEquals(16, square.calculateArea());
    }

    @Test
    @DisplayName("it should calculate area with decimal dimension")
    void calculateAreaForSide4point4() throws Exception {
        Dimension side = new Dimension(4.4);
        Square square = new Square(side);
        assertEquals(19.4, square.calculateArea(), 0.1);
    }

    @Test
    @DisplayName("it should calculate perimeter without decimal dimension")
    void calculatePerimeter() throws Exception {
        Dimension side = new Dimension(4);
        Square square = new Square(side);
        assertEquals(16, square.calculatePerimeter());
    }

    @Test
    @DisplayName("it should calculate perimeter with decimal dimension")
    void calculatePerimeterForSide4point4() throws Exception {
        Dimension side = new Dimension(4.4);
        Square square = new Square(side);
        assertEquals(17.6, square.calculatePerimeter(), 0.1);
    }
}