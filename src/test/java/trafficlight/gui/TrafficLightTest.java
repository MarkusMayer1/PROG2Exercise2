package trafficlight.gui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TrafficLightTest {
    @Test
    @DisplayName("Test if green light is off at the beginning")
    void checkIsOn_Green() {
        TrafficLight green =  new TrafficLight(Color.green);
        assertFalse(green.isOn());
    }

    @Test
    @DisplayName("Test if yellow light is off at the beginning")
    void checkIsOn_Yellow() {
        TrafficLight yellow =  new TrafficLight(Color.yellow);
        assertFalse(yellow.isOn());
    }

    @Test
    @DisplayName("Test if red light is off at the beginning")
    void checkIsOn_Red() {
        TrafficLight red =  new TrafficLight(Color.red);
        assertFalse(red.isOn());
    }
}
