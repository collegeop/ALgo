import java.util.Arrays;
import java.util.Scanner;

public class StableMatching {
    private static int N;
    public static boolean w_prefers_m1_Over_m(int prefers[][],int w,int m,int m1){
        for (int i=0;i<N;i++){
            if (prefers[w][i]==m1){
                return true;
            }
            if (prefers[w][i]==m){
                return false;
            }
        }
        return false;
    }
    public static void stable(int prefers[][]){
       int wpartner[] = new int[N];
       boolean mfree[] = new boolean[N];
       int freecount =N;
       Arrays.fill(wpartner,-1);
       while(freecount>0){
           int m;
           for( m = 0; m< N;m++)
               if (!mfree[m]){
                   break;
               }
           for (int i=0 ;i<N&&mfree[m]==false;i++){
               int w = prefers[m][i];
               if (wpartner[w - N] == -1){
                   wpartner[w - N] = m;
                   mfree[m]= true;
                   freecount--;
               }
               else {
                   int m1 = wpartner[w-N];
                   if (w_prefers_m1_Over_m(prefers,w,m,m1)==false){
                       wpartner[w-N] = m;
                       mfree[m]= true;
                       mfree[m1]=false;
                   }

               }
           }
       }
        System.out.println("w  m ");
       for (int i = 0; i <N; i++){
           System.out.println(" ");
           System.out.println(i +N +    "   "+ wpartner[i]);
       }
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("num of w and m");
        N = s.nextInt();
        System.out.println("Enter the matrix where 0 - N-1 is the preference list for men and N - 2N-1 is the preference list of women");

        int prefer[][] = new int[][]{{7, 5, 6, 4},
                {4, 6, 7 ,8},
                {3 ,5 ,1, 0},
                {4, 5, 6, 7},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3}};
        stable(prefer);

    }
}
