package bootCamp.assignment.lengthComparision;

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
        double baseValue = this.unit.convertToBaseValue(this.value);
        return baseValue == quantityUnit.convertToBaseValue(quantityValue);
    }


}
