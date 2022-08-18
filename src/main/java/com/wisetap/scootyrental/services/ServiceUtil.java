package com.wisetap.scootyrental.services;

import java.util.List;

import com.wisetap.scootyrental.entities.Outlet;
import com.wisetap.scootyrental.entities.User;

public class ServiceUtil {
    public static void sortOutlets(List<Outlet> outlets, User user) {
        outlets.sort((outlet1, outlet2) -> {
            Double diff = outlet1.getDistanceFromUser(user) - outlet2.getDistanceFromUser(user);
            return diff.intValue();
        });
    }
}
