//package bootCamp.assignment.measurementComparision;
//
//
//import java.util.HashMap;
//
//public abstract class UnitNew {
//
//    enum Type {
//        LENGTH,
//        VOLUME,
//        TEMPERATURE
//    }
//
//    private static HashMap<Type, Unit> standardUnit = new HashMap<>(2);
//
//    static {
//        standardUnit.put(Type.LENGTH, INCH);
//        standardUnit.put(Type.VOLUME, LITER);
//        standardUnit.put(Type.TEMPERATURE, FAHRENHEIT);
//    }
//
//
//    abstract double convertToBaseValue(double value);
//    abstract double convertTo(Unit unit, double value);
//
//    Boolean isSameType(Unit unit) {
//        return this.type == unit.type;
//    }
//
//    Unit getStandardUnit() {
//        return this.standardUnit.get(this.type);
//    }
//}
