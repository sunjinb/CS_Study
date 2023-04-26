import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2){
                return Integer.compare(o1, o2);
            }
        });
        
        for(int i = 0; i < scoville.length; i++){
            q.add(scoville[i]);
        }
    
        int mixCount = 0;
        while(!q.isEmpty()){
            
            if(q.peek() >= K){
                answer = mixCount;
                break;
            }
            
            mixCount++;
            int min1 = q.poll();
            
            if(q.size() == 0){
                break;
            }
            
            int min2 = q.poll();
            
            int mix = min1 + min2 * 2;
            q.add(mix);
            
        }
        
        return answer;
    }
}