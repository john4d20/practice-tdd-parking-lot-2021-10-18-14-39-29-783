package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    int capacity;
    private final int DEFAULT_CAPACITY = 10;
    HashMap<Ticket,Car> ticketCarHashMap = new HashMap<>();
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public Ticket park(Car car){
        if (hasAvailablePosition()){
            Ticket ticket = new Ticket();
            ticketCarHashMap.put(ticket,car);

            return ticket;
        }
     return null;
    }

    private boolean hasAvailablePosition(){
        return ticketCarHashMap.size() < capacity;
    }

    public Car fetch(Ticket ticket) {
        if (ticketCarHashMap.containsKey(ticket)){
            Car car = ticketCarHashMap.get(ticket);
            ticketCarHashMap.remove(ticket);
            return car;
        }
        return null;
    }
}
