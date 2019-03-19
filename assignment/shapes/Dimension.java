package bootCamp.assignment.shapes;

public class Dimension {
    private double dimension;

    public Dimension(double dimension) throws Exception {
        validateDimension(dimension);
        this.dimension = dimension;
    }

    private void validateDimension(double dimension) throws Exception{
        if(dimension < 0 ) {
            throw new Exception("Invalid dimension");
        }
    }

    public double getValue() {
        return dimension;
    }
}
