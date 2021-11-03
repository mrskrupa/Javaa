package com.company;

import java.util.Random;

public class Main {

    private static void printArray(int[]l1){
        for (int i=0; i< l1.length; i++){
            System.out.print(l1[i]+" ");
        }
    }
    public static void main (String [] args){
        Random random = new Random();
        int [] l1 = new int[10];
        for(int i=0; i< l1.length; i++){
            l1[i] = random.nextInt(100);
        }
        System.out.println("Before: ");
        printArray(l1);

        mergeSort(l1);

        System.out.println("\nAfter: ");
        printArray(l1);
    }
    private static void mergeSort(int[]l1){
        int current = l1.length;
        if(current<2){
            return;
        }
        int middle = current/2;

        int [] left = new int[middle];
        int [] right = new int[current-middle];

        for (int i=0; i<middle; i++){
            left[i]=l1[i];
        }
        for (int i=middle; i<current; i++){
            right[i-middle]=l1[i];
        }
        mergeSort(left);
        mergeSort(right);
        Merge(l1, left, right);
    }
    private static void Merge (int [] l1, int [] left, int [] right){
        int i=0, j=0, k=0;
        int leftSize = left.length;
        int rightSize = right.length;

        while (i<leftSize && j<rightSize){
            if(left[i]<=right[j]) {
                l1[k] = left[i];
                i++;
            }
            else {
                l1[k]=right[j];
                j++;
            }
            k++;
        }
        while (i<leftSize){
            l1[k]=left[i];
            i++;
            k++;
        }
        while (j<rightSize){
            l1[k]=right[j];
            j++;
            k++;
        }
    }
}
