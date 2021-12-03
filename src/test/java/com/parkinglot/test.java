package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class test {
//    case1
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
//    case2
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
//case3
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
//    case4
    @Test
    void should_return_right_car_with_each_ticket_when_fetch_car_given_two_cars_and_two_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Car car2 = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket ticket2 = parkingLot.park(car2);
        //when
        Car fetchedCar = parkingLot.fetch(ticket);
        Car fetchedCar2 = parkingLot.fetch(ticket2);
        //then
        assertEquals(car, fetchedCar);
        assertEquals(car2, fetchedCar2);
    }
//        case5
    @Test
    void should_return_null_when_fetch_car_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket wrongTicket = new Ticket();
        //when
        Car fetchedCar = parkingLot.fetch(wrongTicket);

        //then
        assertNull(fetchedCar);
    }
////    case6
//    @Test
//    void should_return_null_when_fetch_car_given_used_ticket() {
//        //given
//
//        //when
//
//        //then
//    }



}



