package com.company;

public class Flight {
    private String City; // Місто прибуття
    private int Number; //Номер рейсу
    private String TypOfAirplane; //Тип літаку
    private double Time; //Час вильоту
    private String Data; //Дата вильоту (00.00.00)
    private boolean flag = false; //Позначка перевірки

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        switch (City) {
            case "Amsterdam":
            case "London":
            case "Rum":
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        if (!flag) {
            System.out.println(City + " Таке місто відсутнє");
        }
        this.City = City;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        switch (Number) {
            case 4003:
            case 4115:
            case 5614:
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        if (!flag) {
            System.out.println(Number + " Такий рейс відсутній");
        }
        this.Number = Number;
    }

    public String getTypOfAirplane() {
        return TypOfAirplane;
    }

    public void setTypOfAirplane(String TypOfAirplane) {
        switch (TypOfAirplane) {
            case "Boing 747":
            case "Boing 007":
            case "Boing 535":
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        if (!flag) {
            System.out.println(City + " Такий літак відсутній");
        }
        this.TypOfAirplane = TypOfAirplane;
    }

    public double getTime() {
        return Time;
    }

    public void setTime(double Time) {
        if (Time == 12.35 || Time == 17.15 || Time == 04.15) {
            flag = true;
        } else {
            flag = false;
        }
        if (!flag) {
            System.out.println(Time + " Такий час відсутній");
        }
        this.Time = Time;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        switch (Data) {
            case "10.11.21":
            case "17.12.21":
            case "30.12.21":
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        if (!flag) {
            System.out.println(Data + " Така дата відсутня");
        }
        this.Data = Data;
    }
}
