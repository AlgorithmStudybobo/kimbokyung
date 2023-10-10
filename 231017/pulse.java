import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long[] dp = new long[sequence.length+1]; 
        dp[0] = sequence[0];
        int pulse = -1;

        for(int i = 1 ;i<sequence.length;i++){    // 구간 합
            dp[i] = pulse * sequence[i] + dp[i-1];
            pulse *= (-1);
        }
        
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        
        for (int i = 0; i < dp.length; i++) { 
			if (dp[i] > max)  max = dp[i];
			
			if (dp[i] < min)  min = dp[i];
		}
        return Math.abs(max-min); //dp에서 최대 - 최소
    }
}
