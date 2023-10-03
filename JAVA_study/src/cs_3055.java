import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cs_3055 {
    static int R, C;
    static int result;
    static int endRow, endCol;
    static int personRow, personCol;
    static int[][] map;
    static int[][] waterTime;
    static Queue<Point> q;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Point{
        int row, col, depth;
        public Point(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        map = new int[R][C];
        waterTime = new int[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'D'){
                    endRow = i;
                    endCol = j;
                }

                if(map[i][j] == 'S'){
                    personRow = i;
                    personCol = j;
                }

                if(map[i][j] == '*'){
                    q.add(new Point(i, j, 0));
                    visited[i][j] = true;
                    waterTime[i][j] = 0;
                }
            }
        }
        result = Integer.MAX_VALUE;
        waterBfs();
        PersonBfs();

        if(result == Integer.MAX_VALUE) System.out.println("KAKTUS");
        else System.out.println(result);
    }

    private static void PersonBfs() {
        visited = new boolean[R][C];

        visited[personRow][personCol] = true;
        q.add(new Point(personRow, personCol, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.row == endRow && now.col == endCol) {
                result = now.depth;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;

                if(visited[nextRow][nextCol]) continue;

                if(map[nextRow][nextCol] == 'X') continue;

                if((now.depth + 1 < waterTime[nextRow][nextCol]) || (waterTime[nextRow][nextCol] == 0)){
                    visited[nextRow][nextCol] = true;
                    q.add(new Point(nextRow, nextCol, now.depth + 1));
                }
            }
        }
    }

    private static void waterBfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for(int i = 0; i < 4; i++){
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= R || nextCol >= C) continue;

                if(visited[nextRow][nextCol]) continue;

                if(map[nextRow][nextCol] == 'D' || map[nextRow][nextCol] == 'X') continue;

                visited[nextRow][nextCol] = true;
                waterTime[nextRow][nextCol] = now.depth + 1;
                q.add(new Point(nextRow, nextCol, now.depth + 1));
            }
        }
    }
}
