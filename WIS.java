package com.company;

import java.util.*;

class Job{
    int st,ft,profit;

    public Job(int st, int ft, int profit) {
        this.st = st;
        this.ft = ft;
        this.profit = profit;
    }
}
class jobcompare implements Comparator<Job>{
    public int compare(Job j1,Job j2){
        return j1.ft-j2.ft;
    }
}

 class WIS{
      public static int lastnotConflict(Job a[],int i){
          for (int j = i-1;j>=0;j--){
              if (a[j].ft<=a[i-1].st){
                  return j;
              }
          }
          return -1;
      }
      static int findMaxProfitRec(Job[] a, int n){
        if (n==1)
            return a[n-1].profit;

          int inclprofit = a[n-1].profit;

          int i =lastnotConflict(a,n);
        if (i!=-1){
            inclprofit +=findMaxProfitRec(a,i+1);
        }
            int excuProfit = findMaxProfitRec(a,n-1);




          return Math.max(inclprofit,excuProfit);
      }
      static  int findMaxProfit(Job a[],int n){
          Arrays.sort(a,new jobcompare());
          return findMaxProfitRec(a,n);
      }
    public static void main(String[] args) {
        Job jobs [] = new Job[]{
                new Job(1,2,100),
                new Job(2,5,200),
                new Job(3,6,300),
                new Job(4,8,400),
                new Job(5,9,500),
                new Job(6,10,100),

        };
        System.out.println("max profit : " + findMaxProfit(jobs,jobs.length));
    }
}
