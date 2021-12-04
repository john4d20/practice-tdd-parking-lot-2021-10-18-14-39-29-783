package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car)  {
        ParkingLot largerAvailablePositionRateParkingLot = this.getParkingLots().stream().max(
                Comparator.comparing(ParkingLot->(ParkingLot.getAvailablePosition()/ParkingLot.getCapacity()))).orElse(null);
        if (largerAvailablePositionRateParkingLot != null) {
            return largerAvailablePositionRateParkingLot.park(car);
        }
        return null;
    }
}
