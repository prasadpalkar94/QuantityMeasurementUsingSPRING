package com.quantitymeasurement.exception;

public class QuantityMeasurementException extends RuntimeException {
    public enum ExceptionType{
        UNIT_NOT_COMPARABLE,UNIT_NOT_ADDABLE;
    }
    public ExceptionType type;

    public QuantityMeasurementException(String message, ExceptionType exceptionType)
    {
        super(message);
        this.type = exceptionType;
    }
}
