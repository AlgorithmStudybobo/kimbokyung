import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][],  dp[][];
	static int[] dx = {0,1, 0,-1};
	static int[] dy = {1,0,-1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N]; dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i],N*N);
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		dp[0][0] = 0;
		dfs(0,0,0);
		System.out.println(dp[N-1][N-1]);
	}
	private static void dfs(int a, int b, int cnt) {
		for (int d = 0; d < 4; d++) {
			int x = dx[d] + a;
			int y = dy[d] + b;
			
			if(x<0||y<0||x>=N||y>=N) continue;
			if(arr[x][y]==1) {
				if(dp[x][y]>cnt) {
					dp[x][y] = cnt;
					dfs(x,y,cnt);
				}
				else continue;
			}
			else {
				if(dp[x][y]>cnt+1) {
					dp[x][y] = cnt+1;
					dfs(x,y,cnt+1);
				}
				else continue;
			}
		}
	}
}
