package com.company;

import java.util.Scanner;

class Umova{
    double a, b;
    int c;

    Umova(double a1, double b1, int c1){
        a = a1;
        b = b1;
        c = c1;
    }

    double first(){
        return (c+Math.cos(b))/(Math.sqrt(b+a*(c*c)));
    }

    double second(int i, double x){
        return (i * i)/(i * Math.cos(x)-x*x);
    }

    double third( double n){
        return n-Math.sqrt(1+Math.pow(n, 3));
    }
}

class Main {

    public static void main(String [] args) throws java.io.IOException {
        Umova res = new Umova(0.245, 0.0498, 14);
        System.out.print("Введите число х: ");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        double y;
        if(x<0){
            y= res.first();
            System.out.println("y= "+ y);
        }
        else if(x>0){
            int i = 1;
            y = 0;
            while (i<=5){
                y= res.second(i, x);
                i++;
            }
            System.out.print("y= "+y);
        }
        else{
            y = 1;
            for (double n =2; n<=4; n= n+0.2){
                y=res.third(n);
            }
            System.out.println("y= "+y);
        }
    }
}
