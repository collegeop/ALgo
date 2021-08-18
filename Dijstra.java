package com.company;
import java.util.*;
public class Dijstra {
    private static int V;
    public static int minDist(int []dis,boolean []sptSet){
        int min = Integer.MAX_VALUE;int minIndex = -1;
        for(int i=0;i<V;i++){
            if (!sptSet[i] &&dis[i]<=min){
                min = dis[i];
                minIndex = i;
            }

        }
        return minIndex;
    }

    public static void Dijkstra1(int[][] Graph,int src){
        boolean []sptSet = new boolean[V];
        int []dist = new int[V];
        for(int i = 0 ; i< V;i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for(int i = 0 ; i < V-1; i++){
            int u = minDist(dist,sptSet);
            sptSet[u] =  true;
            for(int v =0;v<V;v++){
                if (Graph[u][v]!=0&&!sptSet[v]&&dist[u]!=Integer.MAX_VALUE&&dist[u]+Graph[u][v]<dist[v]){
                    dist[v] = dist[u] + Graph[u][v];

                }
            }
        }
        printSolution(dist,V);

    }
    public static void printSolution(int []dist,int v){
        System.out.println("distance from source ");
        for(int i = 0; i <v ;i++){
            System.out.print(dist[i] + " ->");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("enter the number of V : ");
        V= s.nextInt();
        int [][] Graph = new int[V][V];
        System.out.println("enter the adjacency Matrix : ");
        for(int i = 0 ; i <V ;i++){
            for(int j=0;j<V;j++){
                Graph[i][j]= s.nextInt();
            }
        }
        long st = System.nanoTime();
        System.out.println("enter src : ");
        int src = s.nextInt();
         Dijkstra1(Graph,src);
         long end = System.nanoTime();
         long timeLapsed = end-st;
        System.out.println("time taken : " + timeLapsed +"ms");


    }
}
