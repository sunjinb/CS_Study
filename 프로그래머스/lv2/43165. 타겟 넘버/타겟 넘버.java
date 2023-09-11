class Solution {
    static int result;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        visited = new boolean[numbers.length];
        powerSet(0, target, numbers);
        answer = result;
        return answer;
    }
    
    public static void powerSet(int idx, int target, int[] numbers){
        if(idx == numbers.length){
            int tmp = 0;
            for(int i = 0; i < numbers.length; i++){
                if(visited[i]) tmp += numbers[i];
                else tmp -= numbers[i];
            }
            
            if(tmp == target) result += 1;
            return;
        }
        
        visited[idx] = true;
        powerSet(idx + 1, target, numbers);
        
        visited[idx] = false;
        powerSet(idx + 1, target, numbers);
    }
}