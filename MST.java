package com.company;

import java.util.Scanner;

class MST {
     public static int V;
     public static int minkey(int []key,boolean[]mstSet){
         int min = Integer.MAX_VALUE;int minIndex = -1;
         for(int i=0 ; i < V;i++){
             if (!mstSet[i]&&key[i]<=min){
                 min = key[i];
                 minIndex=i;
             }
         }
         return minIndex;
     }
     public static void Prim(int [][]graph,int src){
         boolean[] mstSet = new boolean[V];
         int []parents =new int[V];
         int[] key = new int[V];
         for(int i =0 ; i < V; i++){
             key[i]=Integer.MAX_VALUE;
             mstSet[i]=false;
         }
         key[src]= 0;
         parents[src]=-1;
         for(int i = 0 ; i < V-1;i++){
             int u = minkey(key,mstSet);
             mstSet[u] = true;
             for(int v = 0 ; v< V;v++){
                 if(graph[u][v]!=0&&!mstSet[v]&&graph[u][v]<key[v]&&graph[u][v]!=Integer.MAX_VALUE){
                     key[v] = graph[u][v];
                     parents[v] = u;
                 }
             }


         }
         printSolutaion(parents,graph);
     }

     private static void printSolutaion(int[] parents, int [][]graph) {
         System.out.println("edge\t\t weight : ");
         for (int i = 1; i < V; i++) {
             System.out.println(parents[i] +  " -  " + graph[i][parents[i]]);

         }
     }

     public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         System.out.println("enter the number of V");
         V=  s.nextInt();
         int [][]g= new int[V][V];
         System.out.println("enter edjacney matrix : ");
         for(int i =0 ; i<V;i++){
             for(int j = 0 ;j<V; j++){
                 g[i][j] = s.nextInt();
             }
         }
         Prim(g,0);

     }
}
