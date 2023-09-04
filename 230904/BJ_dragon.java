import java.io.*;
import java.util.*;
	
public class Main {
	static List<Integer> dragon[];
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int N, positions[][],gmax;
	static boolean map[][];
  
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		positions = new int[N][4];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			positions[i][0] = Integer.parseInt(st.nextToken());
			positions[i][1] = Integer.parseInt(st.nextToken());
			positions[i][2] = Integer.parseInt(st.nextToken());
			positions[i][3] = Integer.parseInt(st.nextToken());
			gmax = Math.max(gmax, positions[i][3]);
		}

    //드래곤 커브 선 입력
		dragon = new ArrayList[gmax+1];
		dragon[0] = new ArrayList<>(); //0세대 초기화
		dragon[0].add(0);              //0세대 입력
		for (int i = 1; i < gmax+1; i++) { //세대마다 입력
			dragon[i] = new ArrayList<>();
			for (int j = 0; j < dragon[i-1].size(); j++)  //이전 세대 복사
				dragon[i].add(dragon[i-1].get(j));
			for (int j = dragon[i-1].size()-1; j >= 0 ; j--) { //이전세대 반대로 입력
				int input = (dragon[i-1].get(j) + 1)%4;
				dragon[i].add(input);
			}//System.out.println(dragon[i].toString());
		}
		map = new boolean[101][101]; 
		for (int i = 0; i < N; i++) { //입력받은 세대로 드래곤 만들기
			curve(i);
		}
		System.out.print(mapcheck()); //칸마다 확인하는 함수 
	}
	private static int mapcheck() {
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]&&map[i+1][j]&&map[i][j+1]&&map[i+1][j+1]){
					cnt++;  //사방이 true이면 숫자 상승
				}
			}
		}
		return cnt;
	}
	private static void curve(int index) {
		int y = positions[index][0];
		int x = positions[index][1];
		int d = positions[index][2];
		int g = positions[index][3];
		
		for (int i = 0; i < dragon[g].size(); i++) { 
			map[x][y] = true;
			int toD = (dragon[g].get(i)+d)%4;   // 다음 방향
			x = x + dx[toD];  //바꾼 방향으로 직진
			y = y + dy[toD];
			//System.out.println(tx+ "//"+ty);
			map[x][y] = true; //드래곤 만들기
		}
	}

}
