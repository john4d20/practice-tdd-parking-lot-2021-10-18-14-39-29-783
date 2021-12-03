package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PakingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_car_given_parking_boy_manage_two_parking_lots_bot_available() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        Ticket ticket = parkingBoy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9,firstParkingLot.getAvailablePosition());
        assertEquals(10,secondParkingLot.getAvailablePosition());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_car_given_full_first_parking_lot_and_second_parking_lot() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        Ticket ticket = parkingBoy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(0,firstParkingLot.getAvailablePosition());
        assertEquals(9,secondParkingLot.getAvailablePosition());
    }

}
