package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private final String NO_AVAILABLE_POSITION = "No available position";
    private final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket";
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
        throw new NoAvailablePositionException(NO_AVAILABLE_POSITION);
    }


    private boolean hasAvailablePosition(){
        return ticketCarHashMap.size() < capacity;
    }

    public Car fetch(Ticket ticket) {
        if (ticketCarHashMap.containsKey(ticket)){
            return ticketCarHashMap.remove(ticket);

        }
        throw new UnrecognizedParkingTicketException(UNRECOGNIZED_PARKING_TICKET);
    }

    public int getAvailablePosition() {
        return capacity - ticketCarHashMap.size();
    }

    public int getCapacity() {
        return capacity;
    }
}
