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
            String[] str = new String[5];
            int maxLen = 0;
 			for(int i =0;i<5;i++){
            	str[i] = br.readLine();
                if(maxLen<str[i].length()) maxLen = str[i].length();
            }
            System.out.print("#"+test_case+" ");
            for(int i =0;i<maxLen;i++){
            	for(int k =0;k<5;k++){
                	if(str[k].length()>i) System.out.print(str[k].charAt(i));
                }
            }
            System.out.println();
            
		}
	}
}