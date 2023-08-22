import java.io.*;
import java.util.*;

public class Main {
    static int N,K,input[],arr[],sum,dis[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N ; i++) //중복 제거
            set.add(Integer.parseInt(st.nextToken()));
        
        if(N<=K) { System.out.println(0); return;} //센서가 더 많거나 같을 때.
        
        arr = new int[set.size()]; int i = 0;
        for (int s : set) // set의 값을 배열에 저장
            arr[i++] = s;
       
        Arrays.sort(arr); 
        dis = new int[arr.length-1];
        dis[0] = arr[1]-arr[0];
        for (int j = 1; j < arr.length-1; j++) // edge 간의 거리 저장
            dis[j] = arr[j+1]-arr[j];
        
        Arrays.sort(dis);

        for (int j = 0; j < arr.length-K; j++) 
            sum += dis[j];
        
        System.out.println(sum);
    }
//    static void select(int cnt,int start) {
//        if (cnt == K) {
//            int cost = arr[input[0]]-arr[0];
//            for (int i = 1; i < K; i++) {
//                cost += arr[input[i]]-arr[input[i-1]];
//            }
//            min = Math.min(min,cost);
//            return;
//        }
//        for (int i = start; i<arr.length-1; i++) {
//            input[cnt] = i;
//            select(cnt + 1,i+1);
//        }
//    }

//    private static void distance() {
//        int k = 0;
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//
//            while(input[k]<=i){
//                if(k>=input.length-1) break;
//                k++;
//            }
//            if(i==input[k]) continue;
//            if(k==0) sum += Math.abs(arr[input[k]]-arr[i]);
//            else sum += Math.min(Math.abs(arr[input[k]]-arr[i]), Math.abs(arr[i]-arr[input[k-1]]));
//        }
//        min = Math.min(min,sum);
//    }
}
// 조합 (시간초과) --> 좌 우 거리 비교 후 최대 값 삭제 ( 틀림 ) --> 정민찬스 ^.^
