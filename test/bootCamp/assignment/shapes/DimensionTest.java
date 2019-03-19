package bootCamp.assignment.shapes;

import bootCamp.assignment.shapes.Dimension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {

    @Test
    void getDimensionOfPositiveInteger() throws Exception {
        Dimension dimension = new Dimension(5D);
        assertEquals(5, dimension.getValue());
    }

    @Test
    void getDimensionOfNegativeInteger() {
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Dimension(-1D);
            }
        });
    }
}