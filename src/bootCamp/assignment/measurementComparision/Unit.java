package bootCamp.assignment.measurementComparision;

import java.util.HashMap;

class Unit {

    static final Unit MILLIMETER = new Unit(1, Type.LENGTH);
    static final Unit INCH = new Unit(25, Type.LENGTH);
    static final Unit FEET = new Unit(300, Type.LENGTH);
    static final Unit CENTIMETER = new Unit(10, Type.LENGTH);
    static final Unit LITER = new Unit(1000, Type.VOLUME);
    static final Unit GALLON = new Unit(3780, Type.VOLUME);

    static final Unit CELSIUS = new Unit(1.8, Type.TEMPERATURE);
    static final Unit FAHRENHEIT = new Unit(1, Type.TEMPERATURE);

    private static HashMap<Type, Unit> standardUnit = new HashMap<>(2);

    static {
        standardUnit.put(Type.LENGTH, INCH);
        standardUnit.put(Type.VOLUME, LITER);
        standardUnit.put(Type.TEMPERATURE, FAHRENHEIT);
    }

    private final double ratio;
    private final Type type;

    private Unit(double ratio, Type type) {
        this.ratio = ratio;
        this.type = type;
    }

    Boolean isSameType(Unit unit) {
        return this.type == unit.type;
    }

    double convertToBaseValue(double value) {
        double constant = 0;
        if (this.type == Type.TEMPERATURE && this.ratio != 1) constant = 32;
        return (this.ratio * value) + constant;
    }

    double convertTo(Unit unit, double value) {
        double conversionRatio = this.ratio / unit.ratio;
        return value * conversionRatio;
    }

    Unit getStandardUnit() {
        return standardUnit.get(this.type);
    }

    enum Type {
        LENGTH,
        VOLUME,
        TEMPERATURE
    }

}