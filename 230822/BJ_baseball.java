import java.io.*;
import java.util.*;

public class Main {
    static int[][] inning;
    static int[] input = new int[]{1,2,3,0,4,5,6,7,8};
    static boolean[] isvisited=new boolean[9];
    static int T, max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        inning = new int[T][9];
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                inning[t][i] = Integer.parseInt(st.nextToken());
            }
        }
        //9명 순열
        permutation(0);
        System.out.println(max);
    }

    private static void npc(int cnt) { // 순열을 돌리자
        if(cnt == 9) {
            baseball();
            return;
        }
        for(int i=0; i<9; i++) {
            if(isvisited[i]) continue;
            input[i] = cnt;

            isvisited[i] = true;
            npc(cnt+1);
            isvisited[i] = false;
        }
    }

    static void permutation(int depth) {
        if (depth == 9) {
            baseball(); return;
        }
        if(depth==3) {
            permutation(depth+1); return;
        }
        for (int i = depth ; i < 9; i++) {
            if(i==3) continue;
            swap(depth, i);
            permutation(depth + 1);
            swap(depth, i);
        }
    }
    static void swap(int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
    private static void baseball() {
        int cur = 0, score = 0;
        //Queue<Boolean> q = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            int out = 0;//q.clear();
            int[] base = new int[3];
            while(out < 3){
                if(cur==9) cur %= 9;
                switch(inning[i][input[cur++]]){
                    case 3:
//                        while (!q.isEmpty()) {
//                            if (q.poll()){
//                                score++;
//                            }
//                        }
                        score += base[0]+base[1]+base[2];
                        base = new int[]{0,0,1};
                       // q.offer(true); q.offer(false); q.offer(false);
                        break;

                    case 2:
                        /*while (q.size()>1) {
                            if (q.poll())
                                {score++;}
                        } q.offer(true); q.offer(false);*/
                        score += base[1]+base[2];
                        base = new int[]{0,1,base[0]};
                        break;

                    case 1:
//                        if(q.size()>2) {
//                            if (q.poll())
//                                score++;
//                        }
//                        q.offer(true);
                        score += base[2];
                        base = new int[]{1,base[0],base[1]};
                        break;
                    case 4:
//                        while(!q.isEmpty()) {
//                            if (q.poll())
//                                score++;
//                        }
//                        score++;
                        score += base[0]+base[1]+base[2]+1;
                        base = new int[3];
                        break;
                    case 0:
                        out++;
                        break;
                }
            }
        } max = Math.max(max, score);
    }
}

// 1. 아웃 되었을때 모든 베이스가 리셋되는 줄 알고 test check +3H
// 2. 1의 수정 후 시간초과 --> BASE를 queue로 저장 했는데 간단한 숫자는 변수로 저장하는게 빠르다는걸 잘 알게 됨^.^
