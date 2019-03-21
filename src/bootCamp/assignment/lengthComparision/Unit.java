package bootCamp.assignment.lengthComparision;

class Unit {
    static final Unit MILIMETER = new Unit(1);
    static final Unit INCH = new Unit(25);
    static final Unit FEET = new Unit(300);
    static final Unit CENTIMETER = new Unit(10);
    private double ratio;

    private Unit(double ratio) {
        this.ratio = ratio;
    }

    double convertToBaseValue(double value) {
        return this.ratio * value;
    }
}
