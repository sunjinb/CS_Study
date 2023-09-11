import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_12865 {
    static int N, K;
    static int[] W;
    static int[] V;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N + 1];
        V = new int[N + 1];
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[N + 1][K + 1];
        // i : 물건 , w : 가방의 무게
        for(int i = 1; i <= N; i++){
            for(int w = 1; w <= K; w++){
                // 넣을 수 없는 경우
                if(w < W[i]){
                    // 이전에 넣었던 값이 최대일 수밖에 없음
                    result[i][w] = result[i - 1][w];
                }
                // 넣을 수 있는 경우라면
                else{
                    // 이전까지 넣었던 무게의 최댓값 VS 이전까지 넣었던 무게의 최댓값에서 현재 무게 넣은 값 비교
                    result[i][w] = Math.max(result[i - 1][w], result[i - 1][w - W[i]] + V[i]);
                }
            }
        }
        System.out.println(result[N][K]);
    }
}
