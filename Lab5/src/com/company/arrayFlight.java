package com.company;

public class arrayFlight {
    private Flight[] arrFlight;
    private Flight[] arrFin;
    private int Elements;
    private String City;
    private String Data;
    private double Time;


    public arrayFlight(int max, String City, String Data, double Time) {
        arrFlight = new Flight[max];
        Elements = 0;
        arrFin = new Flight[max];
        this.City=City;
        this.Data=Data;
        this.Time=Time;
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
    public void Find(String c, String d, double t){
        boolean f1 =false;
        boolean f12 = true;
        int numFin =0;
        String City = c;
        String Data = d;
        double Time = t;
        if(City.charAt(0)!=" ".charAt(0)&Data.charAt(0)!=" ".charAt(0)&Time!=0){
            f12 =false;
        }
        System.out.println("Знайти місто -"+ City);
        System.out.println("Знайти дату -"+Data);
        System.out.println("Знайти час -"+Time+"\n\n");
        try {
            for (int i=0; i<arrFlight.length; i++){
                f1=false;
                if ((arrFlight[i].getCity().equals(City))==true&(arrFlight[i].getData().equals(Data))==true){
                    System.out.println(arrFlight[i].getCity()+" "+arrFlight[i].getData()+" "+arrFlight[i].getTime());
                    arrFin[numFin]=arrFlight[i];
                    numFin++;
                    f1=true;
                }
                else if ((City.charAt(0)!=" ".charAt(0)&f1!=true)&f12){
                    if(arrFlight[i].getCity().equals(City)){
                        System.out.println(arrFlight[i].getCity()+" "+arrFlight[i].getData()+" "+arrFlight[i].getTime());
                        arrFin[numFin]=arrFlight[i];
                        numFin++;
                    }
                }
                if ((Data.charAt(0)!=" ".charAt(0)&f1!=true)&f12){
                    if(arrFlight[i].getData().equals(Data)){
                        System.out.println(arrFlight[i].getCity()+" "+arrFlight[i].getData()+" "+arrFlight[i].getTime());
                        arrFin[numFin]=arrFlight[i];
                        numFin++;
                    }
                }
            }
        }catch (Exception e){
        }
    }
    public void DispFind(){
        for (Flight i: arrFin){
            if (i==null){
                break;
            }
            else System.out.println(i);
        }
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
