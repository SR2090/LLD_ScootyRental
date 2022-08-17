package com.wisetap.scootyrental.entities;

import java.util.Vector;

public class User {
    // username
    private String userName; 

    // location coordinates
    private Integer XCoordinate;
    private Integer YCoordinate;

    // vehicle associated with the user if they book otherwise this is null
    private Vehicle vehicle;

    public User(String userName, Integer XCoordinate, Integer YCoordinate) {
        this.userName = userName;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        this.vehicle = null;
    }

    // Assign vehicle to user 
    public void vehicleBookedByUser(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // set by location services from the front end
    public Integer setXCoordinate(Integer latitude) {
        return this.XCoordinate = latitude;
    }
    // set by location service from the front end
    public Integer setYCoordinate(Integer YCoordinate) {
        return this.YCoordinate = YCoordinate;
    }

    public Integer getXCoordinate() {
        return XCoordinate;
    }

    public Integer getYCoordinate() {
        return YCoordinate;
    }

    public String getUserName() {
        return userName;
    }
}
