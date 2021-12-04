package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car)  {
        ParkingLot largerAvailablePositionRateParkingLot = this.getParkingLots().stream().min(
                Comparator.comparing(lot -> lot.getAvailablePosition() / lot.getCapacity())).orElse(null);
        if (largerAvailablePositionRateParkingLot != null) {
            return largerAvailablePositionRateParkingLot.park(car);
        }
        return null;
    }
}
