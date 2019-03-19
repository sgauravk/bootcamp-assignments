package bootCamp.assignment.shapes;

import bootCamp.assignment.shapes.Dimension;
import bootCamp.assignment.shapes.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    @DisplayName("it should calculate area without decimal dimension")
    void calculateAreaWithLengthTwoWidthThree() throws Exception {
        Dimension length = new Dimension(2D);
        Dimension width = new Dimension(4D);
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(8D,rectangle.calculateArea());
    }

    @Test
    @DisplayName("it should calculate area for decimal dimension")
    void calculateAreaWithLengthTwoPointTwoWidthThree() throws Exception {

        Dimension length = new Dimension(2.2D);
        Dimension width = new Dimension(3D);
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(6.6D, rectangle.calculateArea(), 0.1);
    }

    @Test
    @DisplayName("it should calculate perimeter without decimal dimension")
    void calculatePerimeterWithLengthTwoWidthThree() throws Exception {
        Dimension length = new Dimension(2D);
        Dimension width = new Dimension(3D);
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(10.0D,rectangle.calculatePerimeter());
    }

    @Test
    @DisplayName("it should calculate perimeter for decimal dimension")
    void calculatePerimeterWithLengthTwoPointTwoWidthThree() throws Exception {
        Dimension length = new Dimension(2.2D);
        Dimension width = new Dimension(3D);
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(10.4D,rectangle.calculatePerimeter());
    }
}