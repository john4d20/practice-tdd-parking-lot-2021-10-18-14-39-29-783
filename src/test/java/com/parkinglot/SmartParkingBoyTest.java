package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_car_given_smart_parking_boy_manage_two_parking_lots_both_available() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        Ticket ticket = smartParkingBoy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9,firstParkingLot.getAvailablePosition());
        assertEquals(10,secondParkingLot.getAvailablePosition());
    }

    @Test
    void should_park_to_first_parking_lot_when_park_car_given_smart_parking_boy_manage_two_parking_lots_second_lots_have_more_empty() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        Ticket ticket = smartParkingBoy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(1,firstParkingLot.getAvailablePosition());
        assertEquals(1,secondParkingLot.getAvailablePosition());
    }
}
