import java.io.*;
import java.util.*;

public class Main {
	static int N,K,arr[],dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		dp = new int[N][K+1];		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if(i == 0&&j%arr[i]==0)
					dp[i][j]++;
				else if(i==0)
					continue;
				else if(j-arr[i]>-1)
					dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(dp[N-1][K]);
	}
}
