package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_right_car_when_fetch_car_given_smart_parking_boy_and_two_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket = smartParkingBoy.park(car1);
        Ticket ticket2 = smartParkingBoy.park(car2);
        //when
        Car fectchedCar = smartParkingBoy.fetch(ticket);
        Car fectchedCar2 = smartParkingBoy.fetch(ticket2);

        //then

        assertEquals(car1,fectchedCar);
        assertEquals(car2,fectchedCar2);
    }


    @Test
    void should_return_error_message_when_fetch_car_given_smart_parking_boy_unrecognized_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        smartParkingBoy.park(car1);
        Ticket unrecognizedTicket = new Ticket();

        UnrecognizedParkingTicketException  unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () ->{
            smartParkingBoy.fetch(unrecognizedTicket);
        });
        assertEquals("Unrecognized parking ticket",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_smart_parking_boy_and_used_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Ticket ticket = smartParkingBoy.park(car1);
        Ticket usedTicket = ticket;
        smartParkingBoy.fetch(ticket);


        UnrecognizedParkingTicketException  unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () ->{
            smartParkingBoy.fetch(usedTicket);
        });
        assertEquals("Unrecognized parking ticket",unrecognizedParkingTicketException.getMessage());
    }
}
