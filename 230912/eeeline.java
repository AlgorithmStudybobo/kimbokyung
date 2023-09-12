import java.io.*;
import java.util.*;

public class Main {

	static public class Line{
		int from;
		int to;
		Line(int f, int t){
			from = f; to = t;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List<Line> li = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
			li.add(new Line(a,b));
		}
		Collections.sort(li, (o1,o2)->o1.to -o2.to);

    //여기서부터는 상자넣기 
		int[] lines = new int[T];
		int[] dp = new int[T];
		lines[0] = li.get(0).from;
		dp[0] = 1;
		for (int i = 1; i < T; i++) {
			lines[i] = li.get(i).from;
			int m = 0 ;
			for (int j = 0; j < i; j++) {
				if(lines[i]>lines[j]) {
					m = Math.max(m, dp[j]);
				}
			}
			
			dp[i] = m + 1;
			
		}
		int max = 0;
		for (int i = 0; i < T; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(T-max);
	}

}
