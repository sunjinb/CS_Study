import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int goalRow, goalCol;
    static int[][] map;
    static int[][] result;
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    goalRow = i;
                    goalCol = j;
                }
            }
        }

        bfs(goalRow, goalCol);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    sb.append(-1 + " ");
                }
                else{
                    sb.append(result[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int startRow, int startCol) {
        visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();

        visited[startRow][startCol] = true;
        q.add(new Point(startRow, startCol));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;

                // 이미 방문한데면 갈 이유가 없음
                if(visited[nextRow][nextCol]) continue;
                // 0 이면 못감
                if(map[nextRow][nextCol] == 0) continue;

                result[nextRow][nextCol] = result[now.row][now.col] + 1;
                visited[nextRow][nextCol] = true;
                q.add(new Point(nextRow, nextCol));
            }
        }
    }
}
