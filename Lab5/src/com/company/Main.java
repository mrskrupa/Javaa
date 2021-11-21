package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String c, d;
        double t;
        arrayFlight arrFin;
        while (true){
            System.out.println("Введіть місто: ");
            c = in.nextLine();
            if(c.isEmpty()){
                System.out.println("Ви не вказали місто");
            }
            else {
                break;
            }
        }
        while (true){
            System.out.println("Введіть дату: ");
            d = in.nextLine();
            if(d.isEmpty()){
                System.out.println("Ви не вказали дату");
            }
            else {
                break;
            }
        }
        while (true){
            System.out.println("Введіть час: ");
            t = in.nextFloat();
            if(t<=0){
                System.out.println("Ви не вказали час");
            }
            else {
                break;
            }
        }
        arrayFlight arFlight = new arrayFlight(6, c, d, t);

        arFlight.Insert("Amsterdam", 4003, "Boing 747", 12.35, "10.11.21");
        arFlight.Insert("London", 4115, "Boing 007", 17.15, "17.12.21");
        arFlight.Insert("Rum", 5614, "Boing 535", 04.15, "30.12.21");
        arFlight.Display();
        arFlight.Find(c, d, t);
        arFlight.DispFind();
    }
}