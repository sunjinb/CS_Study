import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dCol = {-2, -1, 1, 2, 2, 1, -1, -2};
    static class Point{
        int row, col, depth;
        public Point(int row, int col, int depth){
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        map = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][N + 1];

        q.add(new Point(startRow, startCol, 0));
        visited[startRow][startCol] = true;
        HashMap<Point, Integer> map = new HashMap<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            map.put(new Point(endRow, endCol, 0), i);
        }

        int[] result = new int[M];

        while(!q.isEmpty()){
            Point now = q.poll();

            for (Point tmp : map.keySet()) {
                if(tmp.row == now.row && tmp.col == now.col){
                    result[map.get(tmp)] = now.depth;
                    break;
                }
            }

            for(int i = 0; i < 8; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 1 || nextCol < 1 || nextRow > N || nextCol > N) continue;

                if(visited[nextRow][nextCol]) continue;

                q.add(new Point(nextRow, nextCol, now.depth + 1));
                visited[nextRow][nextCol] = true;
            }
        }
        for(int i = 0; i < M; i++){
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}
