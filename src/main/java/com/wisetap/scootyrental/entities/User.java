package com.wisetap.scootyrental.entities;


public class User {
    // username
    private String userName; 

    // location coordinates
    private Integer XCoordinate;
    private Integer YCoordinate;

    public User(String userName, Integer XCoordinate, Integer YCoordinate) {
        this.userName = userName;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
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

    public String getdetails() {
        return userName + " " + "XCoordinate " + XCoordinate + "YCoordinate " + YCoordinate;
    }
}
