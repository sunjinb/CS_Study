import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cs_11403 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++){ // 경유지
            for(int i = 0; i < N; i++){ // 출발지
                for(int j = 0; j < N; j++){ // 도착지
                    // 출발지 -> 목적지 존재한다면
//                    if(arr[i][j] == 1){
//                        arr[i][j] = 1;
//                    }
                    // 출발지 -> 경유지 -> 목적지 존재한다면
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
