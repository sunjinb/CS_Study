import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int result = 64;
        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                int tmp = solve(i, j);
                result = Math.min(result, tmp);
            }
        }
        System.out.println(result);
    }

    private static int solve(int row, int col) {
        int firstCount = 0;
        char firstValue = map[row][col];
        for(int i = row; i < row + 8; i++){
            for(int j = col; j < col + 8; j++){
                // 시작점 기준
                if(map[i][j] != firstValue){
                    firstCount++;
                }
                if(firstValue == 'W') firstValue = 'B';
                else firstValue = 'W';
            }
            if(firstValue == 'W') firstValue = 'B';
            else firstValue = 'W';
        }
        return Math.min(firstCount, 64 - firstCount);
    }
}
