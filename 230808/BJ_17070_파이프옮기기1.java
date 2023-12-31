package bobo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//30min
public class BJ_17070 {
	static int route = 0;
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// n x n 행렬 입력 받기
		arr= new int[N+2][N+2];
		for (int i = 1; i <N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행렬의 경계를 1로 채우기 (벽처럼 하도록)
		for (int i = 0; i <N+1; i++) {
			arr[0][i] = 1; arr[N+1][i] = 1;
			arr[i][0] = 1; arr[i][N+1] = 1;
		}
		
		findRoad(1,1,1,2);
		System.out.println(route);
	}
	public static void findRoad(int aS, int bS, int aE, int bE) {
		if(aE==N&&bE==N) {
			route++;
			return;
		}
		int wid = bE-bS; // 파이프 끝의 가로 차이
		int hei = aE-aS; // 파이프 끝의 세로 차이
		
		if(arr[aE][bE+1]==0 && arr[aE+1][bE]==0 && arr[aE+1][bE+1]==0) { 
      //대각선 (가로형, 세로형, 대각선형 파이프 모두 대각선방향으로 이동 가능)
			findRoad(aE,bE,aE+1,bE+1); 
		}
		if(wid==1) { //가로형은 가로방향으로 이동 + 대각선형도 able
			//System.out.println("-");
			if(arr[aE][bE+1]==0) {
				findRoad(aE,bE,aE,bE+1);
			}
		}
		if(hei==1) { //세로형은 세로방향으로 이동 + 대각선형도 able
			//System.out.println("|");
			if(arr[aE+1][bE]==0) {
				findRoad(aE,bE,aE+1,bE);
			}
		}
	}

}
