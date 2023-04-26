import java.io.*;
import java.util.*;

class Solution {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static boolean[][] visited;
    static class Point{
        int row, col, depth;
        public Point(int row, int col, int depth){
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    public int solution(int[][] maps) {
        int answer = -1;
        
        visited = new boolean[maps.length][maps[0].length];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            if(now.row == maps.length - 1 && now.col == maps[0].length - 1) {
                answer = now.depth;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                
                if(nextRow < 0 || nextCol < 0 || nextRow >= maps.length || nextCol >= maps[0].length) 
                    continue;
                
                if(visited[nextRow][nextCol]) continue;
                
                if(maps[nextRow][nextCol] == 0) continue; 
                
                visited[nextRow][nextCol] = true;
                q.add(new Point(nextRow, nextCol, now.depth + 1));
            }
        }
        
        return answer;
    }
}