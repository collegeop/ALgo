package Bfs;

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BFSC
{
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    BFSC(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges");
        int v=sc.nextInt();
        int e=sc.nextInt();
        System.out.println("Enter the edges");

        BFSC g = new BFSC(v+1);
        for(int i=0;i<e;i++)
            g.addEdge(sc.nextInt(),sc.nextInt());
        long start=System.currentTimeMillis();
        System.out.println("Enter the starting vertex");
        g.BFS(sc.nextInt());
        long end=System.currentTimeMillis();
        System.out.println("\nTime taken = "+(start-end)+" milliseconds\n");
    }
}
