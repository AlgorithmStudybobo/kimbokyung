package bobo;

import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str = br.readLine();
            boolean ck = true;
            Set<Integer> s = new HashSet<Integer>();
            Set<Integer> d = new HashSet<Integer>();
            Set<Integer> h = new HashSet<Integer>();
            Set<Integer> c = new HashSet<Integer>();
            for(int i =0;i<str.length();i=i+3){
            	char c1 = str.charAt(i);
                if(c1=='S'){
                    int temp = Integer.parseInt(str.substring(i+1,i+3));
                    if(s.contains(temp)) {ck = false; break;}
                	s.add(temp);
                }else if(c1=='D'){
                	 int temp = Integer.parseInt(str.substring(i+1,i+3));
                    if(d.contains(temp)) {ck = false; break;}
                	d.add(temp);
                }else if(c1=='H'){
                	 int temp = Integer.parseInt(str.substring(i+1,i+3));
                    if(h.contains(temp)) {ck = false; break;}
                	h.add(temp);
                }
                       else if(c1=='C'){
                	 int temp = Integer.parseInt(str.substring(i+1,i+3));
                    if(c.contains(temp)) {ck = false; break;}
                	c.add(temp);
                }
            }
            int S = (13-s.size()); 
            int D = (13-d.size());
            int H = (13-h.size());
            int C = (13-c.size());
            if(ck)
				System.out.println("#" + test_case+" "+ S+" "+D+" "+H + " " +C);
            else System.out.println("#" + test_case +" ERROR");
		}
	}
}