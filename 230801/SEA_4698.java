package bobo;

import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[1000001];
		int N = 1000000;
        prime[1] = true;
        for(int i=2; i*i<=N; i++){
            if(!prime[i]){
            	for(int j=i*i; j<=N; j+=i) prime[j]=true;                
            }        
        }   //에라토스테네스의 체
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = 0;
            for(int i = A;i<=B;i++){
            	String str = Integer.toString(i);
                 if(str.indexOf(d)>=0)
                    if(!prime[i])result++;
			}
            System.out.println("#" + test_case + " " + result);
        }
	}
}