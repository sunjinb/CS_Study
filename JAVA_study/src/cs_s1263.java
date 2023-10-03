import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_s1263 {
    static int N;
    static int result;
    static final int INF = 1001;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(i != j && arr[i][j] == 0){
                        arr[i][j] = INF;
                    }
                }
            }

            for(int k = 0; k < N; k++){
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        if(arr[i][j] > arr[i][k] + arr[k][j]){
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }

            result = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                int tmp = 0;
                for(int j = 0; j < N; j++){
                    tmp += arr[i][j];
                }
                result = Math.min(result, tmp);
            }

            System.out.printf("#%d %d\n", testCase, result);
        }
    }
}
