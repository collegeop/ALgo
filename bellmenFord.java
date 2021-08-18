package com.company;//package com.company;
import java.util.*;
  class Graph{
      private int V;
      private int E;
      class Edge{
          int src,dest,w;

          Edge(){
              src=dest=w=0;
          }
      }
      Edge[] Ed;
      Graph(int v,int e){
          V = v;
          E = e;
          Ed = new Edge[e];
          for(int i = 0 ; i < e;i++){
              Ed[i] = new Edge();
          }

      }
      public void belmen(Graph g , int src){
          int V = g.V;int E = g.E;
          int []dis = new int[E];
          for(int i = 0 ; i<V; i++){
              dis[i]=Integer.MAX_VALUE;
          }
          dis[src]=0;
          for(int i =1; i<V;i++){
              for(int j = 0 ; j <E ;j++){
                  int u  = g.Ed[j].src;
                  int v = g.Ed[j].dest;
                  int w = g.Ed[j].w;
                  if(dis[u]!=Integer.MAX_VALUE && dis[u]+w<dis[v]){
                      dis[v] = dis[u] + w;
                  }
              }
          }
          for(int i = 0 ;i<E ; i++){
              int u  = g.Ed[i].src;
              int v = g.Ed[i].dest;
              int w = g.Ed[i].w;
              if(dis[u]!=Integer.MAX_VALUE && dis[u]+w<dis[v]){
                  System.out.println("no negtive edge : ");
                  return;
              }
          }
          printA(dis,V);
      }
      public void printA(int []dis,int v){
          System.out.println("distance from source  : ");

          for(int i =0;i<v;i++){
              System.out.println(dis[i] + " ");

          }
          System.out.println();
      }
  }
  class bellmnnFord{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("enter Num of vertex : ");
        int V = s.nextInt();
        System.out.println("enter Num of edges : ");
        int E = s.nextInt();
        Graph gr = new Graph(V,E);
        System.out.println("enter src , dest , weight of each edge : ");
        for(int i =0;i<E;i++){
            System.out.println("enter edge of : " + i);
            gr.Ed[i].src = s.nextInt();
            gr.Ed[i].dest = s.nextInt();
            gr.Ed[i].w = s.nextInt();
        }
        long st = System.currentTimeMillis();
        gr.belmen(gr,0);
        long en = System.currentTimeMillis();
        System.out.println("time is   : " + (en - st));


    }
}
