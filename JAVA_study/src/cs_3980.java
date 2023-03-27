import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_3980 {
    static final int N = 11;
    static int max;
    static boolean[] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){

            map = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            visited = new boolean[N];
            dfs(0, 0);
            System.out.println(max);
        }
    }

    private static void dfs(int row, int sum) {
        if(row == N){
            if(max < sum) max = sum;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i] && map[row][i] != 0){
                visited[i] = true;
                dfs(row + 1, sum + map[row][i]);
                visited[i] = false;
            }
        }
    }
}
