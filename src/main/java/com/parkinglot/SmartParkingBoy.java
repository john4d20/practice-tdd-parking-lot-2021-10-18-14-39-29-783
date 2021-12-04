package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car)  {
        ParkingLot emptyParkingLot = this.getParkingLots().stream().max(
                Comparator.comparing(ParkingLot::getAvailablePosition)).orElse(null);
        if (emptyParkingLot != null) {
            return emptyParkingLot.park(car);
        }
        return null;
    }

}
