package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }
    
    @Test
    void should_return_null_when_park_car_given_full_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_car_given_parking_lot_and_car_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //when
        Car fetchedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(car,fetchedCar);
    }

}
