package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_right_car_when_fetch_car_given_two_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car fectchedCar = parkingBoy.fetch(ticket);
        Car fectchedCar2 = parkingBoy.fetch(ticket2);

        //then

        assertEquals(car1,fectchedCar);
        assertEquals(car2,fectchedCar2);
    }

    @Test
    void should_return_error_message_when_fetch_car_given_unrecognized_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        parkingBoy.park(car1);
        Ticket unrecognizedTicket = new Ticket();

        UnrecognizedParkingTicketException  unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () ->{
            parkingBoy.fetch(unrecognizedTicket);
        });
        assertEquals("Unrecognized parking ticket",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_used_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Ticket ticket = parkingBoy.park(car1);
        Ticket usedTicket = ticket;
        parkingBoy.fetch(ticket);


        UnrecognizedParkingTicketException  unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () ->{
            parkingBoy.fetch(usedTicket);
        });
        assertEquals("Unrecognized parking ticket",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_return_no_available_message_when_park_car_given_full_parking_lots() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot(0);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();



        UnrecognizedParkingTicketException  unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () ->{
            parkingBoy.park(car);
        });
        assertEquals("No available position",unrecognizedParkingTicketException.getMessage());
    }

}
