class Solution {
    public int[] solution(int n) {
        int k = 0, index = 0, num = 1,triangle = 0;
        for(int i = 1;i<=n;i++) // 달팽이 갯수 체크
            k += i;
        int[] answer = new int[k];
        while(num <= k){ //달팽이 갯수만큼 순회
            for(int i = 1;i<=n;i++){ //삼각형 왼쪽변
                answer[index] = num++;
                if(i == n) break;
                index += i + triangle*2;
            }
            if(num > k) break;
            for(int i = 1;i<n;i++){ //삼각형 하단 변
                answer[++index] = num++;
            }
            if(num > k) break;
            for(int i = n ;i>2;i--){ //삼각형 우측변
                index -= i + triangle*2;
                answer[index] = num++;
            }
            triangle++; n-=3;
            index += triangle*2;
        }
        return answer;
    }
}
