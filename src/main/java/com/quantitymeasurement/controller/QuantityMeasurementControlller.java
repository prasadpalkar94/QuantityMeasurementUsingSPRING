package com.quantitymeasurement.controller;
import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.enums.UnitType;
import com.quantitymeasurement.model.UnitDto;
import com.quantitymeasurement.services.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class QuantityMeasurementControlller {
    @Autowired
   private QuantityMeasurementService quantityMeasurement;

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/mainUnit")
    public UnitType[] getUnit(){
        return quantityMeasurement.getUnitType();
    }

    @GetMapping("/quantity/{unit}")
    public List<Unit> getUnitType(@PathVariable UnitType unit) {
        return quantityMeasurement.getUnit(unit);
    }


    @PostMapping("/conversion")
    public UnitDto getUnitConversion(@RequestParam(value="initialValue") double initialValue,@RequestParam(value = "initialUnit") Unit initialUnit,@RequestParam(value="outputUnit") Unit outputUnit,@RequestParam(value="type") UnitType type,@RequestParam(value = "outputValue") double outputValue){
        return quantityMeasurement.conversion(initialValue,initialUnit,outputUnit,type);
    }




}
