import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_1520 {
    static int N, M;
    static int result;
    static int[][] map;
    static int[][] count;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        count = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int row, int col) {
        if(row == N - 1 && col == M - 1){
            return 1;
        }

        if(visited[row][col]){
            return count[row][col];
        }
        else{
            visited[row][col] = true;

            for(int i = 0; i < 4; i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;

                if(map[nextRow][nextCol] < map[row][col]){
                    count[row][col] += dfs(nextRow, nextCol);
                }
            }
        }
        return count[row][col];
    }
}
