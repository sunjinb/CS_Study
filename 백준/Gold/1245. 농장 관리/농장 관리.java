import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result;
    static int minHeight = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
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
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    bfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int row, int col, int height) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col));
        visited[row][col] = true;

        boolean flag = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int d = 0; d < 8; d++){
                int nextRow = now.row + delta[d][0];
                int nextCol = now.col + delta[d][1];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;

                if(map[nextRow][nextCol] > height){
                    flag = false;
                }
                else if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == height){
                    visited[nextRow][nextCol] = true;
                    q.add(new Point(nextRow, nextCol));
                }
            }
        }

        if (flag && height > minHeight) {
            result++;
        }
    }
}
