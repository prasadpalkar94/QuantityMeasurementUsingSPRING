package com.quantitymeasurement.enums;

public enum Unit {
    FEET(UnitType.LENGTH), INCH(UnitType.LENGTH),
    YARD(UnitType.LENGTH), CENTIMETER(UnitType.LENGTH),

    GALLON(UnitType.VOLUME), LITRE(UnitType.VOLUME),
    MILLILITRE(UnitType.VOLUME),

    KILOGRAM(UnitType.MASS), GRAM(UnitType.MASS),
    TONNE(UnitType.MASS),
    FAHRENHEIT(UnitType.TEMPERATURE), CELSIUS(UnitType.TEMPERATURE);

    public UnitType unitType;

    Unit(UnitType unitType) {
        this.unitType = unitType;
    }

}
