package com.quantitymeasurement.model;


import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.enums.UnitType;

public class UnitDto {

    private double initialValue;
    private Unit initialUnit;
    private Unit outputUnit;
    private UnitType type;
    private double outputValue;

    public UnitDto(double initialValue, Unit initialUnit, Unit outputUnit, UnitType type, double outputValue) {
        this.initialValue = initialValue;
        this.initialUnit = initialUnit;
        this.outputUnit = outputUnit;
        this.type = type;
        this.outputValue = outputValue;
    }


    @Override
    public String toString() {
        return "UnitDto{" +
                "initialValue=" + initialValue +
                ", initialUnit=" + initialUnit +
                ", outputUnit=" + outputUnit +
                ", type=" + type +
                ", outputValue=" + outputValue +
                '}';
    }
}
