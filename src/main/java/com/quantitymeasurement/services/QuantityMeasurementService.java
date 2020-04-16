package com.quantitymeasurement.services;

import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.enums.UnitType;
import com.quantitymeasurement.model.UnitDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementService {

    public UnitType[] getUnitType(){
        return null;
    }

    public List<Unit> getUnit(UnitType unit){
        return null;
    }

    public  UnitDto conversion(double initialValue, Unit initialUnit, Unit outputUnit, UnitType type){
        return null;
    }


}
