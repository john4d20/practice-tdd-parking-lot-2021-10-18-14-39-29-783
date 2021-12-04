package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    private final String NO_AVAILABLE_POSITION = "No available position";
    private final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket";

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NoAvailablePositionException{
        for (ParkingLot parkingLot: parkingLots) {
            try {
                return parkingLot.park(car);
            }
            catch (NoAvailablePositionException ignored) {

            }
        }
        throw new NoAvailablePositionException(NO_AVAILABLE_POSITION);

    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        for (ParkingLot parkingLot: parkingLots) {
            try {
                return parkingLot.fetch(ticket);
            }
            catch (UnrecognizedParkingTicketException ignored) {

            }
        }
        throw new UnrecognizedParkingTicketException(UNRECOGNIZED_PARKING_TICKET);
    }
}
