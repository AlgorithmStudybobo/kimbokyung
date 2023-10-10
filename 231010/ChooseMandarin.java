import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0,max = 0;
        for(int i = 0;i<tangerine.length;i++)
            max = Math.max(max, tangerine[i]);
        int[] arr = new int[max + 1];
        for(int i = 0;i<tangerine.length;i++)
            arr[tangerine[i]]++;
        
        Arrays.sort(arr);
        for(int i = max;i>= 0;i--){
            k -= arr[i];
            answer++;
            if(k<=0)
                break;
        }
        return answer;
    }
}
