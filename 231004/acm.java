import java.io.*;
import java.util.*;


public class Main {
    static int N,K,W,D[];
    static long dp[];
    static boolean adj[][];
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //T 번 반복
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            D = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                D[j] = Integer.parseInt(st.nextToken());
            }
            adj = new boolean[N+1][N+1];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from][to] = true;
            }
            W = Integer.parseInt(br.readLine());
            dp = new long[N+1];
            Arrays.fill(dp,-1);
            System.out.println(recur(W));
        }
    }
    private static long recur(int w) {
        long max = 0;
        if(dp[w]!= -1) return dp[w];
        for (int i = 1; i <= N; i++) {
            if(!adj[i][w]) continue;
            max = Math.max(max, recur(i));
        }
        return dp[w] = max + D[w];
    }
}
