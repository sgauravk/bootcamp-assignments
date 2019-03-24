package bootCamp.assignment.measurementComparision;

class Quantity {

    private Unit unit;
    private double value;


    Quantity(double value, Unit unit) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quantity)) return false;
        Unit quantityUnit = ((Quantity) o).unit;
        double quantityValue = ((Quantity) o).value;
        if (!quantityUnit.isSameType(this.unit)) return false;
        double baseValue = this.unit.convertToBaseValue(this.value);
        System.out.println(quantityUnit.convertToBaseValue(quantityValue));
        System.out.println(baseValue);
        return baseValue == quantityUnit.convertToBaseValue(quantityValue);
    }


    Quantity add(Quantity quantity) throws Exception {
        if (!this.unit.isSameType(quantity.unit)) {
            throw new Exception("invalid type"); //needs to change.
        }
        Unit standardUnit = this.unit.getStandardUnit();

        double thisQuantityValue = this.unit.convertTo(standardUnit, this.value);
        Quantity thisQuantity =  new Quantity(thisQuantityValue, standardUnit);

        double anotherQuantityValue = quantity.unit.convertTo(standardUnit, quantity.value);
        Quantity anotherQuantity = new Quantity(anotherQuantityValue, standardUnit);

        double valueInStandardUnit = thisQuantity.value + anotherQuantity.value;
        return new Quantity(valueInStandardUnit, standardUnit);
    }
}

