package bootCamp.assignment.shapes;

public class Rectangle implements Shape {
    private Dimension length;
    private Dimension width;

    public Rectangle(Dimension length, Dimension width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return this.length.getValue() * this.width.getValue();
    }

    @Override
    public double calculatePerimeter() {
        return 2*(this.length.getValue() + this.width.getValue());
    }
}
