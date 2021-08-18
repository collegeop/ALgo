package com.company;

import java.util.Scanner;

class MergeSort{
   static int aux_array[];
    MergeSort(int u){
        aux_array = new int[u];
    }
    public static void mergeSort(int a[],int low ,int high){
        int mid;
        if (low<high){
            mid = (low+high)/2;
                mergeSort(a,low,mid);
                mergeSort(a,mid+1,high);
                merge(a,low,mid,high);
        }


    }
    public static void merge(int a[],int low,int mid,int high){
      int leftIndex = low;
      int rightIndex =mid+1;
      int auxIndex = low;
      while (leftIndex<=mid&&rightIndex<=high){
          if (a[leftIndex]<=a[rightIndex]){
              aux_array[auxIndex++]=a[leftIndex++];
          }else {
              aux_array[auxIndex++] = a[rightIndex++];
          }

      }
    if (leftIndex<=mid){
        for(int i = leftIndex ;i<=mid ;i++){
            aux_array[auxIndex++]=a[i];
        }

    }else {
        for(int i = rightIndex;i<=high;i++){
            aux_array[auxIndex++]=a[i];
        }
    }
    for (int i=low;i<=high;i++){
        a[i] = aux_array[i];

    }

    }
    public static void printA(int a[],int size){
        for (int i = 0;i<size;i++){
            System.out.print(a[i] +" ");
        }
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("enter size : ");
        int size = s.nextInt();
        int n[]= new int[size];
        System.out.println("enter array elements: ");
        for(int i = 0 ;i <size;i++){
            n[i] = s.nextInt();
        }
        MergeSort s1 = new MergeSort(n.length);
        System.out.println("sorted : ");
        mergeSort(n,0,n.length-1);
        printA(n,size);

    }
}
