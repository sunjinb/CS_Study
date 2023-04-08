import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int boxCount = Math.min(N, M) / 2;
        int nextN = N, nextM = M;
        for(int i = 0; i < boxCount; i++){
            int elementCount = 2 * nextN + 2 * nextM - 4;
            rotate(i, elementCount);
            nextN -= 2;
            nextM -= 2;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void rotate(int startPoint, int elementCount) {
        int rotateCount = R % elementCount;

        for(int rc = 0; rc < rotateCount; rc++){
            int startValue = map[startPoint][startPoint];

            int dir = 0;
            int row = startPoint;
            int col = startPoint;

            while(dir < 4){
                int nextRow = row + dRow[dir];
                int nextCol = col + dCol[dir];

                if(nextRow < startPoint || nextRow >= N - startPoint || nextCol < startPoint || nextCol >= M - startPoint) {
                    dir++;
                }
                else{
                    map[row][col] = map[nextRow][nextCol];
                    row = nextRow;
                    col = nextCol;
                }
            }

            map[startPoint + 1][startPoint] = startValue;
        }
    }
}
