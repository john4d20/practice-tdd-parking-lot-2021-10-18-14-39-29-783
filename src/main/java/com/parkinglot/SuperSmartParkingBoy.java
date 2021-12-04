package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy{
    private final String NO_AVAILABLE_POSITION = "No available position";
    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car)  throws NoAvailablePositionException{
        try {
            ParkingLot largerAvailablePositionRateParkingLot = this.getParkingLots().stream().max(
                    Comparator.comparing(ParkingLot->(ParkingLot.getAvailablePosition()/ParkingLot.getCapacity()))).orElse(null);
            if (largerAvailablePositionRateParkingLot != null) {
                return largerAvailablePositionRateParkingLot.park(car);
            }
        }
        catch(ArithmeticException ignored){

        }
        throw new NoAvailablePositionException(NO_AVAILABLE_POSITION);
    }
}
