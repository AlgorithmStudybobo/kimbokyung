import java.util.*;
class Solution {
    static int emoSize, member, profit;
    static int[] input, emoticon;
    static int[][] user;
    public int[] solution(int[][] users, int[] emoticons) {
        emoSize = emoticons.length; emoticon = emoticons; user = users;
        input = new int[emoSize]; member = 0; profit = 0;
        int[] answer = new int[2];
        
        sol(0);
        answer[0] = member; answer[1] = profit;
        return answer;
    }

    public void sol(int cnt){ //모든 경우의 수 조합
        if(cnt == emoSize){
             buy(); // 조합 되면? buy
             return;
        }
        for(int i = 0 ; i < 4; i++){
            input[cnt] = (i+1)*10; //10 20 30 40
            sol(cnt+1);
        }
    }
    public void buy(){
        int sell = 0, join = 0; 
        for(int i = 0;i < user.length;i++){
            int sum = 0;
            for(int j = 0;j<emoSize;j++){
                if(user[i][0]<=input[j]){
                    sum += emoticon[j]/100 * (100-input[j]); //할인율 적용해서 sum 확인
                }
            }
            if(sum>=user[i][1]) join++; // 회원 조건 확인
            else sell += sum;
        }
        if(member<join) {member = join; profit = sell;}
        else if(member==join&&profit<sell) {profit = sell;}
    }
}
