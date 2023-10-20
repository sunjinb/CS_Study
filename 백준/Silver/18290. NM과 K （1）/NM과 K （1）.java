import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int max;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = Integer.MIN_VALUE;
        solve(0, 0, 0, 0);
        System.out.println(max);
    }

    private static void solve(int curRow, int curCol, int count, int sum){
        if(count == K){
            max = Math.max(max, sum);
            return;
        }

        for(int i = curRow; i < N; i++){
            int tmpCol = 0;
            if(i == curRow) tmpCol = curCol;
            for(int j = tmpCol; j < M; j++){
                if(visited[i][j]){
                    continue;
                }

                boolean flag = true;
                for(int d = 0; d < 4; d++){
                    int nextRow = i + dRow[d];
                    int nextCol = j + dCol[d];

                    if((nextRow >= 0 && nextCol >= 0 && nextRow < N
                            && nextCol < M) && visited[nextRow][nextCol]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    visited[i][j] = true;
                    solve(i, j, count + 1, sum + arr[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }
}
