package com.wisetap.scootyrental.entities;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.wisetap.scootyrental.exceptions.OutletFullException;

@DisplayName(" Outlet Test ")
public class OutletTest {
    
    private static Outlet mockOutlet;
    private static Vehicle mockVehicle;

    @BeforeAll
    public static void setup(){
        mockOutlet = new Outlet("Dummy Name", 76, 77);
        mockVehicle = new Scooty("MOCK Scooty", "MOCK REGISTRATION", mockOutlet);
    }

    @Test
    @DisplayName(" Test if parking space available ")
    public void test_validateIfParkingSpaceAvaiableInTheOutlet(){
        try {
            Assertions.assertTrue(mockOutlet.validateIfParkingSpaceAvaiableInTheOutlet());
        } catch (OutletFullException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
