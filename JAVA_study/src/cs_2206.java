import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cs_2206 {
    static int M, N;
    static int[][] map;
    static int[][] visited;
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, distance;
        int drill; // 공사 횟수

        public Point(int x, int y, int distance, int drill) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                visited[i][j] = 9999;
            }
        }

        answer = 9999;
        bfs(0, 0);
        if(answer >= 9999) System.out.println(-1);
        else System.out.println(answer);

    }

    public static void bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(row, col, 1, 0));
        visited[row][col] = 0;

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == M - 1 && point.y == N - 1) {
                answer = point.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int next_row = point.x + dx[i];
                int next_col = point.y + dy[i];

                if (next_row < 0 || next_row >= M || next_col < 0 || next_col >= N) {
                    continue;
                }

                if(visited[next_row][next_col] <= point.drill){
                    continue;
                }

                if(map[next_row][next_col] == 0){
                    visited[next_row][next_col] = point.drill;
                    q.add(new Point(next_row, next_col, point.distance + 1, point.drill));
                }
                else{
                    if(point.drill == 0){
                        visited[next_row][next_col] = point.drill + 1;
                        q.add(new Point(next_row, next_col, point.distance + 1, point.drill + 1));
                    }
                }
            }
        }
    }
}