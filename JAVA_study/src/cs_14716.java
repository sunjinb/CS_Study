import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_14716 {
    static int M, N;
    static int[][] map;
    static int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int row, int col) {
        map[row][col] = -1;

        for(int i = 0; i < 8; i++){
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if(nextRow < 0 || nextCol < 0 || nextRow >= M || nextCol >= N) continue;

            if(map[nextRow][nextCol] == 1){
                dfs(nextRow, nextCol);
            }
        }
    }
}
