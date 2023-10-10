import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = listResult(str1);
        List<String> list2 = listResult(str2);
        
        int cnt1 = list1.size();
        int cnt2 = list2.size();
        
        for(String str : list1){
            if(list2.contains(str)){ //list에 있으면?
                answer++;
                list2.remove(list2.indexOf(str));  //지워
            } 
        }
        
        int entireSize = cnt1 + cnt2 - answer; //교집합 개수
        if(entireSize==0) return 65536; //교집합이 없으면 return 
        answer = (answer * 65536 / entireSize ) ;
        
        return answer;
    }

  // string 집합 만들기.
    public List<String> listResult(String str){
        List<String> result = new ArrayList<>();
        str = str.toUpperCase().replaceAll("[^A-Z]", " ");// 영문자 제외 빈칸으로 치환
        
        for(int i = 0;i<str.length()-1;i++){
            String temp = str.substring(i,i+2);
            if(temp.contains(" ")) continue; //공백 들어가면 넘어가기
            
            result.add(temp); //list에 추가
        }
        return result;
    }
}
