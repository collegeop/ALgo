// A Dynamic Programming based solution
// for 0-1 Knapsack problem
import java.util.*;
class Knapsack {

    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
        return (a > b) ? a : b;

    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[],
                        int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        i=n;
        int k=W;
        System.out.println("Items in the knapsack: ");
        while(i>0 && k > 0){
            if(K[i][k] != K[i-1][k]){
                System.out.print(i+" ");
                i=i-1;
                k=k-wt[i];
            }else
                i=i-1;
        }
        return K[n][W];
    }

    // Driver code
    public static void main(String args[])
    {
        System.out.println("Enter the number of items: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("Enter the value,weight of each item: ");
        int[] val = new int[n];
        int[] wt = new int[n];
        for(int i=0;i<n;i++){
            val[i] = scan.nextInt();
            wt[i] =  scan.nextInt();
        }
        System.out.println("Enter the max weight of items: ");
        int W = scan.nextInt();
        long start = System.currentTimeMillis();
        System.out.println("\nMax value: "+knapSack(W, wt, val, n));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Time Elapsed: "+timeElapsed+"ms");
    }
}
/*This code is contributed by Rajat Mishra */

