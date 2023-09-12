import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int chX, int chY, int itemX, int itemY) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int[][] map = new int[102][102];

      // 사각형 1로 채우기 
        for(int i = 0;i<rectangle.length;i++)
            for(int x = rectangle[i][0]*2;x<=rectangle[i][2]*2;x++)
                for(int y = rectangle[i][1]*2;y<=rectangle[i][3]*2;y++)
                    map[x][y] = 1;
      // 사각형 내부 0으로 가득가득 그럼 경계만 남음
        for(int i = 0;i<rectangle.length;i++)
            for(int x = rectangle[i][0]*2+1;x<rectangle[i][2]*2;x++)
                for(int y = rectangle[i][1]*2+1;y<rectangle[i][3]*2;y++)
                    map[x][y] = 0;

      // 경계 시작부분에서 양방향으로 보내고 먼저 도착하면 return;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{chX*2,chY*2,0});
        while(!q.isEmpty()){
            int[] arr = q.poll();
            map[arr[0]][arr[1]] = 0; 
            if(map[itemX*2][itemY*2] == 0 ) return arr[2]/2;
            for(int d = 0;d<4;d++){
                int a = dx[d] + arr[0]; int b = dy[d] + arr[1];
                if(a<0||b<0||a>=102||b>=102) continue;
                if(map[a][b] == 1) q.offer(new int[]{a,b,arr[2]+1});
            }
        }
        return -1;
    }
}
