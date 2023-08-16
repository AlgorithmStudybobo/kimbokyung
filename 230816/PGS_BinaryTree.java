// 대영 찬스
class Solution {
    static int cnt;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0;i<numbers.length;i++){
            cnt = 0;
            String str = Long.toBinaryString(numbers[i]); // 입력받은 수를 2진수로 변환
            
            long le = str.length(); long j = 1;
            while(le>0){ // 완전이진트리로 만들기 위해 최대 수 구하는 반복문
                le /= 2; j *=2;
            }
            j--;
            le = str.length();
            for(long k = 0; k < j-le ; k++) ///완전이진트리 제작을 위해 앞에 0붙이기
                str = "0"+str;
            
            binary(str); //이진트리 가능?
          
            if(cnt>0) answer[i] = 0; // cnt로 체크 0이상이면 이진트리로 표현 불가.
            else answer[i] = 1;
        }
        return answer;
    }
    public void binary(String str){
        int len = str.length();
        if(cnt>0) return; ///이전에 이진트리 만들 수 없다고 판단하면 진행하지 않음.
        if(Long.parseLong(str, 2)==0) return; // 이진트리 리프가 0이면 진행하지않음. (ex 128의 리프)
        if(len==1) //(1의 입력이 들어 올 경우를 위한 조건문)
            {if(str.charAt(0)=='0') cnt++;} 
        else if(len==3) //(가장 하단이 들어왔을때 루트체크)
            {if(str.charAt(1)=='0') cnt++;} 
        else { 
            if(str.charAt(len/2)=='0') //(루트 체크)
                {cnt++; return;}
            else { //(루트가 ㄱㅊ다면, 왼쪽 오른쪽 리프 재귀)
                binary(str.substring(0,len/2)); 
                binary(str.substring(len/2+1,len));
            }
        }
    }
}
