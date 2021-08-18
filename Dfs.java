// Java program to print DFS
//mtraversal from a given given
// graph
import java.io.*;
import java.util.*;
import java.time.*;
// This class represents a
// directed graph using adjacency
// list representation
import java.io.*;
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class Dfs {
    private int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked") Dfs(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);// Add w to v's list.
        adj[w].add(v);
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }

    // Driver Code
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges");
        int v=sc.nextInt();
        int e=sc.nextInt()+1;
        Dfs g= new Dfs(v);
        System.out.println("Enter the edges");
        for(int i=0;i<e;i++)
            g.addEdge(sc.nextInt(), sc.nextInt());
        Instant start=Instant.now();
        System.out.println("Enter the starting vertex");
        g.DFS(sc.nextInt());
        Instant end=Instant.now();
        System.out.println("\nTime taken = "+Duration.between(start,end).toMillis()+" milliseconds\n");
    }
}
