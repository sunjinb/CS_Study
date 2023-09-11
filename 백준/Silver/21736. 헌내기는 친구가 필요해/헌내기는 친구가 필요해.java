import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static boolean[][] visited;
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

        map = new char[N][M];

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I'){
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int result = 0;

        while(!q.isEmpty()){
            Point now = q.poll();

            if(map[now.row][now.col] == 'P'){
                result++;
            }

            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
                if(map[nextRow][nextCol] == 'X' || visited[nextRow][nextCol]) continue;

                q.add(new Point(nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }
        }

        if(result == 0)
            System.out.println("TT");
        else
            System.out.println(result);
    }
}
