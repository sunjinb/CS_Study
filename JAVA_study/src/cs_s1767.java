import java.io.*;
import java.util.*;

public class cs_s1767{
    static int N;
    static int coreCount, min;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Point> core;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Point{
        int row, col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            core = new ArrayList<>();
            coreCount = 0;
            for(int i = 1; i  < N - 1; i++){
                for(int j = 1; j < N - 1; j++){
                    if(map[i][j] == 1) {
                        core.add(new Point(i, j));
                        coreCount++;
                    }
                }
            }

            min = Integer.MAX_VALUE;
            visited = new boolean[core.size()];
            for(int i = coreCount; i >= 0; i--){
                comb(0, 0, i);
                if(min < Integer.MAX_VALUE) break;
            }

            System.out.println("#" + testCase + " " + min);
        }
    }

    private static void comb(int idx, int count, int max) {
        if(count == max){
            dfs(0, 0);
            return;
        }

        for(int i = idx; i < coreCount; i++){
            visited[i] = true;
            comb(i + 1, count + 1, max);
            visited[i] = false;
        }
    }

    private static void dfs(int idx, int count) {
        if(idx == coreCount){
            min = Math.min(min, count);
            return;
        }

        if(!visited[idx]){
            dfs(idx + 1, count);
            return;
        }

        for(int i = 0; i < 4; i++){
            int row = core.get(idx).row;
            int col = core.get(idx).col;
            int lineCount = 0;
            boolean canPut = false;

            while(true){
                row += dRow[i];
                col += dCol[i];
                if(row < 0 || col < 0 || row >= N || col >= N) {
                    canPut = true;
                    break;
                }
                if(map[row][col] != 0) break;
                map[row][col] = -2;
                lineCount++;
            }
            if(canPut) dfs(idx + 1, count + lineCount);
            while(true){
                row -= dRow[i];
                col -= dCol[i];
                if(row == core.get(idx).row && col == core.get(idx).col) break;
                map[row][col] = 0;
            }
        }
    }
}