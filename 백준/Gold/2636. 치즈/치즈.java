import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int cheeseCount;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Point{
        int row, col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheeseCount++;
            }
        }

        int time = 0;
        int result = 0;
        while(cheeseCount != 0){
            time++;
            result = cheeseCount;
            bfs();
        }

        System.out.println(time);
        System.out.println(result);

    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][M];
        q.add(new Point(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M || visited[nextRow][nextCol]) continue;

                // 공기와 닿아있는 부분이 치즈라면
                if(map[nextRow][nextCol] == 1){
                    cheeseCount--;
                    map[nextRow][nextCol] = 0;
                }
                // 치즈가 아니라면 다른 치즈를 찾으러 감
                else if(map[nextRow][nextCol] == 0){
                    q.add(new Point(nextRow, nextCol));
                }

                visited[nextRow][nextCol] = true;
            }
        }
    }
}
