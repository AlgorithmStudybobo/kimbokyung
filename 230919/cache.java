import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> q = new ArrayDeque<>();
        int answer = 0;
        for(int i = 0;i<cities.length;i++){
            String str = cities[i];
            str = str.toUpperCase();
            if(!q.contains(str)){ //not contain
                if(q.size()>=cacheSize)
                    q.poll();
                q.offer(str);
                answer += 5;
            }else{ //contain
                q.remove(str);
                q.offer(str);
                answer += 1;
            }
            if(q.size()>cacheSize) q.poll();
            //0ㅊㅓㄹㅣㄹㅡㄹ ㅇㅜㅣㅎㅏㄴ ㄱㅓㅅ.
        }
        return answer;
    }
}
