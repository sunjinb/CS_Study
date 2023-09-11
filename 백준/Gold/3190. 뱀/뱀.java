import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static ArrayList<Point> snakeList;
    // 하 좌 상 우
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, -1, 0, 1};
    static class Point{
    	int row, col;
    	public Point(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}
    }
    static HashMap<Integer, String> moveMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            // 사과 지도에 표시
            map[row][col] = 1;
        }

        moveMap = new HashMap<>();
        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            moveMap.put(X, C);
        }

        snakeList = new ArrayList<>();
        snakeList.add(new Point(0, 0));
        int dir = 3;
        int time = 0;
        L :while(true) {
        	// 시간 1초씩 증가
        	time++;
        	
        	// 다음 머리 좌표 구하기
        	int nextRow = snakeList.get(snakeList.size() - 1).row + dRow[dir];
        	int nextCol = snakeList.get(snakeList.size() - 1).col + dCol[dir];
        	
//        	System.out.println("time : " + time + " dir : " + dir);
//        	for(int i = 0; i < snakeList.size(); i++) {
//        		System.out.println("row : " + snakeList.get(i).row + " col : " + snakeList.get(i).col);
//        	}
        	
        	// 다음 머리좌표가 벽이랑 만나면 종료
        	if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N) break;
        	
        	// 다음 머리좌표가 몸이랑 만나면 종료
        	for(int i = 0; i < snakeList.size(); i++) {
        		if(nextRow == snakeList.get(i).row && nextCol == snakeList.get(i).col) {
        			break L;
        		}
        	}
        	
        	// 머리를 늘려 다음칸에 위치 시킨다
        	snakeList.add(new Point(nextRow, nextCol));
        	
        	// 다음 머리좌표에 사과가 있다면
        	if(map[nextRow][nextCol] == 1) {
        		// 사과 없애기
        		map[nextRow][nextCol] = 0;
        	}
        	// 다음 머리좌표에 사과가 없다면
        	else {
        		// 꼬리 자르기
        		snakeList.remove(0);
        	}
        	
        	// 회전해야하는 시점이라면
        	if(moveMap.containsKey(time)) {
        		if(moveMap.get(time).equals("L")) {
        			dir--;
        			if(dir == -1) dir = 3;
        		}
        		else if(moveMap.get(time).equals("D")) {
        			dir++;
        			if(dir == 4) dir = 0;
        		}
        	}
        }
        
        System.out.println(time);

    }
}