package bobo;

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = br.readLine();
            int now = 0;
            int plus = 0;
            for(int i = 0;i<str.length();i++){
           	 	int p = str.charAt(i) - '0';
                if(p == 0) continue;
                if(i>now){
                	plus += (i - now);
                    now += (i - now);
                }
                now += p;
            }
            System.out.println("#" + test_case + " " +plus);
		}
	}
}