package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();


        Ticket ticket = parkingLot.park(car);

        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_park_car_given_full_parking_lot_and_car() {

        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();

        Ticket ticket = parkingLot.park(car);

        assertNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_car_given_parking_lot_and_car_and_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        Car fetchedCar = parkingLot.fetch(ticket);

        assertEquals(car,fetchedCar);
    }

    @Test
    void should_return_right_car_with_each_ticket_when_fetch_car_given_two_cars_and_two_tickets() {

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Car car2 = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket ticket2 = parkingLot.park(car2);

        Car fetchedCar = parkingLot.fetch(ticket);
        Car fetchedCar2 = parkingLot.fetch(ticket2);

        assertEquals(car, fetchedCar);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_return_null_when_fetch_car_given_wrong_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        parkingLot.park(car);
        Ticket wrongTicket = new Ticket();

        Car fetchedCar = parkingLot.fetch(wrongTicket);


        assertNull(fetchedCar);
    }

    @Test
    void should_return_null_when_fetch_car_given_used_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        Ticket usedTicket = ticket;

        Car Car = parkingLot.fetch(usedTicket);

        assertNull(Car);
    }



}



