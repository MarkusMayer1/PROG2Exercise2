package trafficlight.ctrl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.gui.TrafficLight;
import trafficlight.states.State;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightCtrlTest {
    private TrafficLightCtrl ctrl;

    @BeforeEach
    void init() {
        ctrl = TrafficLightCtrl.getInstance();
    }

    @Test
    @DisplayName("Test if get instance returns the same object")
    void checkGetInstance() {
        TrafficLightCtrl test = TrafficLightCtrl.getInstance();
        assertEquals(test, ctrl);
    }

    @Test
    @DisplayName("Test if green light is on after notifying the Oberservers")
    void checkNotifyObservers_Green() {
        TrafficLight green =  new TrafficLight(Color.green);
        State greenState = ctrl.getGreenState();
        greenState.addObserver(green);
        greenState.notifyObservers();
        assertTrue(green.isOn());
    }

    @Test
    @DisplayName("Test if yellow light is on after notifying the Oberservers")
    void checkNotifyObservers_Yellow() {
        TrafficLight yellow =  new TrafficLight(Color.yellow);
        State yellowState = ctrl.getYellowState();
        yellowState.addObserver(yellow);
        yellowState.notifyObservers();
        assertTrue(yellow.isOn());
    }

    @Test
    @DisplayName("Test if red light is on after notifying the Oberservers")
    void checkNotifyObservers_Red() {
        TrafficLight red =  new TrafficLight(Color.red);
        State redState = ctrl.getRedState();
        redState.addObserver(red);
        redState.notifyObservers();
        assertTrue(red.isOn());
    }

    @Test
    @DisplayName("Test change from green to yellow")
    void changeFromGreenToYellow() {
        ctrl.resetState();
        ctrl.nextState();
        assertEquals(ctrl.getCurrentState(), ctrl.getYellowState());
    }

    @Test
    @DisplayName("Test change from green to red")
    public void ChangeFromYellowToRed() {
        ctrl.resetState();
        ctrl.nextState();
        ctrl.nextState();
        assertEquals(ctrl.getCurrentState(), ctrl.getRedState());
    }

    @Test
    @DisplayName("Test change from green to yellow")
    public void ChangeFromRedToYellow() {
        ctrl.resetState();
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        assertEquals(ctrl.getCurrentState(), ctrl.getYellowState());
    }

    @Test
    @DisplayName("Test change from green to green")
    public void ChangeFromYellowToGreen() {
        ctrl.resetState();
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        assertEquals(ctrl.getCurrentState(), ctrl.getGreenState());
    }
}
