import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            int tmp = tangerine[i];
            
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            list.add(map.get(key));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int curValue = 0;
        for(int i = 0; i < list.size(); i++){
            answer++;
            
            curValue += list.get(i);
            
            if(curValue >= k) break;
        }
        
        return answer;
    }
}