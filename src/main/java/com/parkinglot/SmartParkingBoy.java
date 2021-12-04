package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy{
    private final String NO_AVAILABLE_POSITION = "No available position";
    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car)  throws NoAvailablePositionException{
        ParkingLot emptyParkingLot = this.getParkingLots().stream().max(
                Comparator.comparing(ParkingLot::getAvailablePosition)).orElse(null);
        if (emptyParkingLot != null) {
            return emptyParkingLot.park(car);
        }
        throw new NoAvailablePositionException(NO_AVAILABLE_POSITION);
    }

}
