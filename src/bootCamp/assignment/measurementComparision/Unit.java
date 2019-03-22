package bootCamp.assignment.measurementComparision;

class Unit {

    enum Type{
        LENGTH,
        VOLUME
    }

    private final double ratio;
    private final Type type;

    static final Unit MILLIMETER = new Unit(1, Type.LENGTH);
    static final Unit INCH = new Unit(25, Type.LENGTH);
    static final Unit FEET = new Unit(300, Type.LENGTH);
    static final Unit CENTIMETER = new Unit(10, Type.LENGTH);

    static final Unit LITER = new Unit(1000, Type.VOLUME);
    static final Unit GALLON = new Unit(3780, Type.VOLUME);

    private Unit(double ratio, Type type) {
        this.ratio = ratio;
        this.type = type;
    }

    Boolean isSameType(Unit unit){
        return this.type == unit.type;
    }

    double convertToBaseValue(double value) {
        return this.ratio * value;
    }

    double getRatio() {
        return ratio;
    }
}
