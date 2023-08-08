import java.io.*;
import java.util.*;
//6h
public class Main {
    static int[][] arr = new int[11][11];
    static int[] nn = {0,5,5,5,5,5};
    static int ONENUM;
    static int max = 26;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) ONENUM++;
            }
        }
        if(ONENUM<4) {System.out.println(ONENUM); return;}
        dfs(0,0,0,0);
        if(max>25)
            System.out.println(-1);
        else System.out.println(max);

    }
    private static void dfs(int a,int b, int num, int used) {
        if(used>max) return;
        for (int i = a, j = b; i < 10; i++) {
            for (; j < 10; j++) {
                if(arr[i][j]==1) {
                    int findOne = find(i, j);
                    if(num+findOne*findOne==ONENUM) {
                        if(nn[findOne]>0) {
                            if(max>used+1) max = used+1;
                            return;
                        }
                        return;
                    }
                    int check = 0;
                    for (int k = findOne; k >0 ; k--) {
                        if(nn[k]>0) {
                            check++;
                            for (int ia = 0; ia < k; ia++) {
                                for (int jb = 0; jb < k; jb++) {
                                    arr[i+ia][j+jb] = 0;
                                }
                            }
                            int temp = nn[1];
                            nn[k]--;
                            if(k==1) {
                                num++;used++;
                                break;
                            }
                            dfs(i,j+k,num+(k*k),used+1);
                            for (int ia = 0; ia < k; ia++) {
                                for (int jb = 0; jb < k; jb++) {
                                    arr[i+ia][j+jb] = 1;
                                }
                            }
                            nn[k]++;nn[1]= temp;
                        }
                    } arr[i][j]=1;
                    if(check==0) return;
                }
            }j = 0;
        }
    }
    private static int find(int a, int b) { //현재 위치의 1로 이루어진 최대 행렬 찾는 함수.
        int k = 5;
        int j = 0;
        for (int i = 0; i < k; i++) {
            for (j = 0; j < k ; j++) {
                if(arr[a+i][b+j]==0) {
                    k = Math.max(i, j);
                    break;
                }
            }
        }
        return k;
    }

}
