package com.company;

public class arrayFlight {
    private Flight[] arrFlight;
    private int Elements;

    public arrayFlight(int max) {
        arrFlight = new Flight[max];
        Elements = 0;
    }

    public void Insert(String c, int num, String typ, double t, String d) {
        if (Elements < arrFlight.length) {
            arrFlight[Elements] = new Flight();
            arrFlight[Elements].setCity(c);
            arrFlight[Elements].setNumber(num);
            arrFlight[Elements].setTypOfAirplane(typ);
            arrFlight[Elements].setTime(t);
            arrFlight[Elements].setData(d);
        } else
            System.out.println("Масив повністю заповнено");
        Elements++;
    }
    public void Display(){
        for(int i=0; i<Elements; i++){
            System.out.println("Місто прильоту: "+arrFlight[i].getCity());
            System.out.println("Номер рейсу: "+arrFlight[i].getNumber());
            System.out.println("Тип літака: "+arrFlight[i].getTypOfAirplane());
            System.out.println("Час вильоту: "+arrFlight[i].getTime());
            System.out.println("Дата вильоту: "+arrFlight[i].getData());
            System.out.println();
        }
    }
}
