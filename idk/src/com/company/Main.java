package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int l1 []= new int[10];
        for (int i=0; i< l1.length; i++){
            l1[i]= random.nextInt(1000);
        }
        int l2 []= new int[5];
        for (int i=0; i< l2.length; i++){
            l2[i]= random.nextInt(1000);
        }
        int [] res = new int[l1.length+ l2.length];
        int counter =0;
        for (int i=0; i< l1.length; i++){
            res[i]=l1[i];
            counter++;
        }
        for (int i=0; i< l2.length; i++) {
            res[counter++] = l2[i];
        }
        System.out.println("Before: ");
        for (int i=0; i< res.length; i++) {
            System.out.print(res[i]+", ");
        }
        sortMerge(res);
        System.out.println("\nAfter: ");
        printArray(res);
    }
    private static void sortMerge(int [] input){
        if(input.length<2){
            return;
        }
        int middle = input.length/2;
        int [] left = new int[middle];
        int [] right = new int[input.length-middle];

        for(int i=0; i<middle; i++){
            left[i]=input[i];
        }
        for(int i=middle; i<input.length; i++){
            right[i-middle]=input[i];
        }
        sortMerge(left);
        sortMerge(right);

        Merge(input, left,right);
    }
    private static void Merge(int[]input, int[]left, int[]right ){
        int leftSize = left.length;
        int rightSize = right.length;
        int i=0, j=0, k=0;

        while (i<leftSize && j<rightSize){
            if(left[i]<=right[j]){
                input[k]=left[i];
                i++;
            }
            else {
                input[k]=right[j];
                j++;
            }
            k++;
        }
        while (i<leftSize){
            input[k]=left[i];
            i++;
            k++;
        }
        while (j<rightSize){
            input[k]=right[j];
            j++;
            k++;
        }
    }
    private static void printArray(int[] res){
        for (int i=0; i< res.length; i++){
            System.out.print(res[i]+", ");
        }
    }
}
