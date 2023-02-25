import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[][] map;
	static int min;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static boolean[][] Pvisited;
	static boolean[][] NPvisited;
	
    static class Point{
        int row;
        int col;
        int depth;
        boolean destroyed;

        public Point(int i, int j, int cnt, boolean d) {
            this.row = i;
            this.col = j;
            this.depth = cnt;
            this.destroyed = d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		Pvisited = new boolean[N][M];
		NPvisited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		bfs(0, 0, 1, false);
		
    }


	private static void bfs(int row, int col, int depth, boolean destroyed) {
		Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(row, col, depth, destroyed));
        Pvisited[row][col] = true;
        
        boolean[][] visited = new boolean[N][M];

        while (!q.isEmpty()) {
        	
            Point curPoint = q.poll();

            if (curPoint.row == N - 1 && curPoint.col == M - 1) {
                System.out.println(curPoint.depth);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curPoint.row + dRow[i];
                int nextCol = curPoint.col + dCol[i];

                if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;

                if(map[nextRow][nextCol]=='0'){ // 벽이 아니면
                	if(!curPoint.destroyed && !Pvisited[nextRow][nextCol]) {
                		 q.add(new Point(nextRow, nextCol, curPoint.depth + 1, curPoint.destroyed));
                         Pvisited[nextRow][nextCol] = true;
                	}
                	else if(curPoint.destroyed && !NPvisited[nextRow][nextCol]) {
               		 q.add(new Point(nextRow, nextCol, curPoint.depth + 1, true));
                        NPvisited[nextRow][nextCol] = true;
               	}
                	

                }else if(map[nextRow][nextCol]=='1'){ // 벽이면
                    if(!curPoint.destroyed){ // 한번도 벽을 부순적이 없다면 부순다
                        q.add(new Point(nextRow, nextCol, curPoint.depth + 1, true));
                        NPvisited[nextRow][nextCol] = true;
                    }
                }
            }

        }

        System.out.println(-1);
		
	}
}