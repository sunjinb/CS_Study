import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Info{
        int redRow, redCol, blueRow, blueCol, time;
        public Info(int redRow, int redCol, int blueRow, int blueCol, int time) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new char[N][M];
	    int redRow = -1;
	    int redCol = -1;
	    int blueRow = -1;
	    int blueCol = -1;
	    for(int i = 0; i < N; i++) {
	        String str = br.readLine();
	        for(int j = 0; j < M; j++) {
	            map[i][j] = str.charAt(j);
	            if(map[i][j] == 'R') {
	                redRow = i;
	                redCol = j;
	                map[i][j] = '.';
	            }
	            else if(map[i][j] == 'B') {
	                blueRow = i;
	                blueCol = j;
	                map[i][j] = '.';
	            }
	        }
	    }
	    
	    Info start = new Info(redRow, redCol, blueRow, blueCol, 0);
	    Queue<Info> q = new LinkedList<>();
	    
        q.add(start);
        int result = Integer.MAX_VALUE;
	
	    L:while(!q.isEmpty()) {
	        Info now = q.poll();
	        
	        // 10초 넘어가면 그만 해야겠지
	        if(now.time >= 10) break;
	        
	        // 빨간 공, 파란 공의 다음 위치 찾기
	        for(int i = 0; i < 4; i++) {
	            
	            int nextRedRow = now.redRow;
	            int nextRedCol = now.redCol;
	            int nextBlueRow = now.blueRow;
	            int nextBlueCol = now.blueCol;
	            
	            int redMoveCount = 0;
	            int blueMoveCount = 0;
	            boolean redHole = false;
	            boolean blueHole = false;
	            // 일단 빨간 공 기울여보기
	            while(true) {
	                redMoveCount++;
	                nextRedRow += dRow[i];
	                nextRedCol += dCol[i];
	
	                // 빨간 공이 구멍을 잘 찾아서 들어가는 경우
	                if(map[nextRedRow][nextRedCol] == 'O') {
	                    redHole = true;
	                    break;
	                }
	        
	                // 빨간 공이 #으로는 갈 수 없음
	                if(map[nextRedRow][nextRedCol] == '#') {
	                    nextRedRow -= dRow[i];
	                    nextRedCol -= dCol[i];
	                    break;
	                }    
	            }
	            
	            // 일단 파란 공 기울여보기
	            while(true) {
	                blueMoveCount++;
	                nextBlueRow += dRow[i];
	                nextBlueCol += dCol[i];
	                
	                // 파란 공이 구멍에 빠져버린 경우
	                if(map[nextBlueRow][nextBlueCol] == 'O') {
	                    blueHole = true;
	                    break;
	                }
	                
	                if(map[nextBlueRow][nextBlueCol] == '#') {
	                    nextBlueRow -= dRow[i];
	                    nextBlueCol -= dCol[i];
	                    break;
	                }
	            }
	            
	            if(blueHole) continue;
	            
	            // 빨간 공만 빠진 경우 성공
	            if(redHole) {
	                result = Math.min(result, now.time + 1);
	                continue;
	            }
	
	            // 빨간공과 파란공이 같은 위치에는 존재할 수 없음 따라서 많이 온 놈이 한 칸 후진
	            if(nextRedRow == nextBlueRow && nextRedCol == nextBlueCol) {
	                if(redMoveCount <= blueMoveCount) {
	                    nextBlueRow -= dRow[i];
	                    nextBlueCol -= dCol[i];    
	                }
	                else {
	                    nextRedRow -= dRow[i];
	                    nextRedCol -= dCol[i];
	                }
	            }
	            
	            // 빨간 공의 위치가 변화하지 않는다면 작업할 이유가 없음  => 파란 공만 이동해도 새로운 경우의 수 창출
	            //if(nextRedRow == now.redRow && nextRedCol == now.redCol) continue; 
	
	            q.add(new Info(nextRedRow, nextRedCol, nextBlueRow, nextBlueCol, now.time + 1));
	        }
	    }
	    
	    if (result != Integer.MAX_VALUE) System.out.println(result);
	    else System.out.println(-1);
	}
}