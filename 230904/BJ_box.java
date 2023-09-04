import java.io.*;
import java.util.*;

public class Main {
	static int N,boxs[],dp[],max,bsize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boxs = new int[N+1];
		dp = new int[N+1];
		boxs[1] = Integer.parseInt(st.nextToken());
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			boxs[i] = Integer.parseInt(st.nextToken());
			int m = 0 ;
			for (int j = 0; j < i; j++) {// 나의 이전 입력이면서 작은상자 중 큰 값 찾아서
				if(boxs[i]>boxs[j]) {
					m = Math.max(m, dp[j]);
				}
			}
			
			dp[i] = m + 1;  // 상자 추가 해서 저장~!
			
		}
		for (int i = 0; i <= N; i++) { //가장 큰 값 찾기
      // max = Arrays.stream(dp).max().getAsInt(); 다음엔 이거 한줄로 쓰기~!@
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
