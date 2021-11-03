package com.company;

public class Main {

    public static void main(String[] args) {
        arrayFlight arFlight = new arrayFlight(6);

        arFlight.Insert("Amsterdam", 4003, "Boing 747", 12.35, "10.11.21");
        arFlight.Insert("London", 4115, "Boing 007", 17.15, "17.12.21");
        arFlight.Insert("Rum", 5614, "Boing 535", 04.15, "30.12.21");
        arFlight.Display();
    }
}