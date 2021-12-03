package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    int capacity;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {

    }

    public Ticket park(Car car){
        HashMap<Ticket,Car> ticketCarHashMap = new HashMap<>();
        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket,car);

        return ticket;

    }
}
