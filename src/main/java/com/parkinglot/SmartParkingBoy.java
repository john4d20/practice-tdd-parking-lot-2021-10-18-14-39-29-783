package com.parkinglot;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }
//
//    @Override
//    public Ticket park(Car car)  {
//        ParkingLot emptyParkingLot = this.getParkingLots().stream().max(
//                Comparator.comparing(ParkingLot::getNumEmptyPositions)).orElse(null);

}
