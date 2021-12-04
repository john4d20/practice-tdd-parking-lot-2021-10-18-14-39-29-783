package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartboyparkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_car_given_super_smart_parking_boy_manage_two_parking_lots_both_available() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        Ticket ticket = superSmartParkingBoy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9,firstParkingLot.getAvailablePosition());
        assertEquals(10,secondParkingLot.getAvailablePosition());
    }

    @Test
    void should_park_to_first_parking_lot_when_park_car_given_super_smart_parking_boy_manage_two_parking_lots_second_lots_have_more_empty() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.park(new Car());


        //when
        Ticket ticket = superSmartParkingBoy.park(new Car());
        //then
        assertEquals(9,firstParkingLot.getAvailablePosition());
        assertEquals(9,secondParkingLot.getAvailablePosition());
    }

    @Test
    void should_return_right_car_when_fetch_car_given__super_smart_parking_boy_and_two_parked_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket = superSmartParkingBoy.park(car1);
        Ticket ticket2 = superSmartParkingBoy.park(car2);
        //when
        Car fectchedCar = superSmartParkingBoy.fetch(ticket);
        Car fectchedCar2 = superSmartParkingBoy.fetch(ticket2);

        //then

        assertEquals(car1,fectchedCar);
        assertEquals(car2,fectchedCar2);
    }

    @Test
    void should_return_error_message_when_fetch_car_given_super_smart_parking_boy_unrecognized_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SuperSmartParkingBoy SuperSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car();
        SuperSmartParkingBoy.park(car1);
        Ticket unrecognizedTicket = new Ticket();

        UnrecognizedParkingTicketException  unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () ->{
            SuperSmartParkingBoy.fetch(unrecognizedTicket);
        });
        assertEquals("Unrecognized parking ticket",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_return_error_message_when_fetch_car_given_super_smart_parking_boy_and_used_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Ticket ticket = superSmartParkingBoy.park(car1);
        Ticket usedTicket = ticket;
        superSmartParkingBoy.fetch(ticket);


        UnrecognizedParkingTicketException  unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () ->{
            superSmartParkingBoy.fetch(usedTicket);
        });
        assertEquals("Unrecognized parking ticket",unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_return_no_available_message_when_park_car_given_super_smart_boy_and_full_parking_lots() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot(0);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();



        NoAvailablePositionException noAvailablePosition = assertThrows(NoAvailablePositionException.class,() -> {
            superSmartParkingBoy.park(car);
        });
        assertEquals("No available position", noAvailablePosition.getMessage());
    }
}
