package bobo;

import java.io.*;
import java.util.*;

//2~3h
public class BJ_4179 {
	static int R,C;
	static char[][] arrChar;
	static boolean[][] isCheck;
	static Queue<int[]> queue;
	static Queue<int[]> fire;
	static int nowTime, exitTime;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arrChar =  new char[R][C];
		isCheck =  new boolean[R][C];
		queue = new LinkedList<>();
		fire = new LinkedList<>();
		
		//input data store
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arrChar[i][j] =str.charAt(j);
				if(arrChar[i][j]=='F') fire.offer(new int[] {i,j});
				else if (arrChar[i][j]=='J') {
					arrChar[i][j] = '.';
					queue.offer(new int[] {i,j});
					isCheck[i][j] = true;
				}
			}
		}
		exitTime = 0; nowTime = 0;
		bfs();
		
		if(exitTime==0) System.out.println("IMPOSSIBLE");
		else System.out.println(exitTime);
		
	}
	private static void bfs() {
		if(exitTime>0) {
			return;
		}
		// fire bigger
		int fsize = fire.size(); 
		for(int k = 0;k<fsize;k++) {
			int[] arrij = fire.poll();
			int i = arrij[0]; int j = arrij[1];
			
			//범위 내에 새로운 F 공간을 queue에 넣기 + F저장
			if(i-1>=0&&arrChar[i-1][j]=='.')
				{arrChar[i-1][j] = 'F'; fire.offer(new int[]{i-1,j});}
			if(j-1>=0&&arrChar[i][j-1]=='.')
				{arrChar[i][j-1] = 'F'; fire.offer(new int[]{i,j-1});}
			if(i+1<R&&arrChar[i+1][j]=='.')
				{arrChar[i+1][j] = 'F'; fire.offer(new int[]{i+1,j});}
			if(j+1<C&&arrChar[i][j+1]=='.')
				{arrChar[i][j+1] = 'F'; fire.offer(new int[]{i,j+1});}
			
		} nowTime++;
	
		//jihoon check
		int size = queue.size();
		if(size==0) return;
		for(int k = 0;k<size;k++) {
			int[] curQ = queue.poll();
			//사방탐색
			for (int i = 0; i < 4; i++) {
				int x = curQ[0]+ dx[i];
				int y = curQ[1]+ dy[i];
				
				//범위 넘어가면 갱신 해주기 BFS이므로 가장 먼저나온 숫자가 답 
				if(x<0||y<0||x>R-1||y>C-1) {
					exitTime = nowTime;
					return;
				}
				
				if(isCheck[x][y]) continue;
				if(arrChar[x][y]=='.') //갈 수 있으면 queue에 위치 넣기 + 간곳 체크
				{
					queue.offer(new int[]{x,y});
					isCheck[x][y] = true;
				}
			}
		}
		bfs();
	}

}
