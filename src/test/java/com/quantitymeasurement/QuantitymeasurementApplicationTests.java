package com.quantitymeasurement;

import com.quantitymeasurement.enums.Unit;
import com.quantitymeasurement.enums.UnitType;
import com.quantitymeasurement.model.UnitDto;
import com.quantitymeasurement.services.QuantityMeasurementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static com.quantitymeasurement.enums.Unit.*;
import static com.quantitymeasurement.enums.UnitType.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class QuantitymeasurementApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    @Test
    public void givenUnitType_WhenGetUnitType_ShouldReturnJsonArray() throws Exception{
        UnitType[] result = {LENGTH,VOLUME,MASS,TEMPERATURE};
        given(quantityMeasurementService.getUnitType()).willReturn(result);
        mockMvc.perform(get("/mainUnit"))
                 .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(Arrays.toString(result)));
    }


    @Test
    public void givenSubUnitType_WhenGetUnitType_ThenReturnJsonArray() throws Exception {
        Unit[] result={FEET,INCH,CENTIMETER,YARD};
        given(quantityMeasurementService.getUnit(LENGTH)).willReturn(Arrays.asList(result));
        mockMvc.perform(get("/quantity/LENGTH"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(Arrays.toString(result)));
    }

    @Test
    public void givenUnitTypeAndSubUnitTypeForConversion() throws Exception {
        double initialValue = 1.0;
        Unit initialUnit = FEET;
        Unit outputUnit = INCH;
        UnitType type  = LENGTH;
        double outputValue = 12.0;
        UnitDto unitDto = new UnitDto(initialValue,initialUnit,outputUnit,type,outputValue);
        given(quantityMeasurementService.conversion(initialValue,initialUnit,outputUnit,type)).willReturn(unitDto);
        mockMvc.perform(get("/conversion"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(unitDto)));
    }
}
