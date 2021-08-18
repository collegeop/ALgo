package com.company;
import java.time.*;
import java.util.*;

class Quicksort{
    public void Swap(int a[],int i, int j){
        int temp = a[i];
        a[i]= a[j];
        a[j]=temp;
    }
    public void quickSort(int a[],int begin,int end){
        if(begin<end){
            int pi = partition(a,begin,end);
            quickSort(a,begin,pi-1);
            quickSort(a,pi+1,end);
        }
    }
    public int partition(int a[],int begin,int end){
        int pviot = a[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if(a[j]<pviot){
                i++;
                Swap(a,i,j);
            }
        }
        Swap(a,i+1,end);
        return (i+1);
    }
}
 class Main {
    public static void printarray(int a[],int size){
        for (int i = 0; i <size ; i++) {
            System.out.println();
            System.out.println(a[i] + " ");

        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the number of array : ");
        int n = s.nextInt();
        int[] a = new int[n];
        Quicksort s1 = new Quicksort();
        System.out.println("enter elements of array : ");
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("unsorted : ");
        printarray(a,n);
        long start  =System.nanoTime();
        s1.quickSort(a,0,n-1);
        long end = System.nanoTime();
        System.out.println("duration   : " + (end - start) +"ns");
        System.out.println("sorted  : ");
        printarray(a,n);



    }
}
