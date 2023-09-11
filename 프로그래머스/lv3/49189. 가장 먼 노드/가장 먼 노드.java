import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static class Node{
        int point, depth;
        public Node(int point, int depth){
            this.point = point;
            this.depth = depth;
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int curMaxDepth = 0;
        
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            list[from].add(to);
            list[to].add(from);
        }
        
        visited = new boolean[n + 1];
        Queue<Node> q = new LinkedList<>();
        visited[1] = true;
        q.add(new Node(1, 0));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.depth == curMaxDepth){
                answer++;
            }
            
            if(curMaxDepth < now.depth){
                curMaxDepth = now.depth;
                answer = 1;
            }
            
            for(int next : list[now.point]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new Node(next, now.depth + 1));
                }
            }
        }

        return answer;
    }
}