import java.util.*;
import java.util.Map.Entry;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,String> map = new HashMap<String,String>();
        Map<String,Integer> car = new HashMap<String,Integer>();
        for(int i = 0;i<records.length;i++){
            String[] str = records[i].split(" ");
            if(str[2].equals("IN")){
                map.put(str[1],str[0]);
            }else if(str[2].equals("OUT")){
                String[] inTime = map.get(str[1]).split(":");
                String[] outTime = str[0].split(":");
                
                int htimeO = Integer.parseInt(outTime[0]);
                int htimeI = Integer.parseInt(inTime[0]);
                
                int mtimeO = Integer.parseInt(outTime[1]);
                int mtimeI = Integer.parseInt(inTime[1]);
                
                int time = (htimeO-htimeI)*60 +(mtimeO-mtimeI);
                if(car.containsKey(str[1])) car.put(str[1],time+car.get(str[1]));
                else car.put(str[1],time);
                map.remove(str[1]);
            }
        }
        for (Entry<String, String> entrySet : map.entrySet()) {
            String[] inTime = entrySet.getValue().split(":");
                
            int htimeI = Integer.parseInt(inTime[0]);
            int mtimeI = Integer.parseInt(inTime[1]);
                
            int time = (23-htimeI)*60 +(59-mtimeI);
            String carKey = entrySet.getKey();
            if(car.containsKey(carKey)) car.put(carKey,time+car.get(carKey));
            else car.put(carKey, time);
        }
        int[] result = new int[car.size()];
        List<String> keyList = new ArrayList<>(car.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        int i =0;
        for (String key : keyList) {
            int time = car.get(key) - fees[0];
            
            if(time>=0) {
                if(time%fees[2]>0) time = time+fees[2];
                time = time/fees[2] * fees[3];
            }else time = 0;
            result[i++] = time + fees[1];
        }
        return result;
    }
}
