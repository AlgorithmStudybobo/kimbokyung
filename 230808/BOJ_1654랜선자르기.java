import java.io.*;
import java.util.*;

// cutting Lan line
// 3h
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long sum =0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum +=arr[i];
        }
        long max = sum/N+1;
        long min = 1;
        //long mid = max;
        while(max>min) {
            //System.out.println("max : " + max + " min : "+min);
            long able = 0;
            long mid = (max+min)/2;
            for (int i = 0; i <K; i++) {
                able += arr[i]/mid;
            }


            if(able>=N) min = mid+1;
            else max = mid;
        }
        System.out.println(min-1);
    }
}
