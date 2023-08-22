import java.io.*;
import java.util.StringTokenizer;

public class BJ_12101 {
	static int N,K;
	static String[] str;
	static int[] cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		str = new String[N+1];
		cnt = new int[N+1];
		maxCnt();        // N에 대하여 나올 수 있는 최대 경우의 수 저장.
		if(K>cnt[N]) {   // 경우의 수가 K보다 작으면 return -1.
			System.out.println(-1); return;
		}
		recursive(N);	   // 결과 출력하는 재귀
		System.out.println(sb);
	}
	private static void maxCnt() { // 수의 규칙
		for (int i = 1; i < str.length; i++) {
			if(i == 1) cnt[1] = 1;
			else if(i == 2) cnt[2] = 2;
			else if(i == 3) cnt[3] = 4;
			else cnt[i] = cnt[i-1] + cnt[i-2] + cnt[i-3];
		}
	}
	private static void recursive(int n) {
		if(n==1&&K==1) 
				sb.append("1");
		else if(n==2&&K==2) 
				sb.append("2");
		else if(n==3&&K==4) 
				sb.append("3");
		else if(K<=cnt[n-1]) {
			sb.append("1+");
			recursive(n-1);
		}
		else if(K<=cnt[n-1]+cnt[n-2]) {
			sb.append("2+");
			K -= cnt[n-1];
			recursive(n-2);
		}else {
			sb.append("3+");
			K -= cnt[n-1] + cnt[n-2];
			recursive(n-3);
		}
	}

}
/*???  2 2
1
1    1 (1)

2
1 1
2    2 (1 1)

3
1 1 1
1 2
2 1
3    4 (2 1 1)

4
1 1 1 1
1 1 2
1 2 1
1 3
2 1 1
2 2
3 1     7 ( 4 2 1)

5
1 1 1 1 1
1 1 1 2
1 1 2 1
1 1 3
1 2 1 1
1 2 2
1 3 1      7 
2 1 1 1
2 1 2
2 2 1      
2 3        4
3 1 1        
3 2        2  (7 4 1)

6
1 - 5cnt
2 - 4cnt
3 - 3cnt




*/
