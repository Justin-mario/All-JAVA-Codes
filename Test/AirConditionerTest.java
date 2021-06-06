import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirConditionerTest {
    @Test
    void checkAirConditionerIsOffByDefault(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
       assertFalse (airConditioner.isOn());
    }

    @Test
    void checkAirConditionerIsON(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn(true);
        assertTrue (airConditioner.isOn());


    }

    @Test
    void checkAirConditionerProductNameCanBeSet(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn (true);
        airConditioner.setProductName ( "LG" );
        assertEquals ("LG",airConditioner.getProductName());
    }

    @Test
    void checkAirConditionerTemperatureCanBeSet(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn (true);
         airConditioner.setTemperature (16);
        assertEquals (16,airConditioner.getTemperature());
    }

    @Test
    void checkAirConditionerTemperatureCanIncreased(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn (true);
        airConditioner.setTemperature (16);
        airConditioner.increaseTemperature();
        airConditioner.increaseTemperature();
        assertEquals (18,airConditioner.getTemperature ());
    }

    @Test
    void checkAirConditionerTemperatureCanDecreased(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn (true);
        airConditioner.setTemperature (16);
        airConditioner.increaseTemperature();
        airConditioner.decreaseTemperature();
        assertEquals (16,airConditioner.getTemperature ());
    }

    @Test
    void checkAirConditionerTemperatureCannotBeZero(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn (true);
        airConditioner.setTemperature (0);
        assertEquals (16,airConditioner.getTemperature ());
    }

    @Test
    void checkAirConditionerTemperatureCannotBeANegativeNumber(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn (true);
        airConditioner.setTemperature (-16);
        assertEquals (16,airConditioner.getTemperature ());
    }
    @Test
    void checkAirConditionerTemperatureCannotBeAbove30(){
        AirConditioner airConditioner = new AirConditioner ("Samsung");
        airConditioner.setOn (true);
        airConditioner.setTemperature (31);
        assertEquals (16,airConditioner.getTemperature ());
    }
}