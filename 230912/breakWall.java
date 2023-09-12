import java.io.*;
import java.util.*;

public class Main {
	static int N,M,map[][],min;
	static boolean visited[][];
	static boolean Bvisited[][];
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		map = new int[N][M];visited = new boolean[N][M];Bvisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (str.charAt(j) - '0');
			}
		}
		Bvisited[0][0] = true;visited[0][0] = true;
		bfs(); 
		if(min == 0)
			System.out.println(-1);
		else System.out.println(min);
	}
	private static void bfs() {
		Deque<int[]> q = new ArrayDeque();
		q.offer(new int[]{0,0,0});
		int cnt = 0;
		while(!q.isEmpty()) {
			int qsize = q.size(); 
			cnt++;
			for (int i = 0; i < qsize; i++) {
				int[] arr = q.poll();
				int a = arr[0], b = arr[1], broke = arr[2];
				if(a==N-1&&b==M-1) {
					q = new ArrayDeque();
					min = cnt;
					break;
				}
				if(broke == 1)
					Bvisited[a][b] = true;
				else visited[a][b] = true;
				for (int d = 0; d < 4; d++) {
					int x = dx[d] + arr[0];
					int y = dy[d] + arr[1];
					
					if(x<0||y<0||x>=N||y>=M||visited[x][y]) continue;
					if(broke==1) {
						if(map[x][y]==1||Bvisited[x][y]) continue;
						Bvisited[x][y] = true;
						q.offer(new int[]{x,y,1});
					}else {
						if(map[x][y]==1) {
							Bvisited[x][y] = true;
							q.offer(new int[]{x,y,1});
						}else {
							visited[x][y] = true;
							q.offer(new int[]{x,y,broke});
						}
					}
				}
			}
		}
	}

}
