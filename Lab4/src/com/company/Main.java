package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int mass[] = {6, 3, 7, 3, 7, 2, 8, 5, 9, 3};
        int size = 10;
        for (int i = 0; i < size; i++)
            System.out.println("Индес массива: " + i + "\t" + mass[i]);

        System.out.print("Введите число: ");
        int x, rep = 0;
        char ignore;

        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        for (int i = 0; i < size; i++) {
            if (mass[i] == x) {
                rep++;
            }
        }
        System.out.println("Количество повторов числа " + x + " в массиве: " + rep);
    }
}
