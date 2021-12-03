package com.parkinglot;

public class NoAvailablePosition extends RuntimeException{
    public NoAvailablePosition(String message){
        super(message);
    }
}
